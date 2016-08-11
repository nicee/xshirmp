package psn.lotus.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import psn.lotus.web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xjl
 * @project lotus
 * @time 2016/8/10 10:15
 */
@Controller
@RequestMapping("/transaction")
public class SpringTransactionController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/multi", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String multiConcurrent(HttpServletRequest request, HttpServletResponse response) {
        return userService.add("Test For Transaction", "don't care about it.");
    }


}
