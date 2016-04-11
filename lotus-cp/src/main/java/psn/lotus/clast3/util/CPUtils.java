package psn.lotus.clast3.util;

import java.util.*;

/**
 * @author: nicee
 * @since: 2016/3/26
 */
public class CPUtils {

    private static final Map<Integer, Integer[]> codeDM = new HashMap<Integer, Integer[]>();
    private static final List<Integer> all = new ArrayList<Integer>();

    static {
        codeDM.put(0, new Integer[]{0, 5});
        codeDM.put(1, new Integer[]{1, 6});
        codeDM.put(2, new Integer[]{2, 7});
        codeDM.put(3, new Integer[]{3, 8});
        codeDM.put(4, new Integer[]{4, 9});

        for (int i = 0; i <= 9; i++) {
            all.add(i);
        }
    }

    public static List<Integer> getAvaliableNum(Set<Integer> dmCodeSet) {
        List<Integer> copy = new ArrayList<Integer>(all);
        List<Integer> dmCodeNums = new ArrayList<Integer>();
        for (Integer code : dmCodeSet) {
            Integer[] nums = codeDM.get(code);
            for (Integer n : nums) {
                dmCodeNums.add(n);
            }
        }
        copy.removeAll(dmCodeNums);
        return copy;
    }

    //获取对码标识
    public static Integer getCode(String numStr) {
        Integer num = getIntFromStr(numStr);
        return (num >= 5) ? num - 5 : num;
    }

    //获取对码号
    public static Integer[] getcodeDM(String codeStr) {
        Integer code = getCode(codeStr);
        return getNumbersOfcodeDM(code);
    }

    //从缓存中获取对码号
    private static Integer[] getNumbersOfcodeDM(Integer code) {
        return codeDM.get(code);
    }

    //解析出数字
    public static Integer getIntFromStr(String numStr) {
        try {
            return Integer.parseInt(numStr);
        } catch (Exception e) {
            throw new IllegalArgumentException("Could not parse number from str value is: " + numStr);
        }
    }


}
