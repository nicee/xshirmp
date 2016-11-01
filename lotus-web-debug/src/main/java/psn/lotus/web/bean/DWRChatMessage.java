package psn.lotus.web.bean;

import java.util.Date;

/**
 * @project lotus
 * @time 2016/10/31 17:49
 */
public class DWRChatMessage {

    private int id;

    private String message;

    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
