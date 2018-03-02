package psn.lotus.web.support.alone;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @project lotus
 * @time 2018/3/1 15:29
 */
public class HttpClientSimpleRequest {

    static final Logger logger = LoggerFactory.getLogger(HttpClientSimpleRequest.class);

    static final String url = "http://192.168.184.10/users/sign_in";

    public static void doRequest() {
        HttpGet httpGet = new HttpGet(url);
        try {
            long start = System.currentTimeMillis();
            HttpResponse response = HttpClients.createDefault().execute(httpGet);
            HttpEntity entity = response.getEntity();
            EntityUtils.toString(entity, "UTF-8");
            logger.info("http client request time cost: {}", (System.currentTimeMillis() - start));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            httpGet.abort();
        }
    }

}
