package psn.lotus.clast3.test;

import psn.lotus.clast3.data.CPData;

/**
 * @author: nicee
 * @since: 2016/3/26
 */
public class Main {

    public static void main(String[] args) {
        CPData data = new CPData("F:\\cp.txt");
        PayTest payTest = new PayTest(data);
        payTest.test();
    }

}
