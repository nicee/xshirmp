package psn.lotus.worm.config;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @project lotus
 * @time 2016/10/27 10:48
 */
public class WormConfig {

    private Stack urlQueue = new Stack();

    private Set<String> visitedUrls = new LinkedHashSet<String>();

    
}
