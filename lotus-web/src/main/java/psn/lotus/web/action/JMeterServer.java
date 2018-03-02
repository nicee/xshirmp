package psn.lotus.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import psn.lotus.web.utils.WebHttpUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author: nicee
 * @since: 2016/2/19
 */
@Controller("jmeterServer")
@RequestMapping("/jmeter")
public class JMeterServer {

    static Integer count = 0;
    private static final Logger logger = LoggerFactory.getLogger(JMeterServer.class);

    @RequestMapping(value = "/api1", method = RequestMethod.GET)
    public ModelAndView sayHello(HttpServletRequest request) {
        synchronized (count) {
            count++;
        }
        Thread thread = Thread.currentThread();
        logger.info("[" + count + "] 线程'" + thread.getName() + "'正在访问接口'/jmeter/api1',请求时间为'" + new Date() + "'");

        String[] headers = WebHttpUtils.getHeaderNames(request);
        for (String header : headers) {
            System.out.print(header + "  ");
        }
        System.out.println();
        System.out.println(WebHttpUtils.getRemoteIp(request));
        return new ModelAndView("hello");
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ModelAndView test(HttpServletRequest request) {
        return new ModelAndView("hello");
    }

}
