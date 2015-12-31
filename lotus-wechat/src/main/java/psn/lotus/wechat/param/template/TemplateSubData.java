package psn.lotus.wechat.param.template;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @author: nicee
 * @since: 2015/12/29
 */
public class TemplateSubData implements Serializable {

    private static final long serialVersionUID = 7738625782240426927L;

    private String value;

    private String color;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
