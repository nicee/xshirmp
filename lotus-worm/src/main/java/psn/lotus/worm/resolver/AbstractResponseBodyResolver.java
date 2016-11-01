package psn.lotus.worm.resolver;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @project lotus
 * @time 2016/10/27 15:09
 */
public abstract class AbstractResponseBodyResolver implements ResponseBodyResolver {

    private String responseBody;

    private String regexForFind;

    public AbstractResponseBodyResolver(String regexForFind) {
        this.regexForFind = regexForFind;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public List<String> resolve() throws Exception {
        preResolve();

        Pattern pattern = Pattern.compile(regexForFind);
        Matcher matcher = pattern.matcher(responseBody);

        List<String> findResult = new ArrayList<String>();
        while (matcher.find()) {
            findResult.add(matcher.group());
        }
        return findResult;
    }

    private void preResolve() {
        responseBody = responseBody.replaceAll("[\n\r\t]", "");
        responseBody.trim();

        try {
            byte[] bytes = responseBody.getBytes("ISO8859-1");
            responseBody = new String(bytes, Charset.forName("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
