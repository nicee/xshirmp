package psn.lotus.unit;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.util.UUID;

/**
 * @author: nicee
 * @since: 2016/1/15
 */
public class ShopTest {

    @Test
    public void test() throws Exception {
        HttpGet httpGet = new HttpGet("http://localhost:8095/shop/account/code");

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        while (true) {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            BasicResponseHandler handler = new BasicResponseHandler();
            String content = handler.handleResponse(response);
            System.out.println(content);
        }
    }

    @Test
    public void resetPWD() throws Exception {
        StringBuffer buffer = new StringBuffer();

        buffer.append("{");
        buffer.append("\"uuid\":\"" + UUID.randomUUID() + "\",");
        buffer.append("\"asid\":\"" + "test" + "\",");
        buffer.append("\"password\":\"" + "password" + "\",");
        buffer.append("\"confirmPassword\":\"" + "password" + "\"");
        buffer.append("}");

        System.out.print(buffer.toString());

        HttpPost httpPost = new HttpPost("http://localhost:8095/shop/account/resetPassword");

        httpPost.setHeader("Content-Type", "application/json; charset=utf-8");
        httpPost.setEntity(new StringEntity(buffer.toString()));
        dealResponse(httpPost);
    }

    @Test
    public void getInfo() throws Exception {
        HttpGet httpGet = new HttpGet("http://localhost:8095/shop/account/getLoginAccountInfo");
        dealResponse(httpGet);
    }

    @Test
    public void testAR() throws Exception {
        HttpPost httpPost = new HttpPost("https://61.130.0.179/view/checkVoiceService.cgi");

        httpPost.setHeader("Content-Type", "application/json; charset=utf-8");
        httpPost.setEntity(new StringEntity("{\"null\":\"1\"}"));
        dealResponse(httpPost);
    }

    private static void dealResponse(HttpUriRequest request) throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = httpClient.execute(request);
        BasicResponseHandler handler = new BasicResponseHandler();
        String content = handler.handleResponse(response);
        System.out.println(content);
    }
}
