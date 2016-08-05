package psn.lotus.cp.service;

import psn.lotus.cp.pojo.FragmentCount;
import psn.lotus.cp.pojo.FragmentExpectCount;

import java.util.Map;

/**
 * @author xjl
 * @project lotus
 * @time 2016/8/5 9:08
 */
public interface FragmentService {

    FragmentCount countAll();

    FragmentCount countScope(Integer start, Integer end);

    Map<Integer, FragmentExpectCount> expectCountAll();

    Map<Integer, FragmentExpectCount> expectCountAll(Integer start, Integer end);

}
