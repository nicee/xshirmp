package psn.lotus.cp.util;

/**
 * @author: nicee
 * @since: 2016/1/27
 */
public class RoadUtils {
    static final int R_ONE = 1;
    static final int R_TWO = 2;
    static final int R_ZERO = 0;

    public static boolean isOne(int num) {
        return num % 3 == R_ONE;
    }

    public static boolean isTwo(int num) {
        return num % 3 == R_TWO;
    }

    public static boolean isZero(int num) {
        return num % 3 == R_ZERO;
    }

}
