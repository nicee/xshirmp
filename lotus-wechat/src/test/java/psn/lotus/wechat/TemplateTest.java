package psn.lotus.wechat;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import psn.lotus.wechat.client.TemplateClient;
import psn.lotus.wechat.param.template.TemplateSubData;
import psn.lotus.wechat.url.TemplateAPI;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: nicee
 * @since: 2015/12/30
 */

public class TemplateTest {

    @Test
    public void testGet() {
        TemplateAPI templateAPI = new TemplateClient();
        String shortId = "1";
        templateAPI.getTemplateId(shortId);
    }

    @Test
    public void testSend() {
        TemplateAPI templateAPI = new TemplateClient();
        Map<String, Object> requestParam = new HashMap<String, Object>();
        requestParam.put("url", "http://www.baidu.com");
        requestParam.put("touser", "om5fqstmkv4UNGMDcPI4B7V_Zbf8");
        requestParam.put("template_id", "EQJ6Q51WQyPQbT9okqnfi5a1oKsGRmKIw78xbgF-CwE");
        requestParam.put("topcolor", "#000000");

        Map<String, TemplateSubData> datas = new HashMap<String, TemplateSubData>();

        TemplateSubData first = new TemplateSubData();
        first.setColor("#000000");
        first.setValue("这是标题");
        datas.put("first", first);

        TemplateSubData keyword1 = new TemplateSubData();
        keyword1.setColor("#000000");
        keyword1.setValue("这是keyword1");
        datas.put("keyword1", keyword1);

        TemplateSubData keyword2 = new TemplateSubData();
        keyword2.setColor("#000000");
        keyword2.setValue("这是keyword2");
        datas.put("keyword2", keyword2);

        TemplateSubData keyword3 = new TemplateSubData();
        keyword3.setColor("#000000");
        keyword3.setValue("这是keyword3");
        datas.put("keyword3", keyword3);

        TemplateSubData keyword4 = new TemplateSubData();
        keyword4.setColor("#000000");
        keyword4.setValue("这是keyword4");
        datas.put("keyword4", keyword4);

        TemplateSubData keyword5 = new TemplateSubData();
        keyword5.setColor("#000000");
        keyword5.setValue("这是keyword5");
        datas.put("keyword5", keyword5);

        TemplateSubData remark = new TemplateSubData();
        remark.setColor("#000000");
        remark.setValue("这是结尾");
        datas.put("remark", remark);

        requestParam.put("data", datas);
        templateAPI.sendMessage(requestParam);
    }

}
