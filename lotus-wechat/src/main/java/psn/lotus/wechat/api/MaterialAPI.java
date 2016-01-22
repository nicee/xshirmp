package psn.lotus.wechat.api;

import com.alibaba.fastjson.JSONObject;
import psn.lotus.wechat.param.MaterialType;
import psn.lotus.wechat.param.meterial.NewsMaterialRequest;
import psn.lotus.wechat.param.meterial.QueryMaterialsRequest;
import psn.lotus.wechat.param.meterial.TempMaterialRequest;

import java.io.File;

/**
 * 素材管理
 *
 * @author: nicee
 * @since: 2016/1/20
 */
public interface MaterialAPI {

    //----------------  临时素材    --------------------

    /**
     * 新增临时素材
     *
     * @param material 素材
     * @return 成功时：key(type，media_id，created_at)
     */
    JSONObject addTempMaterial(TempMaterialRequest material);

    /**
     * 获取临时素材
     *
     * @param mediaId 素材ID
     * @return 素材流
     */
    JSONObject getTempMaterial(String mediaId);

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
     * 获取简单素材，最多20个
     *
     * @param queryRequest
     * @return 素材内容
     */
    JSONObject getSimpleMaterials(QueryMaterialsRequest queryRequest);

    /**
     * 获取永久素材，包括各种图文、图片、音频等
     *
     * @param mediaId 素材ID
     * @return 素材内容
     */
    JSONObject getPermanentMaterial(String mediaId);

}
