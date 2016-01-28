package psn.lotus.open.api.achive;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import psn.lotus.HttpRequest;
import psn.lotus.open.Urls;
import psn.lotus.open.api.ComponentAccessTokenAPI;

/**
 * @author: nicee
 * @since: 2016/1/25
 */
@Service
public class ComponentAccessTokenAch implements ComponentAccessTokenAPI {

    @Value("${component_appid}")
    private String component_appid;

    @Value("${component_appsecret}")
    private String component_appsecret;

    @Value("${component_verify_ticket}")
    private String component_verify_ticket;

    @Autowired
    protected HttpRequest httpRequest;

    @Autowired
    protected ResponseHandler<JSONObject> responseHandler;

    public String getComponentAccessToken() {
        /*StringBuffer buffer = new StringBuffer();
        buffer.append("{\"component_appid\":\"").append(component_appid).append("\",\"component_appsecret\":\"").
                append(component_appsecret).append("\",\"component_verify_ticket\":\"").append(component_verify_ticket).append("\"}");
        JSONObject result = httpRequest.doPost(Urls.GET_COMPONENT_ACCESS_TOKEN, buffer.toString(), responseHandler);
        return result.getString("component_access_token");*/
        return "whhAWBHRiLP7sGa34jEr-tP0JkolIOeyo1h7iA8xKXXLSGeOC5WSr5r34f58wSobHTcNWJAhQXjdmY0gjA5wt8-QGonE2fo1YihQd0uaplX3viLZ736g6mkSuWOkwnFjIXQhALDLAT";
    }

    public String replaceComponentAccessToken(String srcUrl) {
        return srcUrl.replace("COMPONENT_ACCESS_TOKEN", getComponentAccessToken());
    }

}
