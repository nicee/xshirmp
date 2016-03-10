package psn.lotus.mvc.http;

import psn.lotus.mvc.http.metadata.HttpBody;
import psn.lotus.mvc.http.metadata.HttpHeaders;

import java.io.IOException;
import java.net.URI;

/**
 * @author: nicee
 * @since: 2016/2/4
 */
public interface HttpMessage {

    /**
     * 获取HTTP请求头
     *
     * @return HTTP请求头
     */
    HttpHeaders getHeaders();

    /**
     * 获取HTTP请求方法类型
     *
     * @return HTTP请求方法类型
     */
    HttpMethod getMethod();

    /**
     * 获取HTTP请求body
     *
     * @return HTTP请求body
     */
    HttpBody getBody();

    /**
     * 获取HTTP请求地址
     *
     * @return
     * @throws IOException
     */
    URI getUri() throws IOException;

}
