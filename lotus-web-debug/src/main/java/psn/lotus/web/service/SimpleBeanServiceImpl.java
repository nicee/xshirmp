package psn.lotus.web.service;

import org.springframework.stereotype.Service;

/**
 * @project lotus
 * @time 2017/3/22 10:17
 */
@Service
public class SimpleBeanServiceImpl implements SimpleBeanService {

    @Override
    public String sayHelloToOne() {
        return "hello world";
    }

}
