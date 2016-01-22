package psn.lotus.wechat.api.achive;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FilenameUtils;
import org.apache.http.util.Args;
import org.springframework.stereotype.Service;
import psn.lotus.wechat.Urls;
import psn.lotus.wechat.api.BulkMessageAPI;
import psn.lotus.wechat.param.BulkMessageType;
import psn.lotus.wechat.param.message.GroupRequest;
import psn.lotus.wechat.param.message.OpenIdsRequest;
import psn.lotus.wechat.param.meterial.NewsMaterialRequest;
import psn.lotus.wechat.param.meterial.VideoMaterialRequest;

import java.io.File;

/**
 * 群发接口实现
 *
 * @author: nicee
 * @since: 2016/1/21
 */
@Service
public class BulkMessageAch extends AbstractBasedAch implements BulkMessageAPI {

    public String uploadImage(File image) {
        Args.check(image != null && image.exists(), "Image file invalid, check it.");
        String extension = FilenameUtils.getExtension(image.getName());
        Args.check(extension.equals("jpg") || extension.equals("png"), "Image file format invalid, just support for jpg/png.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.UPLOAD_IMG_URL);
        JSONObject result = httpRequest.doPost(targetUrl, image, responseHandler);
        return result.getString("url");
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

    public JSONObject uploadVideo(VideoMaterialRequest video) {
        Args.notNull(video, "Video material could not be null.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.UPLOAD_VIDEO_URL);
        return httpRequest.doPost(targetUrl, video.toString(), responseHandler);
    }

    public JSONObject sendMessageByGroup(GroupRequest groupParam) {
        Args.notNull(groupParam, "Group param could not be null.");
        BulkMessageType type = groupParam.getMsgtype();
//        Args.check(type.equals(BulkMessageType.text) && groupParam.getContent() != null && !groupParam.getContent().isEmpty(), "Text message could not be empty.");
//        Args.check(type.equals(BulkMessageType.wxcard) && groupParam.getCard_id() != null && !groupParam.getCard_id().isEmpty(), "Card id could not be empty.");
//        Args.check(groupParam.getMedia_id() != null && !groupParam.getMedia_id().isEmpty(), "Media id is not be set.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.SEND_MESSAGE_BY_GROUP);
        return httpRequest.doPost(targetUrl, groupParam.toString(), responseHandler);
    }

    public JSONObject sendMessageByOpenIds(OpenIdsRequest openIdsParam) {
        Args.notNull(openIdsParam, "Open ids param could not be null.");
        BulkMessageType type = openIdsParam.getMsgtype();
        Args.check(type.equals(BulkMessageType.text) && openIdsParam.getContent() != null && !openIdsParam.getContent().isEmpty(), "Text message could not be empty.");
        Args.check(type.equals(BulkMessageType.wxcard) && openIdsParam.getCard_id() != null && !openIdsParam.getCard_id().isEmpty(), "Card id could not be empty.");
        Args.check(openIdsParam.getMedia_id() != null && !openIdsParam.getMedia_id().isEmpty(), "Media id is not be set.");
        String targetUrl = accessTokenAPI.replaceAccessToken(Urls.SEND_MESSAE_BY_OPEN_IDS);
        return httpRequest.doPost(targetUrl, openIdsParam.toString(), responseHandler);
    }


}
