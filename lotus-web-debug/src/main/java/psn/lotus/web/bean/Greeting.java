package psn.lotus.web.bean;

import java.io.Serializable;

/**
 * @project lotus
 * @time 2017/6/6 13:46
 */
public class Greeting implements Serializable {

    private String content;

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
