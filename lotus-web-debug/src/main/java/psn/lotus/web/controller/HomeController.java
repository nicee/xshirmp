package psn.lotus.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xjl
 * @project lotus
 * @time 2016/10/8 16:33
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, Model model) {
        //当前用户
        Subject subject = SecurityUtils.getSubject();

        //当前用户令牌
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername("admin");
        token.setPassword("password".toCharArray());

        //当前用户携令牌登陆
        subject.login(token);

        model.addAttribute("data", "testing data...");

        return subject.isAuthenticated() ? "hello" : "fail";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("data", "data something...");
        return "index";
    }

}
