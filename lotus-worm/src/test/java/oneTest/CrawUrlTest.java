package oneTest;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import psn.lotus.worm.CrawUrl;
import psn.lotus.worm.resolver.AbstractResponseBodyResolver;
import psn.lotus.worm.resolver.CrawUrlResolver;
import psn.lotus.worm.resolver.ResponseBodyResolver;

import java.util.List;

/**
 * @project lotus
 * @time 2016/10/27 17:47
 */
public class CrawUrlTest {

    @Test
    public void test() throws Exception {
        RestOperations restOperations = new RestTemplate();

        String url = "http://baike.baidu.com/link?url=q4jgF3lSrLsQjELDCL484ewONuop9Pi15aRVc9hT4p7EyxOP9dUooW3NNdUZRyA6cRrZBVK334pBV59j3S2g0ydcOG2dXLSnAwj0y780Rnm";
        ResponseEntity<String> responseBody = restOperations.getForEntity(url, String.class);

        HttpStatus status = responseBody.getStatusCode();
        if (status == HttpStatus.OK) {
            CrawUrlResolver crawUrlResolver = new CrawUrlResolver();
            crawUrlResolver.setResponseBody(responseBody.getBody());
            CrawUrl crawUrl = crawUrlResolver.urlResolve();
            if (crawUrl != null) {
                List<CrawUrl> children = crawUrl.getChild();
                for (CrawUrl child : children) {
                    System.out.println(child.getUrl());
                }
            }
        }
    }

}
