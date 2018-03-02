package psn.lotus.guice;

import com.google.inject.AbstractModule;

/**
 * @project lotus
 * @time 2018/3/1 14:34
 */
public class ApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IUserService.class).to(UserServiceImpl.class);
    }

}
