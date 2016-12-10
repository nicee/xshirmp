package psn.lotus.sys;

import org.junit.Test;

/**
 * @project lotus
 * @time 2016/11/25 13:14
 */
public class ReflectTest {

    @Test
    public void test() throws Exception {
        Class cache = Integer.class.getDeclaredClasses()[0];
        java.lang.reflect.Field myCache = cache.getDeclaredField("cache");
        myCache.setAccessible(true);

        Integer[] newCache = (Integer[]) myCache.get(cache);
        newCache[132] = newCache[133]; //5

        int a = 2;
        int b = a + a;
        System.out.printf("%d + %d = %d", a, a, b);
    }

}
