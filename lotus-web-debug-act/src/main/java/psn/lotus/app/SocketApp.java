package psn.lotus.app;

import act.boot.app.RunApp;
import psn.lotus.action.SocketAction;

/**
 * @project lotus
 * @time 2017/6/7 17:04
 */
public class SocketApp {

    public static void main(String[] args) throws Exception {
        RunApp.start(SocketAction.class);
    }

}
