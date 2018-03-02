package psn.lotus.web.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xjl
 * @project lotus
 * @time 2016/8/10 17:37
 */
@WebServlet(displayName = "annotationed", name = "AnnotationedServlet", urlPatterns = "/annotation", loadOnStartup = 2)
public class AnnotationedServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(AnnotationedServlet.class);

    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        logger.info("This message from web servlet annotation on @WebServlet.");
    }

}
