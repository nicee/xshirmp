package psn.lotus.cp.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nicee
 * @since: 2016/3/2
 */
public class FilterUtil4 {

    public static List<String> filterByGongshi(String old) {
        List<String> result = init();

        List<String> inits = init();
        List<String> filterNums = getFilterNumer(old);

        //去除包括在filterNums中的号
        for (String f : filterNums) {
            for (String source : inits) {
                if (source.contains(f)) {
                    result.remove(source);
                }
            }
        }

        return result;
    }


    private static List<String> getFilterNumer(String old) {
        Integer num = Integer.valueOf(old);

        List<String> numbers = new ArrayList<String>();

        String str = String.valueOf(num * Math.PI);
        String[] strArr = str.split("\\.");

        String v1 = String.valueOf(strArr[0].charAt(0));

        int len = strArr[1].length(), i = len - 1;
        String v2 = String.valueOf(strArr[1].charAt(i));

        numbers.add(v1);
        while (i >= 0 && v1.equals(v2)) {
            v2 = String.valueOf(strArr[1].charAt(i));
            i--;
        }

        numbers.add(v2);

        return numbers;
    }

    public static List<String> filterByGongshi2(String old) {
        List<String> result = new ArrayList<String>();

        List<String> inits = init();
        List<String> filterNums = getMustNumer2(old);

        //去除包括在filterNums中的号
        for (String f : filterNums) {
            for (String source : inits) {
                if (source.contains(f) && !result.contains(source)) {
                    result.add(source);
                }
            }
        }

        return result;
    }

    private static List<String> getMustNumer2(String old) {
        Integer num = Integer.valueOf(old);

        List<String> numbers = new ArrayList<String>();

        String str = String.valueOf(num * 0.618);
        String[] strArr = str.split("\\.");

        String v1 = strArr[0];

        int i = 0, len = v1.length();

        while (i < len) {
            String t = String.valueOf(v1.charAt(i));
            if (!numbers.contains(t)) {
                numbers.add(t);
            }
            i++;
        }

        return numbers;
    }

    private static List<String> init() {
        List<String> all = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            all.add((i < 10) ? "0" + i : "" + i);
        }
        return all;
    }

}
