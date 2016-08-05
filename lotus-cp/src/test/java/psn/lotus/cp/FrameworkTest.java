package psn.lotus.cp;

import psn.lotus.cp.context.FragmentConfigureImpl;
import psn.lotus.cp.context.FragmentConfigure;
import psn.lotus.cp.context.FragmentContext;
import psn.lotus.cp.context.FragmentContextImpl;
import psn.lotus.cp.pojo.Fragment;
import psn.lotus.cp.pojo.FragmentCount;
import psn.lotus.cp.pojo.FragmentExpectCount;
import psn.lotus.cp.service.FragmentService;
import psn.lotus.cp.service.FragmentServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * @author xjl
 * @project lotus
 * @time 2016/8/4 17:53
 */
public class FrameworkTest {

    public static void main(String[] args) {
        String configurePath = "F:\\configure.txt";
        FragmentConfigure configure = new FragmentConfigureImpl(configurePath);
        FragmentContext fragmentContext = new FragmentContextImpl(configure);
        List<Fragment> fragmentList = fragmentContext.getFragments();
        System.out.println("Init fragment size is: " + fragmentList.size());

        FragmentService fragmentService = new FragmentServiceImpl(fragmentContext);
        FragmentCount fragmentCount = fragmentService.countAll();
        System.out.println("Result maybe: " + fragmentCount);

        Map<Integer, FragmentExpectCount> map = fragmentService.expectCountAll();
        for (Integer key : map.keySet()) {
            System.out.println("Key: " + key + ", result maybe: " + map.get(key));
        }

        System.out.println();
        Map<Integer, FragmentExpectCount> map2 = fragmentService.expectCountAll(96, null);
        for (Integer key : map2.keySet()) {
            System.out.println("Key: " + key + ", result maybe: " + map2.get(key));
        }
    }

}
