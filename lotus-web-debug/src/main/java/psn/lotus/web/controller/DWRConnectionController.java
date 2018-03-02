package psn.lotus.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @project lotus
 * @time 2016/10/31 20:17
 */
@Controller
@RequestMapping(value = "/dwr")
public class DWRConnectionController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String push(HttpServletRequest request) {
        return "dwr";
    }

}
