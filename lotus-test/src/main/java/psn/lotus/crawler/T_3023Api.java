package psn.lotus.crawler;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.net.URI;
import java.nio.charset.Charset;

/**
 * @author xjl
 * @project lotus
 * @time 2016/9/29 11:06
 */
public class T_3023Api {

    //3023 app key
    static final String appKey = "bd0c6f2d97b436fb407d1c85aa0fb202";

    //接口服务地址
    static final String API_SERVER_URL = "http://api.3023.com/barcode/barcode?barcode=BARCODE";

    @Test
    public void doIt() throws Exception {
        String url = API_SERVER_URL.replace("BARCODE", "6936292120079");
        URI uri = new URI(url);

        HttpGet httpGet = new HttpGet(uri);
        httpGet.setHeader("3023-key", appKey);

        doGet(httpGet);

        int i = 0;
    }

    @Test
    public void forReqImg() throws Exception {
        long code = 6936292120000l;
        HttpGet httpGet = new HttpGet();
        URI uri;

        for (int i = 0; i < 80; i++) {
            code += i;
            String url = "http://www.anccnet.com/comm/GTIN.aspx?GTIN=0".concat(String.valueOf(code));

            uri = new URI(url);
            httpGet.setURI(uri);
            doGet(httpGet);
        }

        int i = 0;
    }

    private static void doGet(HttpGet httpGet) throws Exception {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse response = httpClient.execute(httpGet);

        StatusLine statusLine = response.getStatusLine();
        int code = statusLine.getStatusCode();
        System.out.println("返回code值: " + code);
        if (code == HttpStatus.SC_OK) {
            String entityToStr = EntityUtils.toString(response.getEntity(), Charset.defaultCharset().displayName());
            System.out.println(entityToStr);
        }

        httpGet.completed();
    }

}
