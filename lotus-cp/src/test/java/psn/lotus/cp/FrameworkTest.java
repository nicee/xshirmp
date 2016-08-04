package psn.lotus.cp;

import psn.lotus.cp.context.DefaultFragmentConfigure;
import psn.lotus.cp.context.FragmentConfigure;
import psn.lotus.cp.context.FragmentContext;
import psn.lotus.cp.context.FragmentContextImpl;
import psn.lotus.cp.pojo.Fragment;

import java.util.List;

/**
 * @author xjl
 * @project lotus
 * @time 2016/8/4 17:53
 */
public class FrameworkTest {

    public static void main(String[] args) {
        String configurePath = "F:\\configure.txt";
        FragmentConfigure configure = new DefaultFragmentConfigure(configurePath);
        FragmentContext fragmentContext = new FragmentContextImpl(configure);
        List<Fragment> fragmentList = fragmentContext.getFragments();
        System.out.println("Init fragment size is: " + fragmentList.size());
    }

}
