package psn.lotus.wechat;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Map;

/**
 * @author: nicee
 * @since: 2015/12/29
 */
public class WechatResponse implements Serializable {

    private static final long serialVersionUID = 4634312148483891204L;

    private int statusCode;

    private JSONObject content;

    public WechatResponse() {

    }



    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

}
