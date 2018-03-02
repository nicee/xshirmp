package psn.lotus.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.Callable;

/**
 * @project lotus
 * @time 2016/10/21 16:35
 */
@Controller
public class AsyncHandlerController {

    @ResponseBody
    @RequestMapping(value = "/callable")
    public Callable<String> callable(HttpServletRequest request, HttpServletResponse response) {

        Callable<String> callableExe = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(10000);
//                throw new IllegalArgumentException("Occur on illegal argument exception");
                return "I'am from async callable function.";
            }
        };

        return callableExe;
    }

    @ResponseBody
    @ExceptionHandler
    public String handleExceptionInCallable(Exception e) {
        return (e instanceof IllegalArgumentException) ? "Illegal argument exception" : "Other exception";
    }

}
