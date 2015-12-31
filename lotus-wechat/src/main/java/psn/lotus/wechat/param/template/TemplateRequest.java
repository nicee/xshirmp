package psn.lotus.wechat.param.template;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.Map;

/**
 * @author: nicee
 * @since: 2015/12/29
 */
public class TemplateRequest implements Serializable {

    private static final long serialVersionUID = 6005334940597792744L;

    private String topcolor;

    private String template_id;

    private String touser;

    private String url;

    private Map<String, TemplateSubData> data;

    public String getTopcolor() {
        return topcolor;
    }

    public void setTopcolor(String topcolor) {
        this.topcolor = topcolor;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, TemplateSubData> getData() {
        return data;
    }

    public void setData(Map<String, TemplateSubData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
