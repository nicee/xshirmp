package psn.lotus.cp.support;

import psn.lotus.cp.pojo.FragmentCount;
import psn.lotus.cp.pojo.FragmentExpectCount;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xjl
 * @project lotus
 * @time 2016/8/5 8:37
 */
public class FeatureReader {

    static final Integer[] primes = {1, 2, 3, 5, 7};

    public static boolean isHigher(Integer number) {
        return number.intValue() >= 5;
    }

    public static boolean isLower(Integer number) {
        return !isHigher(number);
    }

    public static boolean isOnRoadZero(Integer number) {
        return number.intValue() % 3 == 0;
    }

    public static boolean isOnRoadOne(Integer number) {
        return number.intValue() % 3 == 1;
    }

    public static boolean isOnRoadTwo(Integer number) {
        return number.intValue() % 3 == 2;
    }

    public static boolean isOdd(Integer number) {
        return number.intValue() % 2 == 1;
    }

    public static boolean isEven(Integer number) {
        return !isOdd(number);
    }

    public static boolean isPrime(Integer number) {
        List<Integer> list = Arrays.asList(primes);
        return list.contains(number);
    }

    public static boolean isComposite(Integer number) {
        return !isPrime(number);
    }


    public static void higherOrLower(FragmentCount count, Integer number) {
        if (isHigher(number)) {
            int higher = count.getHigher();
            count.setHigher(++higher);
        } else {
            int lower = count.getLower();
            count.setLower(++lower);
        }
    }

    public static void oddOrEven(FragmentCount count, Integer number) {
        if (isOdd(number)) {
            int odd = count.getOdd();
            count.setOdd(++odd);
        } else {
            int even = count.getEven();
            count.setEven(++even);
        }
    }

    public static void primeOrComposite(FragmentCount count, Integer number) {
        if (isPrime(number)) {
            int prime = count.getPrime();
            count.setPrime(++prime);
        } else {
            int composite = count.getComposite();
            count.setComposite(++composite);
        }
    }

    public static void roadWhich(FragmentCount count, Integer number) {
        if (isOnRoadZero(number)) {
            int roadZero = count.getRoadZero();
            count.setRoadZero(++roadZero);
        } else if (isOnRoadOne(number)) {
            int roadOne = count.getRoadOne();
            count.setRoadOne(++roadOne);
        } else {
            int roadTwo = count.getRoadTwo();
            count.setRoadTwo(++roadTwo);
        }
    }

    public static void expectNumber(FragmentExpectCount expectCount, Integer number) {
        Map<Integer, Integer> expects = expectCount.getExpects();
        if (expects == null) {
            expects = new HashMap<Integer, Integer>();
        }
        Integer count = expects.get(number);
        expects.put(number, (count == null) ? 1 : ++count);
        expectCount.setExpects(expects);
    }

}
