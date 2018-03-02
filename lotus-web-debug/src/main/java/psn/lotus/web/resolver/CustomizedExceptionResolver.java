package psn.lotus.web.resolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xjl
 * @project lotus
 * @time 2016/5/5 13:42
 */
public final class CustomizedExceptionResolver implements HandlerExceptionResolver {

    // slf4j 版本
    private static final Logger logger = LoggerFactory.getLogger(CustomizedExceptionResolver.class);

    // log4j 版本
//    private static final Logger logger = Logger.getLogger(CustomizedExceptionResolver.class);

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // slf4j 版本
        // logger.info("解析MVC Handler处理过程发生的异常, 详情为: {}", ex.getMessage());

        // log4j 版本
        logger.info("解析MVC Handler处理过程发生的异常, 详情为: {}", ex.getMessage());

        return null;
    }

}
