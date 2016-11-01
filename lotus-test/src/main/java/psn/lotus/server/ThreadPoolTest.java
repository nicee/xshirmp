package psn.lotus.server;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: nicee
 * @since: 2016/1/14
 */
public class ThreadPoolTest {

    static volatile transient AtomicInteger count = new AtomicInteger(0);

    @Test
    public void test() {
        int cpuNums = Runtime.getRuntime().availableProcessors();
        System.out.println("当前服务器CPU个数为: " + cpuNums);

        ExecutorService service = Executors.newSingleThreadExecutor();

        while (count.get() < 100) {
            service.execute(new Runnable() {
                public void run() {
                    count.addAndGet(1);
                    System.out.println("当前执行次数为: " + count.get());
                }
            });
        }

        System.out.println("当前count值: " + count.get());

        service.shutdown();

    }

}
