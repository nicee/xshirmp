package psn.lotus.guice;

import com.google.inject.Inject;

/**
 * @project lotus
 * @time 2018/3/1 14:33
 */
public class ApplicationBootPoint {

    private IUserService userService;

    @Inject
    public ApplicationBootPoint(IUserService userService) {
        this.userService = userService;
    }

    public IUserService getUserService() {
        return userService;
    }

}
