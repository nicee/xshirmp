package psn.lotus.cp.data;

import java.util.List;
import java.util.Random;

/**
 * @author xjl
 * @project lotus
 * @time 2016/6/6 16:36
 */
public class RandomPay {

    private double factor = 0;

    public void pay(List<String> datas) {
        for (int len = datas.size(), i = len - 1; i > 0; i--) {
            String one = datas.get(i);
            String two = datas.get(i - 1);

            double f1 = getRandomNum(one);
            List<String> nums = getExcludedStr(f1);
        }
    }

    private double getRandomNum(String data) {
        String pre3 = data.substring(0, 3);
        int max = Integer.parseInt(pre3);
        return factor * Math.tanh(max);
    }

    private List<String> getExcludedStr(double num) {
        String str = String.valueOf(num);
        return null;
    }

}
