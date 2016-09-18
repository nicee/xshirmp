package psn.lotus.web;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

// import org.junit.Test;

/**
 * @author xjl
 * @project lotus
 * @time 2016/5/5 15:02
 */
public class SimpleTest {

    //@Test
    public void test() {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);

        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        System.out.println(restTemplate.getForObject("http://www.baidu.com", String.class, "a=b"));

    }
}
