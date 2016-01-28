package psn.lotus.wechat.api;

import com.alibaba.fastjson.JSONObject;
import psn.lotus.wechat.param.meterial.NewsMaterialRequest;
import psn.lotus.wechat.param.meterial.QueryMaterialsRequest;
import psn.lotus.wechat.param.meterial.TempMaterialRequest;
import psn.lotus.wechat.param.meterial.VideoMaterialRequest;

import java.io.File;
import java.util.Map;

/**
 * 素材管理
 *
 * @author: nicee
 * @since: 2016/1/20
 */
public interface MaterialAPI {

    /**
     * 上传图文消息内图片，获取URL，此处素材为永久素材
     *
     * @param image 图片，格式仅支持jps/png
     * @return 图片url地址
     */
    String uploadImage(File image);

    /**
     * 上传视频素材，提供给群发使用
     *
     * @param video 视频素材
     * @return 响应数据
     */
    JSONObject uploadVideo(VideoMaterialRequest video);

    /**
     * 模拟form表单，上传素材文件到微信服务器，此处文件为永久素材
     *
     * @param file   素材文件
     * @param params form参数，必须包含一个key为type的字符，用于说明素材类型
     * @return 响应数据
     */
    JSONObject uploadAnyMaterial(File file, Map<String, Object> params);

    /**
     * 上传图文消息素材
     *
     * @param materials 图文素材
     * @return 响应数据
     */
    JSONObject uploadMPNews(NewsMaterialRequest[] materials);

    //----------------  临时素材    --------------------

    /**
     * 上传临时素材，仅在服务器保留3天
     *
     * @param material 素材
     * @return 成功时：key(type，media_id，created_at)
     */
    JSONObject uploadTempMaterial(TempMaterialRequest material);

    /**
     * 下载临时素材
     *
     * @param mediaId 素材ID
     * @return 素材流
     */
    JSONObject downloadTempMaterial(String mediaId);

    //----------------  永久素材    --------------------

    /**
     * 新增永久素材
     *
     * @param material 素材
     * @return
     */
    JSONObject addPermanentMaterial(TempMaterialRequest material);

    /**
     * 新增图文信息素材
     *
     * @param newsMaterials 图文素材数组
     * @return 素材ID
     */
    String addNewsMaterial(NewsMaterialRequest[] newsMaterials);

    /**
     * 分类获取永久素材，最多20个
     *
     * @param queryRequest
     * @return 素材内容
     */
    JSONObject getMaterialsTypeSorted(QueryMaterialsRequest queryRequest);

    /**
     * 获取永久素材，包括各种图文、图片、音频等
     *
     * @param mediaId 素材ID
     * @return 素材内容
     */
    JSONObject getPermanentMaterial(String mediaId);

    /**
     * 素材统计详情
     *
     * @return 响应数据
     */
    JSONObject materialCountDetail();

    /**
     * 删除永久素材
     *
     * @param mediaId 素材ID
     */
    void removePermanentMaterial(String mediaId);

    /**
     * 修改永久图文素材
     *
     * @param mediaId  图文素材ID
     * @param index    更新文章在图文消息中的位置
     * @param material 图文素材POST数据
     */
    void updateMPNews(String mediaId, Integer index, NewsMaterialRequest material);

}
