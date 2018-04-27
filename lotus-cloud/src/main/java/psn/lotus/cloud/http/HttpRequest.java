package psn.lotus.cloud.http;

import java.util.Enumeration;
import java.util.Map;

/**
 * @project lotus
 * @time 2018/4/26 16:21
 */
public class HttpRequest implements Parameterize, Headerize {


    @Override
    public String getHeader(String name) {
        return null;
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        return null;
    }

    @Override
    public String getParameter(String name) {
        return null;
    }

    @Override
    public String[] getParameterValues(String name) {
        return new String[0];
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return null;
    }

}
