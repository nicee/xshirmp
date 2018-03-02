package psn.lotus.sys;

import java.util.Arrays;

/**
 * @project lotus
 * @time 2018/2/26 16:53
 */
public class ArrayCopyCompareTest {

    private static final byte[] buffer = new byte[1024 * 10];

    static {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = (byte) (i & 0xFF);
        }
    }

    private static long startTime;

    public static void main(String[] args) {
        startTime = System.nanoTime();
        byte[] newBuffer = new byte[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            newBuffer[i] = buffer[i];
        }
        calcTime("forCopy");

        startTime = System.nanoTime();
        byte[] newBuffer2 = buffer.clone();
        calcTime("cloneCopy");

        startTime = System.nanoTime();
        byte[] newBuffer3 = Arrays.copyOf(buffer, buffer.length);
        calcTime("arraysCopyOf");

        startTime = System.nanoTime();
        byte[] newBuffer4 = new byte[buffer.length];
        System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
        calcTime("systemArraycopy");
    }

    private static void calcTime(String type) {
        long endTime = System.nanoTime();
        System.out.println(type + " cost " +(endTime-startTime)+ " nanosecond");
    }

}
