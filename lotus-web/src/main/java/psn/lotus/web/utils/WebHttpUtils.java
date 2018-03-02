package psn.lotus.web.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @author: nicee
 * @since: 2016/2/23
 */
public class WebHttpUtils {

    /**
     * 获取HTTP请求IP地址
     *
     * @param request HTTP请求
     * @return
     */
    public static String getRemoteIp(HttpServletRequest request) {
        String ip = getRemoteForwardForIP(request);
        if (null == ip || "unknown".equalsIgnoreCase(ip)) {
            ip = getRemoteProxyClientIP(request);
        }
        if (null == ip || "unknown".equalsIgnoreCase(ip)) {
            ip = getRemoteWLProxyClientIP(request);
        }
        if (null == ip || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 获取所有HTTP头名称
     *
     * @param request HTTP请求
     * @return
     */
    public static String[] getHeaderNames(HttpServletRequest request) {
        Enumeration obj = request.getHeaderNames();
        List<String> headers = new ArrayList<String>();
        while (obj.hasMoreElements()) {
            headers.add((String) obj.nextElement());
        }
        return headers.toArray(new String[headers.size()]);
    }

    private static String getRemoteForwardForIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0) {
            ip = null;
        } else if (!"unknown".equalsIgnoreCase(ip)) {
            ip = ip.split(" ")[0];
        }
        return ip;
    }

    private static String getRemoteProxyClientIP(HttpServletRequest request) {
        return request.getHeader("Proxy-Client-IP");
    }

    private static String getRemoteWLProxyClientIP(HttpServletRequest request) {
        return request.getHeader("WL-Proxy-Client-IP");
    }


}
