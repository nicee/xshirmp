package psn.lotus.wechat.param.card;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * 货架数据
 *
 * @author: nicee
 * @since: 2016/1/19
 */
public class LandingPageRequest implements Serializable {

    private static final long serialVersionUID = 6272499791449225049L;

    private String banner;

    private String page_title;

    private boolean can_share;

    private Scene scene;

    private ThumbCard[] card_list;

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getPage_title() {
        return page_title;
    }

    public void setPage_title(String page_title) {
        this.page_title = page_title;
    }

    public boolean isCan_share() {
        return can_share;
    }

    public void setCan_share(boolean can_share) {
        this.can_share = can_share;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public ThumbCard[] getCard_list() {
        return card_list;
    }

    public void setCard_list(ThumbCard[] card_list) {
        this.card_list = card_list;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public static class ThumbCard {

        private String card_id;

        private String thumb_url;

        public String getCard_id() {
            return card_id;
        }

        public void setCard_id(String card_id) {
            this.card_id = card_id;
        }

        public String getThumb_url() {
            return thumb_url;
        }

        public void setThumb_url(String thumb_url) {
            this.thumb_url = thumb_url;
        }

        @Override
        public String toString() {
            return JSONObject.toJSONString(this);
        }
        
    }

    public enum Scene {
        SCENE_NEAR_BY, SCENE_MENU, SCENE_QRCODE, SCENE_ARTICLE, SCENE_H5, SCENE_IVR, SCENE_CARD_CUSTOM_CELL
    }

}
