package psn.lotus.cp.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nicee
 * @since: 2016/1/28
 */
public class FilterUtils2 {

    static List<String> all = new ArrayList<String>();

    static {
        for (int i = 0; i < 100; i++) {
            all.add((i < 10) ? "0" + i : "" + i);
        }
    }

    public static List<String> filterNumber(String num) {
        List<String> result = new ArrayList<String>(all);
        removeBoth(result, getBothNum(num));
        removeHead(result, getHeadNum(num));
        removeTail(result, getTailNum(num));
        return result;
    }

    public static void filterSummary(List<String> src, String num) {
        List<String> tmp = new ArrayList<String>(src);
        Integer sum = calSum(num);
        for (String str : tmp) {
            Integer t = Integer.parseInt(str.substring(0, 1));
            Integer g = Integer.parseInt(str.substring(1, 2));
            int tSum = t + g;
            if (Math.abs(tSum - sum) > 10) {
                src.remove(str);
            }
        }
    }

    private static void removeBoth(List<String> src, String remove) {
        List<String> tmp = new ArrayList<String>(src);
        for (String num : tmp) {
            if (num.contains(remove)) {
                src.remove(num);
            }
        }
    }

    private static void removeHead(List<String> src, String remove) {
        List<String> tmp = new ArrayList<String>(src);
        for (String num : tmp) {
            if (num.indexOf(remove) == 0) {
                src.remove(num);
            }
        }
    }

    private static void removeTail(List<String> src, String remove) {
        List<String> tmp = new ArrayList<String>(src);
        for (String num : tmp) {
            if (num.indexOf(remove) == 1) {
                src.remove(num);
            }
        }
    }

    private static String getBothNum(String num) {
        if (num.length() != 5) {
            throw new IllegalArgumentException("Number length must be 5.");
        }
        int b = Integer.parseInt(num.substring(2, 3));
        int s = Integer.parseInt(num.substring(3, 4));
        int g = Integer.parseInt(num.substring(4, 5));
        return "" + (b + s + g) % 10;
    }

    private static String getHeadNum(String num) {
        if (num.length() != 5) {
            throw new IllegalArgumentException("Number length must be 5.");
        }
        int b = Integer.parseInt(num.substring(2, 3));
        int s = Integer.parseInt(num.substring(3, 4));
        return "" + (b + s) % 10;
    }

    private static String getTailNum(String num) {
        return "" + calSum(num) % 10;
    }

    private static Integer calSum(String num) {
        if (num.length() != 5) {
            throw new IllegalArgumentException("Number length must be 5.");
        }
        int s = Integer.parseInt(num.substring(3, 4));
        int g = Integer.parseInt(num.substring(4, 5));
        return s + g;
    }

}
