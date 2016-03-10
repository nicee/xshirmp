package psn.lotus.cp.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nicee
 * @since: 2016/3/2
 */
public class FilterUtils3 {

    public static List<String> filterByGongshi(String old) {
        List<String> inits = init();
        List<String> mustNum = getMustNumber(old);

        List<String> result = new ArrayList<String>();

        //去除不包括在mustNum中的号
        for (String must : mustNum) {
            for (String source : inits) {
                if (source.contains(must) && !result.contains(source)) {
                    result.add(source);
                }
            }
        }
        return result;
    }

    private static List<String> getMustNumber(String old) {
        List<String> numbers = new ArrayList<String>();

        int _4 = Integer.valueOf(old.substring(3, 4));
        int _5 = Integer.valueOf(old.substring(4, 5));
        int sum = _4 + _5;
        int span = Math.abs(_5 - _4);
        String source = String.valueOf((sum + span + 6) * 614);

//        String source = String.valueOf(Integer.valueOf(old) * 0.618);
        for (int i = 0, len = source.length(); i < len; i++) {
            String t = String.valueOf(source.charAt(i));
            if (numbers.size() < 5 && !numbers.contains(t)) {
                numbers.add(t);
            }
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
