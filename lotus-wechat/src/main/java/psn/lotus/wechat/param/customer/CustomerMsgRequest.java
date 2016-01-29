package psn.lotus.wechat.param.customer;

import com.alibaba.fastjson.JSONObject;
import psn.lotus.wechat.param.CustomerMsgType;

import java.io.Serializable;

/**
 * @author: nicee
 * @since: 2016/1/29
 */
public class CustomerMsgRequest implements Serializable {

    private static final long serialVersionUID = 5436356642236063952L;

    private String touser;

    private CustomerMsgType msgtype;

    //text使用
    private String content;

    //image, voice
    private String media_id;

    private Video video;

    private Music music;

    private News[] news;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public CustomerMsgType getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(CustomerMsgType msgtype) {
        this.msgtype = msgtype;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public News[] getNews() {
        return news;
    }

    public void setNews(News[] news) {
        this.news = news;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{\"touser\":\"").append(touser).append("\", \"msgtype\":\"")
                .append(msgtype).append("\",\"").append(msgtype).append("\":");
        switch (msgtype) {
            case text:
                buffer.append("{\"content\":\"").append(content).append("\"}");
                break;
            case image:
            case voice:
                buffer.append("{\"media_id\":\"").append(media_id).append("\"}");
                break;
            case video:
                buffer.append(video);
                break;
            case music:
                buffer.append(music);
                break;
            case news:
                buffer.append("{\"articles\":").append(JSONObject.toJSONString(news)).append("}");
                break;
        }
        return buffer.toString();
    }

    public static class News {
        private String title;
        private String description;
        private String url;
        private String picurl;

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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

        @Override
        public String toString() {
            return JSONObject.toJSONString(this);
        }
    }

    public static class Music {
        private String title;
        private String description;
        private String musicurl;
        private String hqmusicurl;
        private String thumb_media_id;

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

        public String getMusicurl() {
            return musicurl;
        }

        public void setMusicurl(String musicurl) {
            this.musicurl = musicurl;
        }

        public String getHqmusicurl() {
            return hqmusicurl;
        }

        public void setHqmusicurl(String hqmusicurl) {
            this.hqmusicurl = hqmusicurl;
        }

        public String getThumb_media_id() {
            return thumb_media_id;
        }

        public void setThumb_media_id(String thumb_media_id) {
            this.thumb_media_id = thumb_media_id;
        }

        @Override
        public String toString() {
            return JSONObject.toJSONString(this);
        }
    }

    public static class Video {
        private String media_id;
        private String thumb_media_id;
        private String title;
        private String description;

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }

        public String getThumb_media_id() {
            return thumb_media_id;
        }

        public void setThumb_media_id(String thumb_media_id) {
            this.thumb_media_id = thumb_media_id;
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
}
