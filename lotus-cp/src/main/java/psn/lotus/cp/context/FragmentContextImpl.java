package psn.lotus.cp.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import psn.lotus.cp.pojo.Fragment;
import psn.lotus.cp.support.FragmentReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xjl
 * @project lotus
 * @time 2016/8/4 17:15
 */
public class FragmentContextImpl implements FragmentContext {

    private static Logger logger = LoggerFactory.getLogger(FragmentContextImpl.class);

    private boolean init;

    private volatile List<Fragment> fragments;

    private final FragmentConfigure configure;

    private static final Lock lock = new ReentrantLock(true);

    public FragmentContextImpl(FragmentConfigure configure) {
        this.configure = configure;
    }

    public List<Fragment> getFragments() {
        if (!init) {
            boolean locked = lock.tryLock();
            if (locked) {
                this.init();
                lock.unlock();
            }
        }
        if (!init) {
            throw new RuntimeException("The fragment could not be initialize...");
        }
        return this.fragments;
    }

    public List<Fragment> getFragments(Integer start, Integer end) {
        List<Fragment> fragments = getFragments();
        List<Fragment> results = new ArrayList<Fragment>();

        for (Fragment fragment : fragments) {
            boolean add = (start == null || (start != null && fragment.getSerialNo() >= start));
            add = add && ((end == null) || (end != null && fragment.getSerialNo() <= end));
            if (add) {
                results.add(fragment);
            }
        }

        return results;
    }

    private void init() {
        try {
            InputStream input = configure.getInputStream();
            this.fragments = FragmentReader.read(input);
            this.init = true;
        } catch (IOException e) {
            logger.error("Load fragment configure failure....");
            e.printStackTrace();
        }
    }

}
