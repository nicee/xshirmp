package psn.lotus.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xjl
 * @project lotus
 * @time 2016/8/1 10:44
 */
@Controller
public class ResourceUploadAction {

    @RequestMapping(value = "/resume", method = RequestMethod.POST)
    public void resume(HttpServletRequest request, HttpServletResponse response) {

    }

}
