package psn.lotus.cp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nicee
 * @since: 2016/1/11
 */
public class Result {

    static final List<Integer> data = new ArrayList<Integer>();

    static {
        for (int i = 0; i < 100; i++) {
            data.add(new Integer(i));
        }
    }

    public static List<Integer> getResult(List<Integer> source) {

        return data;
    }


}
