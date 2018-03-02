package psn.lotus.web.service;

import org.springframework.scheduling.annotation.Async;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @project lotus
 * @time 2018/1/18 17:36
 */
//@Component
public class SchedulerService {

    /**
     * 每1秒中执行一次
     */
    @Async
//    @Scheduled(cron = "0/1 * * * * ?")
    public void execute() {
        Thread thread = Thread.currentThread();
        String threadName = thread.getName();
        String groupName = thread.getThreadGroup().getName();
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

        System.out.println(dateFormat.format(calendar.getTime()) + ": group: "
                + groupName + "[thread: " + threadName + "] is running... testing sleep for 2 seconds.");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(dateFormat.format(calendar.getTime()) +
                    ": group: " + groupName + "[thread: " + threadName + "] work over.");
        }
    }

}
