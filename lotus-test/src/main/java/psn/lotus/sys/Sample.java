package psn.lotus.sys;

import org.junit.Test;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;

/**
 * @author: nicee
 * @since: 2016/1/18
 */
public class Sample {

//    @Test
    public void test(String name) {
        String a = new String("大家");
        //a = a.toUpperCase();
        System.out.println(a.toString());

        Byte b = new Byte("100");
        System.out.println(b);
        int i = Byte.toUnsignedInt(b);
        while(true){
            if(name != null) {
                System.out.println(name);
            }
        }
    }

    public static void main(String[] args) {
        Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
        HashMap<Integer, String> hm = new HashMap<Integer, String>();

        Random random = new SecureRandom();
        int i = 0;
        do {
            byte[] bs = new byte[5];
            random.nextBytes(bs);
            ht.put(i, new String(bs));
            hm.put(i, new String(bs));
            i++;
        }while (i < 3);

        for(Integer c : ht.keySet()) {
            System.out.println("Hashtable get(" + c +") -> " + ht.get(c));
        }

        for(Integer c : hm.keySet()) {
            System.out.println("HashMap get(" + c +") -> " + hm.get(c));
        }
    }

}
