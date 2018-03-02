package psn.lotus.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import psn.lotus.server.api.LifeCycle;
import psn.lotus.server.api.LifeCycleListener;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 抽象声明周期管理实现
 *
 * @author: nicee
 * @since: 2016/1/14
 */
public abstract class AbstractLifeCycle implements LifeCycle, LifeCycleListener {

    private static final Logger logger = LoggerFactory.getLogger(AbstractLifeCycle.class);
    private final Object lock = new Object();
    private static final int STARTING = 1, STARTED = 2, STOPPING = 3, STOPPED = 4;
    private volatile int state = STOPPED;
    private CopyOnWriteArrayList<LifeCycleListener.LifeCycleEventListener> listeners = new CopyOnWriteArrayList<LifeCycleListener.LifeCycleEventListener>();

    public void start() throws Exception {
        synchronized (lock) {
            if (state == STARTING || state == STARTED) return;
            setStarting();
            start();
            setStarted();
        }
    }

    public void stop() throws Exception {
        synchronized (lock) {
            if (state == STOPPING || state == STOPPED) return;
            setStopping();
            stop();
            setStopped();
        }
    }

    public void addEventListener(LifeCycleEventListener eventListener) {
        listeners.add(eventListener);
    }

    public void removeEventListener(LifeCycleEventListener eventListener) {
        listeners.remove(eventListener);
    }

    private void setStarting() {
        logger.info("starting {}", this);
        state = STARTING;
        for (LifeCycleListener.LifeCycleEventListener listener : listeners) {
            listener.lifeCycleStarting(this);
        }
    }

    private void setStarted() {
        logger.info("started {}", this);
        state = STARTED;
        for (LifeCycleListener.LifeCycleEventListener listener : listeners) {
            listener.lifeCycleStarted(this);
        }
    }

    private void setStopping() {
        logger.info("stopping {}", this);
        state = STOPPING;
        for (LifeCycleListener.LifeCycleEventListener listener : listeners) {
            listener.lifeCycleStopping(this);
        }
    }

    private void setStopped() {
        logger.info("stopped {}", this);
        state = STOPPED;
        for (LifeCycleListener.LifeCycleEventListener listener : listeners) {
            listener.lifeCycleStopped(this);
        }
    }

}
