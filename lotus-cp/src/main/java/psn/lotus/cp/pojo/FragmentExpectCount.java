package psn.lotus.cp.pojo;

import java.util.Map;

/**
 * @author xjl
 * @project lotus
 * @time 2016/8/5 9:44
 */
public class FragmentExpectCount extends FragmentCount {

    Map<Integer, Integer> expects;

    public Map<Integer, Integer> getExpects() {
        return expects;
    }

    public void setExpects(Map<Integer, Integer> expects) {
        this.expects = expects;
    }

    @Override
    public String toString() {
        return super.toString() + ", FragmentExpectCount{" +
                "expects=" + expects +
                '}';
    }
}
