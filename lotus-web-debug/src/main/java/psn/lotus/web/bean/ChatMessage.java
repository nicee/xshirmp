package psn.lotus.web.bean;

import java.io.Serializable;

/**
 * @project lotus
 * @time 2017/6/7 14:08
 */
public class ChatMessage implements Serializable {

    private String mesasge;

    private String username;

    public ChatMessage() {
    }

    public ChatMessage(String mesasge, String username) {
        this.mesasge = mesasge;
        this.username = username;
    }

    public String getMesasge() {
        return mesasge;
    }

    public void setMesasge(String mesasge) {
        this.mesasge = mesasge;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
