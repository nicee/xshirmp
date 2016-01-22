package psn.lotus.wechat.param;

/**
 * 群发消息类型
 *
 * @author: nicee
 * @since: 2016/1/20
 */
public enum BulkMessageType {
    /**
     * 图文
     */
    mpnews,
    /**
     * 图片
     */
    image,
    /**
     * 文本
     */
    text,
    /**
     * 语音
     */
    voice,
    /**
     * 音乐
     */
    music,
    /**
     * 视频(分组使用)
     */
    mpvideo,
    //openid使用
    video,
    /**
     * 卡券
     */
    wxcard;
}
