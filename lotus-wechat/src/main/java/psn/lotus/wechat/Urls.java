package psn.lotus.wechat;

/**
 * 微信接口url
 *
 * @author: nicee
 * @since: 2016/1/15
 */
public interface Urls {

    /**
     * 获取access token
     */
    String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    //-------------------------------------- 消息管理 url --------------------------------------

    /**
     * 设置行业类别
     */
    String SETTING_INDUSTRY_URL = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";

    /**
     * 创建模板ID并获取
     */
    String GET_TEMPLATE_ID_URL = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN";

    /**
     * 发送模板消息
     */
    String SEND_TEMPLATE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";

    //-------------------------------------- 卡券管理 url --------------------------------------

    /**
     * 通过二维码投放卡券
     */
    String CARD_DELIVERED_TO_QRCODE_URL = "https://api.weixin.qq.com/card/qrcode/create?access_token=ACCESS_TOKEN";

    /**
     * 创建货架URL
     */
    String CREATE_LANDINGPAGE_URL = "https://api.weixin.qq.com/card/landingpage/create?access_token=ACCESS_TOKEN";

    /**
     * 图文群发接口
     */
    String GET_MPNEWS_OF_CARD_URL = "https://api.weixin.qq.com/card/mpnews/gethtml?access_token=ACCESS_TOKEN";

    //-------------------------------------- 素材管理 url --------------------------------------

    /**
     * 上传临时素材
     */
    String UPLOAD_TMP_MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";

    /**
     * 下载临时素材
     */
    String DOWNLOAD_TEMP_MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";

    /**
     * 新建永久图文素材
     */
    String CREATE_NEWS_MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";

    /**
     * 上传图片素材，仅支持jpg/png
     */
    //TODO 考证是否为永久素材
    String UPLOAD_IMG_URL = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";

    /**
     * 上传其他永久素材（图片（image）、语音（voice）、视频（video）和缩略图（thumb））
     */
    String UPLOAD_OTHERS_MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN";

    /**
     * 获取简单素材
     */
    String GET_SIMPLE_MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";

    /**
     * 获取永久素材
     */
    String GET_PERMANENT_MATERIAL_DETAIL_URL = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";

    /**
     * 获取素材统计数量
     */
    String GET_MATERIAL_COUNT_URL = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN";

    /**
     * 删除永久素材
     */
    String DELETE_PERMANENT_MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN";

    /**
     * 修改永久图文素材
     */
    String UPDATE_MPNEWS_URL = "https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=ACCESS_TOKEN";

    //-------------------------------------- 群发管理 url --------------------------------------

    /**
     * 上传视频素材
     */
    //TODO check url cause of difference.
    //open ids -> https://api.weixin.qq.com/cgi-bin/media/uploadvideo?access_token=ACCESS_TOKEN
    String UPLOAD_VIDEO_URL = "https://file.api.weixin.qq.com/cgi-bin/media/uploadvideo?access_token=ACCESS_TOKEN";

    /**
     * 上传图文素材
     */
    String UPLOAD_MPNEW_URL = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN";

    /**
     * 分组群发消息（文本，图文，图片，音频等）
     */
    String SEND_MESSAGE_BY_GROUP = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN";

    /**
     * 根据open id列表群发消息（文本，图文，图片，音频等）
     */
    String SEND_MESSAGE_BY_OPEN_IDS = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN";

    /**
     * 删除群发消息
     */
    String DELETE_BULK_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token=ACCESS_TOKEN";

    /**
     * 预览消息，群发信息
     */
    String PREVIEW_MSG_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN";

    /**
     * 查看消息发送状态
     */
    String CHECK_SEND_STATUS_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/get?access_token=ACCESS_TOKEN";

    //-------------------------------------- 用户管理 url --------------------------------------

    /**
     * 用户组信息URL
     */
    String USER_GROUP_URL = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=ACCESS_TOKEN";

}
