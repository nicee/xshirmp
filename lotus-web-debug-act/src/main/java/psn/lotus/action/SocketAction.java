package psn.lotus.action;

import org.osgl.mvc.annotation.GetAction;

/**
 * @project lotus
 * @time 2017/6/7 17:02
 */
public class SocketAction {

    @GetAction()
    public String test() {
        return "test...";
    }

}
