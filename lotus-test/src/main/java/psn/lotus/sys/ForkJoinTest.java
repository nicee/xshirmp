package psn.lotus.sys;

import java.util.concurrent.CompletableFuture;

/**
 * @project lotus
 * @time 2018/1/15 15:47
 */
public class ForkJoinTest {

    public static void main(String[] args) throws Exception {
        int test = 100, i = 0;
        while (i < test) {
            final int j = i;
            CompletableFuture.runAsync(() -> {
                System.out.println("In async running, flag: " + j);
            });
            i++;
        }
        System.out.println("Last value of i is: " + i);
    }

}
