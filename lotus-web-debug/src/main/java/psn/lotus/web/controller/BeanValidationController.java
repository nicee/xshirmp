package psn.lotus.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import psn.lotus.web.bean.User;

/**
 * @author xjl
 * @project lotus
 * @time 2016/4/25 16:24
 */
@Controller
public class BeanValidationController {

    @ResponseBody
    @RequestMapping(value = "/bean")
    public String validate(@Validated User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println(error);
            }
        }
        return "user is null...";
    }

}
