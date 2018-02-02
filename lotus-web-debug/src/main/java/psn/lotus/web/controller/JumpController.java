package psn.lotus.web.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @project lotus
 * @time 2017/9/22 10:19
 */
@Controller
@RequestMapping("/jump")
public class JumpController {

    private static final Logger logger = LoggerFactory.getLogger(JumpController.class);

    @RequestMapping(value = "/m1", method = RequestMethod.GET)
    public String method1(HttpServletRequest request) {
        logger.info("through forward style, cookies:{}", JSONObject.toJSONString(request.getCookies()));
        return "forward:forward";
    }

    @ResponseBody
    @RequestMapping(value = "/forward", method = RequestMethod.GET)
    public String forward(HttpServletRequest request) {
        logger.info("in forward, cookies:{}", JSONObject.toJSONString(request.getRequestedSessionId()));
        return "forward";
    }

    @RequestMapping(value = "/m2", method = RequestMethod.GET)
    public String method2(HttpServletRequest request) {
        logger.info("through redirect style, cookies:{}", JSONObject.toJSONString(request.getRequestedSessionId()));
        return "redirect:redirect";
    }

    @ResponseBody
    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String redirect(HttpServletRequest request) {
        logger.info("in redirect, cookies:{}", JSONObject.toJSONString(request.getRequestedSessionId()));
        return "redirect";
    }

}
