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

        //ten
        //85-90%
        removeHead(result, getBothNum(num));
        //85-90%
//        removeHead(result, getHeadNum(num));
        //86-90%
        removeHead(result, getHeadNum2(num));
        //87-91%
        removeHead(result, getHeadNum3(num));

        //unit
        //85-92%
//        removeTail(result, getTailNum(num));
        //85-90%
//        removeTail(result, getTailNum2(num));
        //93-95%
        removeTail(result, calSum(num).toString());
        //86-92%
//        removeTail(result, getOppositeNum(num));

        return result;
    }

    //过滤和
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

    //过滤跨,
    @Deprecated
    public static void filterSpan(List<String> src, String num) {
        List<String> tmp = new ArrayList<String>(src);
        Integer span = calSpan(num);
        for (String str : tmp) {
            Integer t = Integer.parseInt(str.substring(0, 1));
            Integer g = Integer.parseInt(str.substring(1, 2));
            int tSpan = Math.abs(t - g);
            if (Math.abs(tSpan - span) >= 5) {
                src.remove(str);
            }
        }
    }

    //同时派出
    @Deprecated
    private static void removeBoth(List<String> src, String remove) {
        List<String> tmp = new ArrayList<String>(src);
        for (String num : tmp) {
            if (num.contains(remove)) {
                src.remove(num);
            }
        }
    }

    //十位移除
    private static void removeHead(List<String> src, String remove) {
        List<String> tmp = new ArrayList<String>(src);
        for (String num : tmp) {
            if (num.indexOf(remove) == 0) {
                src.remove(num);
            }
        }
    }

    //个位移除
    private static void removeTail(List<String> src, String remove) {
        List<String> tmp = new ArrayList<String>(src);
        for (String num : tmp) {
            if (num.indexOf(remove) == 1) {
                src.remove(num);
            }
        }
    }

    //四个求和
    private static String getBothNum(String num) {
        if (num.length() != 5) {
            throw new IllegalArgumentException("Number length must be 5.");
        }
        int q = Integer.parseInt(num.substring(1, 2));
        int b = Integer.parseInt(num.substring(2, 3));
        int s = Integer.parseInt(num.substring(3, 4));
        int g = Integer.parseInt(num.substring(4, 5));
        return "" + (q + b + s + g) % 10;
    }

    //3,4求和
    private static String getHeadNum(String num) {
        if (num.length() != 5) {
            throw new IllegalArgumentException("Number length must be 5.");
        }
        int b = Integer.parseInt(num.substring(2, 3));
        int s = Integer.parseInt(num.substring(3, 4));
        return "" + (b + s) % 10;
    }

    //3、4求差
    private static String getHeadNum2(String num) {
        if (num.length() != 5) {
            throw new IllegalArgumentException("Number length must be 5.");
        }
        int b = Integer.parseInt(num.substring(2, 3));
        int s = Integer.parseInt(num.substring(3, 4));
        return "" + Math.abs(b - s);
    }

    private static String getHeadNum3(String num) {
        if (num.length() != 5) {
            throw new IllegalArgumentException("Number length must be 5.");
        }
        return num.substring(2, 3);
    }

    //相对number
    private static String getOppositeNum(String num) {
        if (num.length() != 5) {
            throw new IllegalArgumentException("Number length must be 5.");
        }
        int g = Integer.parseInt(num.substring(4, 5));
        return "" + Math.abs(g - 4);
    }

    //尾差
    private static String getTailNum(String num) {
        if (num.length() != 5) {
            throw new IllegalArgumentException("Number length must be 5.");
        }
        int s = Integer.parseInt(num.substring(3, 4));
        int g = Integer.parseInt(num.substring(4, 5));
        return "" + Math.abs(s - g);
    }

    private static String getTailNum2(String num) {
        if (num.length() != 5) {
            throw new IllegalArgumentException("Number length must be 5.");
        }
        return num.substring(3, 4);
    }

    //尾和
    private static Integer calSum(String num) {
        if (num.length() != 5) {
            throw new IllegalArgumentException("Number length must be 5.");
        }
        int s = Integer.parseInt(num.substring(3, 4));
        int g = Integer.parseInt(num.substring(4, 5));
        return s + g;
    }


    //求跨
    private static Integer calSpan(String num) {
        if (num.length() != 5) {
            throw new IllegalArgumentException("Number length must be 5.");
        }
        int s = Integer.parseInt(num.substring(3, 4));
        int g = Integer.parseInt(num.substring(4, 5));
        return Math.abs(s - g);
    }

}
