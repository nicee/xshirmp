package psn.lotus.web.servlet;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;

/**
 * @author: nicee
 * @since: 2016/3/10
 */
public class LotusHttpServlet extends HttpServlet {

    // static final Logger logger = LoggerFactory.getLogger(LotusHttpServlet.class);
    static final Logger logger = Logger.getLogger(LotusHttpServlet.class);

    public void init() {
        logger.info("This is lotus servlet init...");
    }

}
