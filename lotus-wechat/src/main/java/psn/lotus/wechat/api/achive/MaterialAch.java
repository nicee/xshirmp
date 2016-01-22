package psn.lotus.wechat.api.achive;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.util.Args;
import org.springframework.stereotype.Service;
import psn.lotus.wechat.Urls;
import psn.lotus.wechat.api.MaterialAPI;
import psn.lotus.wechat.param.MaterialType;
import psn.lotus.wechat.param.meterial.NewsMaterialRequest;
import psn.lotus.wechat.param.meterial.QueryMaterialsRequest;
import psn.lotus.wechat.param.meterial.TempMaterialRequest;

/**
 * 素材管理实现
 *
 * @author: nicee
 * @since: 2016/1/20
 */
@Service
public final class MaterialAch extends AbstractBasedAch implements MaterialAPI {

    public JSONObject addTempMaterial(TempMaterialRequest material) {
        Args.notNull(material, "Material could not be null.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.CREATE_TMP_MATERIAL_URL);
        MaterialType mediaType = material.getType();
        targetUrl.replace("TYPE", mediaType.name());
        return httpRequest.doPost(targetUrl, material.getFile(), responseHandler);
    }

    public JSONObject getTempMaterial(String mediaId) {
        Args.notNull(mediaId, "Media id could not be null.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.DOWNLOAD_MATERIAL_URL).replace("MEDIA_ID", mediaId);
        return httpRequest.doGet(targetUrl, responseHandler);
    }

    public JSONObject addPermanentMaterial(TempMaterialRequest material) {
        Args.notNull(material, "material could not be null.");
        return null;
    }

    public String addNewsMaterial(NewsMaterialRequest[] newsMaterials) {
        Args.notNull(newsMaterials, "Mpnews material could not be null.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.CREATE_NEWS_MATERIAL_URL);
        StringBuffer buffer = new StringBuffer();
        buffer.append("{\"articles\":[");
        for (NewsMaterialRequest material : newsMaterials) {
            buffer.append(material);
        }
        buffer.append("]}");
        JSONObject result = httpRequest.doPost(targetUrl, buffer.toString(), responseHandler);
        return result.getString("media_id");
    }

    public JSONObject getSimpleMaterials(QueryMaterialsRequest queryRequest) {
        Args.notNull(queryRequest, "material query object could not be null.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.GET_SIMPLE_MATERIAL_URL);
        return httpRequest.doPost(targetUrl, queryRequest.toString(), responseHandler);
    }

    public JSONObject getPermanentMaterial(String mediaId) {
        Args.notNull(mediaId, "media id could not be null.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.GET_PERMANENT_MATERIAL_URL);
        String requestParam = "{\"media_id\":" + JSONObject.toJSONString(mediaId) + "}";
        return httpRequest.doPost(targetUrl, requestParam, responseHandler);
    }

}
