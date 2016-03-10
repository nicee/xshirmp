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

        //cha 88.23% he 84.87%
//        removeHead(result, calSpan(num));

        //cha 91.59% he 89.07%
//        removeTail(result, calSpan(num));

        //90% 73.92%
//        removeHead(result, getBothNum2(num));
        //91% 74.73%
//        removeTail(result, getBothNum2(num));

        //89% 74.06%
//        removeHead(result, getBothNum(num));
        //90% 74.88%
//        removeTail(result, getBothNum(num));

        //90% 74.11%
//        removeHead(result, getHeadNum(num));
        //90% 74.82%
//        removeTail(result, getHeadNum(num));

        //90% 73.92%
//        removeHead(result, getHeadNum2(num));
        //91% 74.78%
//        removeTail(result, getHeadNum2(num));


        //90% 74.12%
//        removeHead(result, getHeadNum3(num));
        //91% 74.97%
//        removeTail(result, getHeadNum3(num));

        //89% 75.26%
//        removeHead(result, getTailNum(num));
        //91% 75.97%
//        removeTail(result, getTailNum(num));

        //90% 73.78%
//        removeHead(result, getTailNum2(num));
        //90% 74.56%
//        removeTail(result, getTailNum2(num));

        //--> 82.31%
        //94%
//        removeHead(result, calSum(num).toString());
        //95%
//        removeTail(result, calSum(num).toString());


        //89% 73.4%
//        removeHead(result, getOppositeNum(num));
        //91% 74.5%
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

    public static void filterOld(List<String> src, String num) {
        String ten = num.substring(3, 4);
        String ge = num.substring(4, 5);
        removeBoth(src, ten);
        removeBoth(src, ge);
    }

    //过滤跨,
    /*@Deprecated
    public static void filterSpan(List<String> src, String num) {
        List<String> tmp = new ArrayList<String>(src);
        String span = calSpan(num);
        for (String str : tmp) {
            Integer t = Integer.parseInt(str.substring(0, 1));
            Integer g = Integer.parseInt(str.substring(1, 2));
            int tSpan = Math.abs(t + g);
            if (Math.abs(tSpan - span) == 0) {
                src.remove(str);
            }
        }
    }*/

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

    //小公
    private static String getBothNum2(String num) {
        if (num.length() != 5) {
            throw new IllegalArgumentException("Number length must be 5.");
        }
        int ii = (int) (Integer.parseInt(num) * 0.618);
        return "" + ii / 10000;
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
    private static String calSpan(String num) {
        if (num.length() != 5) {
            throw new IllegalArgumentException("Number length must be 5.");
        }
        int s = Integer.parseInt(num.substring(1, 2));
        int g = Integer.parseInt(num.substring(2, 3));
        return String.valueOf((s + g)% 10);
//        return String.valueOf(Math.abs(s - g));
    }

}
