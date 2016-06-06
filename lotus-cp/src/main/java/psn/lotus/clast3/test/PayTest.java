package psn.lotus.clast3.test;

import psn.lotus.clast3.data.CPData;
import psn.lotus.clast3.util.CPUtils;

import java.util.*;

/**
 * @author: nicee
 * @since: 2016/3/26
 */
public class PayTest {

    private final CPData data;

    private Long account = new Long(0);

    public PayTest(CPData data) {
        this.data = data;
    }

    public void test() {
        List<String> numbers = data.getNumbers();
        int maxFail = 0, curFail = 0;
        boolean fail = false;
        int wined = 0, lost = 0, notbuy = 0;
        for (int len = numbers.size(), i = len - 1; i > 0; i--) {
            //当前号码
            String cur = numbers.get(i);
            //','分割出号码
            String[] nums = cur.split(",");
            //根据后三对码购买剩余的号码
            List<Integer> buy = getPayNumber(new String[]{nums[2], nums[3], nums[4]});

            if (null == buy) {
                notbuy++;
                continue;
            }

            //开奖号码
            String next = numbers.get(i - 1);
            String[] nexts = next.split(",");
            String[] last2 = new String[]{nexts[3], nexts[4]};

            //检查购买结果
            boolean win = checkPay(buy, last2);
            int cost = 64 * 2;
            if (win) {
                account += (194 - cost) * curFail;
                wined++;
                if (curFail > maxFail) {
                    maxFail = curFail;
                }
                curFail = 0;
            } else {
                curFail++;
                account -= (cost * curFail);
                lost++;
            }
        }
        System.out.println("最大连错: " + maxFail);
        System.out.println("测试总数据期数为: " + numbers.size());
        System.out.print("账户金额为: " + account + ", 中奖: " + wined + ", 未中奖: " + lost + ", 未买期数: " + notbuy);
    }

    private List<Integer> getPayNumber(String... numStr) {
        Set<Integer> dmSet = getDMCode(numStr);
        return (null == dmSet || dmSet.isEmpty()) ? null : CPUtils.getAvaliableNum(dmSet);
    }

    private Set<Integer> getDMCode(String... numbers) {
        Set<Integer> codes = new HashSet<Integer>();
        for (String numStr : numbers) {
            Integer code = CPUtils.getCode(numStr);
            if (codes.contains(code)) {
                //对于有重复的对码, 直接返回null
                codes.clear();
                break;
            } else {
                codes.add(code);
            }
        }
        return codes;
    }

    //test numbers of pay is award??
    private boolean checkPay(List<Integer> buy, String[] awardNum) {
        for (String s : awardNum) {
            Integer num = CPUtils.getIntFromStr(s);
            if (buy.contains(num)) {
                return true;
            }
        }
        return false;
    }

}
