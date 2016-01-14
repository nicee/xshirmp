package psn.lotus.cp.util;

/**
 * @author: nicee
 * @since: 2016/1/13
 */
public class Utils {

    public static boolean isZero(int dd) {
        return dd % 3 == 0;
    }

    public static boolean isOne(int dd) {
        return dd % 3 == 1;
    }

    public static boolean isTwo(int dd) {
        return dd % 3 == 2;
    }

    public static int sumUnit(int dd, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += getNum(dd, i, i + 1);
        }
        return sum;
    }

    public static int getSpan(int dd, int start, int end) {
        return sumUnit(dd, start, end) % 10;
    }

    private static int getNum(int dd, int start, int end) {
        String strNum = String.valueOf(dd);
        return Integer.parseInt(strNum.substring(start, end));
    }

}
