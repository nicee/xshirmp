package psn.lotus.cp.util;

import java.util.*;

/**
 * @author: nicee
 * @since: 2016/1/27
 */
public class FilterUtils {

    static List<Integer> datas = new ArrayList<Integer>();
    static List<Integer> source = new ArrayList<Integer>();

    static {
        source.add(9);
        source.add(5);
        source.add(8);
        source.add(3);
        source.add(6);
        source.add(1);
        source.add(4);
        source.add(7);
        source.add(2);
        source.add(0);

        for (int i = 0; i < 100; i++) {
            datas.add(i);
        }
    }

    public static List<Integer> filter(int data) {
        int t = data / 10;
        int g = data % 10;
        return null;
    }

    private static List<Integer> filter(int rawNum, boolean isLast) {
        List<Integer> tmp = new ArrayList<Integer>();
        tmp.addAll(source);
        int filter = getFilterNumber(rawNum);
        tmp.remove(filter);
        List<Integer> result = new ArrayList<Integer>();
        for (Integer n : tmp) {
            if (isLast) {
                for (Integer j : source) {
                    result.add(j * 10 + n);
                }
            } else {
                for (Integer j : source) {
                    result.add(n * 10 + j);
                }
            }
        }
        return result;
    }

    private static int getFilterNumber(int rawNum) {
        return Math.abs(5 - rawNum);
    }

    public static void main(String[] args) {
        System.out.println(filter(20));
    }
}
