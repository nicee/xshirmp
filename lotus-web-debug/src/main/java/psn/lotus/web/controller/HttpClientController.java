package psn.lotus.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import psn.lotus.web.support.alone.HttpClientSimpleRequest;

/**
 * to test using apache http client
 *
 * @project lotus
 * @time 2018/3/1 15:26
 */
@Controller
@RequestMapping("/apache/http/client")
public class HttpClientController {

    @ResponseBody
    @RequestMapping(value = "/run", method = RequestMethod.GET)
    public Object pressure() {
        HttpClientSimpleRequest.doRequest();
        return "ok";
    }

}
