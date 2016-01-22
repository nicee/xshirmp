package psn.lotus.wechat.api;

import com.alibaba.fastjson.JSONObject;
import psn.lotus.wechat.param.message.GroupRequest;
import psn.lotus.wechat.param.message.OpenIdsRequest;
import psn.lotus.wechat.param.meterial.NewsMaterialRequest;
import psn.lotus.wechat.param.meterial.VideoMaterialRequest;

import java.io.File;

/**
 * 群发接口实现
 *
 * @author: nicee
 * @since: 2016/1/20
 */
public interface BulkMessageAPI {

    /**
     * 上传图文消息内图片，获取URL
     *
     * @param image 图片，格式仅支持jps/png
     * @return 图片url地址
     */
    String uploadImage(File image);

    /**
     * 上传图文消息素材
     *
     * @param materials 图文素材
     * @return 响应数据
     */
    JSONObject uploadMPNews(NewsMaterialRequest[] materials);

    /**
     * 上传视频素材，提供给群发使用
     *
     * @param video 视频素材
     * @return 响应数据
     */
    JSONObject uploadVideo(VideoMaterialRequest video);

    /**
     * 按组发送信息
     *
     * @param groupParam 组参数
     * @return 响应数据
     */
    JSONObject sendMessageByGroup(GroupRequest groupParam);

    /**
     * 按open id发送消息
     *
     * @param openIdsParam open id参数
     * @return 响应数据
     */
    JSONObject sendMessageByOpenIds(OpenIdsRequest openIdsParam);

}
