package psn.lotus.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import psn.lotus.web.bean.User;
import psn.lotus.web.service.OrderService;
import psn.lotus.web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @project lotus
 * @time 2016/8/10 10:15
 */
@Controller
@RequestMapping("/transaction")
public class SpringTransactionController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    /**
     * The function is to find information of a user in DB.
     *
     * @param name name of user
     * @return information details of a user
     */
    @ResponseBody
    @RequestMapping(value = "/one", method = RequestMethod.GET)
    public User findOne(String name) {
        return userService.find(name);
    }

    /**
     * Testing multi concurrent of adding one user.*
     *
     * @param request  instance of http request object
     * @param response instance of http response object
     * @return result of adding operation
     */
    @ResponseBody
    @RequestMapping(value = "/multi", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String multiConcurrent(HttpServletRequest request, HttpServletResponse response) {
        return userService.add("Test For Transaction", "don't care about it.");
    }

    /**
     * Testing for adding a user specially entry of JMeter.
     *
     * @param user    wrapped information of user
     * @return result of saving operation
     */
    @ResponseBody
    @RequestMapping(value = "/param", method = RequestMethod.POST)
    public String saveForJMeter(@RequestBody User user) {
        return userService.add(user.getName(), user.getPassword());
    }

    /**
     * Testing for order process specially entry of JMeter.
     *
     * @return default content which is "success".
     */
    @ResponseBody
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String order() {
        // call service to order
        orderService.order();

        return "success";
    }

}
