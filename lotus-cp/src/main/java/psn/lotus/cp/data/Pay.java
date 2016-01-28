package psn.lotus.cp.data;

import psn.lotus.cp.util.FilterUtils2;

import java.util.List;

/**
 * @author: nicee
 * @since: 2016/1/28
 */
public class Pay {

    private boolean lastFail = false;

    private long win = 0;

    private List<String> datas;

    public Pay(List<String> datas) {
        this.datas = datas;
    }

    public void payOne() {
        for (int i = 0, len = datas.size(); i < len - 1; i++) {
            String one = datas.get(i);
            String two = datas.get(i + 1);
            List<String> result = FilterUtils2.filterNumber(one);
            if (result.size() > 68) {
                System.out.println("Too much, I will pay '" + result.size() + "' units, try to file summary...");
                FilterUtils2.filterSummary(result, one);
            }

            String target = two.substring(3, 5);
            print(result, one, target);
            int pay = 2 * result.size();
            int mayWin = 194 - pay;
            if (result.contains(target)) {
                //win += (lastFail) ? 3 * mayWin : mayWin;
                win += mayWin;
                lastFail = false;
                System.out.println("Result: pay Win....");
            } else {
                //win -= (lastFail) ? 3 * pay : pay;
                win -= pay;
                lastFail = true;
                System.out.println("Result: pay Fail...");
            }
            System.out.println("Account left is: " + win);
            System.out.println("-------------------------------------------------------");
        }
    }

    private void print(List<String> output, String one, String target) {
        int rn = 1;
        System.out.println("Now number is: " + one);
        System.out.println("Next number is: " + target);
        System.out.println("Pay number length is: " + output.size() + ", detail of this: ");
        for (String num : output) {
            rn++;
            if (rn >= 20) {
                System.out.println(num);
                rn = 1;
            } else {
                System.out.print(num + "  ");
            }
        }
        System.out.println();
    }

}
