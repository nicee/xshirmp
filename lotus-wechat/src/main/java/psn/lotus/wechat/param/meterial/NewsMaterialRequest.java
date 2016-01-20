package psn.lotus.wechat.param.meterial;

import com.alibaba.fastjson.JSONObject;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 图文素材POST数据
 *
 * @author: nicee
 * @since: 2016/1/20
 */
public class NewsMaterialRequest implements Serializable {

    private static final long serialVersionUID = 6873035674541725444L;

    @NotNull(message = "标题不能为空")
    private String title;

    @NotNull(message = "缩略图不能为空")
    private String thumb_media_id;

    @NotNull(message = "作者不能为空")
    private String author;

    @NotNull(message = "摘要不能为空")
    private String digest;

    @NotNull(message = "显示封面标志不能为空")
    @Range(min = 0, max = 1, message = "显示封面标志数据错误")
    private Integer show_cover_pic;

    @NotNull(message = "图文内容不能为空")
    private String content;

    @NotNull(message = "图文原文地址不能为空")
    private String content_source_url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb_media_id() {
        return thumb_media_id;
    }

    public void setThumb_media_id(String thumb_media_id) {
        this.thumb_media_id = thumb_media_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public Integer getShow_cover_pic() {
        return show_cover_pic;
    }

    public void setShow_cover_pic(Integer show_cover_pic) {
        this.show_cover_pic = show_cover_pic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent_source_url() {
        return content_source_url;
    }

    public void setContent_source_url(String content_source_url) {
        this.content_source_url = content_source_url;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
