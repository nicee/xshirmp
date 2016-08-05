package psn.lotus.cp.service;

import psn.lotus.cp.context.FragmentContext;
import psn.lotus.cp.pojo.Fragment;
import psn.lotus.cp.pojo.FragmentCount;
import psn.lotus.cp.pojo.FragmentExpectCount;
import psn.lotus.cp.support.FeatureReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xjl
 * @project lotus
 * @time 2016/8/5 9:14
 */
public class FragmentServiceImpl implements FragmentService {

    private FragmentContext context;

    public FragmentServiceImpl(FragmentContext context) {
        this.context = context;
    }

    public FragmentCount countAll() {
        List<Fragment> fragments = context.getFragments();
        return countAll(fragments);
    }

    public FragmentCount countScope(Integer start, Integer end) {
        List<Fragment> fragments = context.getFragments(start, end);
        return countAll(fragments);
    }

    public Map<Integer, FragmentExpectCount> expectCountAll() {
        List<Fragment> fragments = context.getFragments();
        return expectCountAll(fragments);
    }

    public Map<Integer, FragmentExpectCount> expectCountAll(Integer start, Integer end) {
        List<Fragment> fragments = context.getFragments(start, end);
        return expectCountAll(fragments);
    }

    private FragmentCount countAll(List<Fragment> fragments) {
        FragmentCount fragmentCount = new FragmentCount();

        for (Fragment fragment : fragments) {
            int tenNo = fragment.getTenNo();
            int unitNo = fragment.getUnitNo();

            doCount(fragmentCount, tenNo);
            doCount(fragmentCount, unitNo);
        }

        return fragmentCount;
    }

    private Map<Integer, FragmentExpectCount> expectCountAll(List<Fragment> fragments) {
        Map<Integer, FragmentExpectCount> map = new HashMap<Integer, FragmentExpectCount>();

        int end = fragments.size() - 1;
        for (int i = 0; i < end; ++i) {
            Fragment fragment = fragments.get(i);
            Fragment fragmentNxt = fragments.get(i + 1);

            int tenNo2 = fragmentNxt.getTenNo();
            int unitNo2 = fragmentNxt.getUnitNo();

            int tenNo = fragment.getTenNo();
            FragmentExpectCount expectCount1 = map.get(tenNo);
            if (expectCount1 == null) {
                expectCount1 = new FragmentExpectCount();
            }

            doCount(expectCount1, tenNo2);
            doCount(expectCount1, unitNo2);
            FeatureReader.expectNumber(expectCount1, tenNo2);
            FeatureReader.expectNumber(expectCount1, unitNo2);

            map.put(tenNo, expectCount1);

            int unitNo = fragment.getUnitNo();
            FragmentExpectCount expectCount2 = map.get(unitNo);
            if (expectCount2 == null) {
                expectCount2 = new FragmentExpectCount();
            }

            doCount(expectCount2, tenNo2);
            doCount(expectCount2, unitNo2);
            FeatureReader.expectNumber(expectCount2, tenNo2);
            FeatureReader.expectNumber(expectCount2, unitNo2);

            map.put(unitNo, expectCount2);
        }

        return map;
    }

    private void doCount(FragmentCount fragmentCount, Integer number) {
        if (fragmentCount == null) {
            fragmentCount = new FragmentExpectCount();
        }

        FeatureReader.higherOrLower(fragmentCount, number);

        FeatureReader.oddOrEven(fragmentCount, number);

        FeatureReader.primeOrComposite(fragmentCount, number);

        FeatureReader.roadWhich(fragmentCount, number);
    }

}
