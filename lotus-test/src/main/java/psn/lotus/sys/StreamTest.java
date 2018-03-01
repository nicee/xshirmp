package psn.lotus.sys;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @project lotus
 * @time 2018/2/2 14:40
 */
public class StreamTest {

    static Runtime runtime = Runtime.getRuntime();

    public static void main(String[] args) throws Exception {
        int total = 1000;
        List<String> ints = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            ints.add("Apple");
            ints.add("Apple2");
            ints.add("Bug");
            ints.add("Bug2");
            ints.add("Couple");
        }
        long start = System.currentTimeMillis();

        System.out.println("used memory before: " + (runtime.totalMemory() - runtime.freeMemory()));

        List<String> res2 = new ArrayList<>(total);
        Iterator<String> iterator = ints.iterator();
        // 普通foreach
        while (iterator.hasNext()) {
            String i = iterator.next();
            if (i.startsWith("A")) {
                res2.add(i);
            }
        }
        System.out.println("normal cost: " + (System.currentTimeMillis() - start));
        System.out.println("used memory after normal: " + (runtime.totalMemory() - runtime.freeMemory()));

        start = System.currentTimeMillis();
        // 串行输出数组元素
        List<String> res1 = ints.stream()
                .filter(i -> i.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("serial stream cost: " + (System.currentTimeMillis() - start));
        System.out.println("used memory after stream: " + (runtime.totalMemory() - runtime.freeMemory()));

        start = System.currentTimeMillis();
        // 串行输出数组元素
        List<String> res3 = ints.parallelStream()
                .filter(i -> i.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("parallel stream cost: " + (System.currentTimeMillis() - start));
        System.out.println("used memory after stream: " + (runtime.totalMemory() - runtime.freeMemory()));

        System.out.println("is equals: serial.equals(normal): " + res1.equals(res2));
        System.out.println("is equals: serial.equals(parallel): " + res1.equals(res3));


        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("key" + i, "val" + i);
        }

        int stop = 0;
    }

}
