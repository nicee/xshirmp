package psn.lotus.sys;

/**
 * @project lotus
 * @time 2016/10/26 14:12
 */
public class ThreadNotifyTest {

    private Boolean[] notified = {Boolean.FALSE};

    class NotifyThread extends Thread {
        public NotifyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 通知其他线程
            synchronized (notified) {
                // 赋值操作会改变原有对象的引用, 调用notify方法时会发生错误
                // notified = Boolean.TRUE;
                notified[0] = Boolean.TRUE;
                //notify执行的对象不能改变原引用
                notified.notifyAll();
                System.out.println(getName() + " 通知其他线程开始工作...");
            }
        }
    }

    class WaitThread extends Thread {
        public WaitThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (notified) {
                while (notified[0].equals(Boolean.FALSE)) {
                    System.out.println(getName() + " 线程开始运行...");
                    long waitTime = System.currentTimeMillis();
                    try {
                        notified.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    waitTime = System.currentTimeMillis() - waitTime;
                    System.out.println(getName() + " 等待耗时: " + waitTime);
                }
                System.out.println(getName() + " 线程执行完成...");
            }
        }

    }

    public static void main(String[] args) {
        ThreadNotifyTest test = new ThreadNotifyTest();
        NotifyThread notifyThread1 = test.new NotifyThread("Notify1* ");
        WaitThread waitThread1 = test.new WaitThread("Wait1* ");
        WaitThread waitThread2 = test.new WaitThread("Wait2* ");
        WaitThread waitThread3 = test.new WaitThread("Wait3* ");

        notifyThread1.start();
        waitThread1.start();
        waitThread2.start();
        waitThread3.start();
    }

}
