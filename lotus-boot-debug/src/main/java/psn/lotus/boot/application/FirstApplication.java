package psn.lotus.boot.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @project lotus-boot
 * @time 2018/2/7 13:21
 */
@RestController
@EnableAutoConfiguration
public class FirstApplication {

    @ResponseBody
    @RequestMapping(value = "/first")
    public String home() {
        return "hello, here is lotus world on spring bootatt";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(FirstApplication.class, args);
    }

}
