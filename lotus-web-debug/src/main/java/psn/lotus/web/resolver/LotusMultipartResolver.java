package psn.lotus.web.resolver;

import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: nicee
 * @since: 2016/3/10
 */
public class LotusMultipartResolver implements MultipartResolver {

    public boolean isMultipart(HttpServletRequest httpServletRequest) {
        return false;
    }

    public MultipartHttpServletRequest resolveMultipart(HttpServletRequest httpServletRequest) throws MultipartException {
        return null;
    }

    public void cleanupMultipart(MultipartHttpServletRequest multipartHttpServletRequest) {

    }

}
