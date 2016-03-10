package psn.lotus.cp.data2;

import psn.lotus.cp.util.FilterUtils3;

import java.util.List;

/**
 * @author: nicee
 * @since: 2016/3/2
 */
public class PayTest {

    private DataSource2 dataSource;

    public PayTest(DataSource2 dataSource) {
        this.dataSource = dataSource;
    }

    public void pay() {
        int doll = 0;
        List<String> datas = dataSource.getDatas();
        int win = 0, error = 0;
        for (int len = datas.size() - 1, i = len; i > 0; i--) {
            String current = datas.get(i);
            List<String> buy = FilterUtils3.filterByGongshi(current);
            String next = datas.get(i - 1).substring(3, 5);
            if (buy.contains(next)) {
                System.out.println("win....");
                win++;
                doll += (194 - buy.size() * 2);
            } else {
                doll -= (buy.size() * 2);
                System.out.println("Fail...");
                System.out.println("Current number:" + current + ", next number: " + next);
                error++;
            }
        }

        System.out.println("Account: " + doll);
        System.out.println("Win: " + win + ", Error: " + error);
    }

}
