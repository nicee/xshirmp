package psn.lotus.wechat.api.achive;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FilenameUtils;
import org.apache.http.util.Args;
import org.springframework.stereotype.Service;
import psn.lotus.wechat.Urls;
import psn.lotus.wechat.api.MaterialAPI;
import psn.lotus.wechat.param.MaterialType;
import psn.lotus.wechat.param.meterial.NewsMaterialRequest;
import psn.lotus.wechat.param.meterial.QueryMaterialsRequest;
import psn.lotus.wechat.param.meterial.TempMaterialRequest;
import psn.lotus.wechat.param.meterial.VideoMaterialRequest;

import java.io.File;
import java.util.Map;

/**
 * 素材管理实现
 *
 * @author: nicee
 * @since: 2016/1/20
 */
@Service
public final class MaterialAch extends AbstractBasedAch implements MaterialAPI {

    public String uploadImage(File image) {
        Args.check(image != null && image.exists(), "Image file invalid, check it.");
        String extension = FilenameUtils.getExtension(image.getName());
        Args.check(extension.equals("jpg") || extension.equals("png"), "Image file format invalid, just support for jpg/png.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.UPLOAD_IMG_URL);
        JSONObject result = httpRequest.doPost(targetUrl, image, responseHandler);
        return result.getString("url");
    }

    public JSONObject uploadVideo(VideoMaterialRequest video) {
        Args.notNull(video, "Video material could not be null.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.UPLOAD_VIDEO_URL);
        return httpRequest.doPost(targetUrl, video.toString(), responseHandler);
    }

    public JSONObject uploadAnyMaterial(File file, Map<String, Object> params) {
        Args.notNull(file, "Material file could not be null.");
        Args.check(params != null && params.containsKey("type"), "Material upload lose params requires, such as 'type', check it.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.UPLOAD_OTHERS_MATERIAL_URL);

        //TODO 处理不同类型的媒体文件，暂时未处理
        String reqParams = JSONObject.toJSONString(params);

        return httpRequest.doPost(targetUrl, file, responseHandler);
    }

    public JSONObject uploadMPNews(NewsMaterialRequest[] materials) {
        Args.notNull(materials, "Mpnews material could not be null.");
        Args.check(materials.length > 1 && materials.length < 8, "Mpnews material length is between 1 and 8.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.UPLOAD_MPNEW_URL);
        StringBuffer buffer = new StringBuffer();
        buffer.append("{\"articles\":[");
        for (NewsMaterialRequest material : materials) {
            buffer.append(material);
        }
        buffer.append("]}");
        return httpRequest.doPost(targetUrl, buffer.toString(), responseHandler);
    }

    public JSONObject uploadTempMaterial(TempMaterialRequest material) {
        Args.notNull(material, "material could not be null.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.UPLOAD_TMP_MATERIAL_URL);
        MaterialType mediaType = material.getType();
        targetUrl.replace("TYPE", mediaType.name());
        return httpRequest.doPost(targetUrl, material.getFile(), responseHandler);
    }

    public JSONObject downloadTempMaterial(String mediaId) {
        Args.notNull(mediaId, "media id could not be null.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.DOWNLOAD_TEMP_MATERIAL_URL).replace("MEDIA_ID", mediaId);
        return httpRequest.doGet(targetUrl, responseHandler);
    }

    public JSONObject addPermanentMaterial(TempMaterialRequest material) {
        Args.notNull(material, "material could not be null.");
        return null;
    }

    public String addNewsMaterial(NewsMaterialRequest[] newsMaterials) {
        Args.notNull(newsMaterials, "mpnews material could not be null.");
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

    public JSONObject getMaterialsTypeSorted(QueryMaterialsRequest queryRequest) {
        Args.notNull(queryRequest, "material query object could not be null.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.GET_SIMPLE_MATERIAL_URL);
        return httpRequest.doPost(targetUrl, queryRequest.toString(), responseHandler);
    }

    public JSONObject getPermanentMaterial(String mediaId) {
        Args.notNull(mediaId, "media id could not be null.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.GET_PERMANENT_MATERIAL_DETAIL_URL);
        String requestParam = "{\"media_id\":" + JSONObject.toJSONString(mediaId) + "}";
        return httpRequest.doPost(targetUrl, requestParam, responseHandler);
    }

    public JSONObject materialCountDetail() {
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.GET_MATERIAL_COUNT_URL);
        return httpRequest.doGet(targetUrl, responseHandler);
    }

    public void removePermanentMaterial(String mediaId) {
        Args.notNull(mediaId, "media id could not be null.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.DELETE_PERMANENT_MATERIAL_URL);
        String requestParam = "{\"media_id\":" + JSONObject.toJSONString(mediaId) + "}";
        httpRequest.doPost(targetUrl, requestParam, responseHandler);
    }

    public void updateMPNews(String mediaId, Integer index, NewsMaterialRequest material) {
        Args.notNull(mediaId, "media id could not be null.");
        Args.notNull(material, "mpnews param could not be null.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.UPDATE_MPNEWS_URL);
        if (index != null && index < 0) index = 1;
        StringBuffer buffer = new StringBuffer();
        buffer.append("{\"media_id\":\"").append(mediaId).append("\",\"index\":").append(index);
        buffer.append(",\"articles\":{").append(material.toString()).append("}}");
        httpRequest.doPost(targetUrl, buffer.toString(), responseHandler);
    }

}
