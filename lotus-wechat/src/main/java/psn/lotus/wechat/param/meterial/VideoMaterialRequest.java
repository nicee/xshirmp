package psn.lotus.wechat.param.meterial;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * 视频素材
 *
 * @author: nicee
 * @since: 2016/1/21
 */
public class VideoMaterialRequest implements Serializable {

    private static final long serialVersionUID = 4877940515843518036L;

    private String media_id;

    private String title;

    private String description;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
