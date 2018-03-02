package psn.lotus.server.event;

import psn.lotus.server.api.LifeCycle;
import psn.lotus.server.api.LifeCycleListener;

/**
 * @author: nicee
 * @since: 2016/1/15
 */
public class SampleListener implements LifeCycleListener.LifeCycleEventListener {

    public void lifeCycleStarting(LifeCycle event) {
        System.out.println("lift starting ....");
    }

    public void lifeCycleStarted(LifeCycle event) {
        System.out.println("lift started ....");
    }

    public void lifeCycleStopping(LifeCycle event) {
        System.out.println("lift stopping ....");
    }

    public void lifeCycleStopped(LifeCycle event) {
        System.out.println("lift stopped ....");
    }

}
