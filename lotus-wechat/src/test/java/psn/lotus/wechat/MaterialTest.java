package psn.lotus.wechat;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import psn.lotus.wechat.api.CardAPI;
import psn.lotus.wechat.api.MaterialAPI;
import psn.lotus.wechat.param.MaterialType;
import psn.lotus.wechat.param.meterial.NewsMaterialRequest;
import psn.lotus.wechat.param.meterial.QueryMaterialsRequest;
import psn.lotus.wechat.param.meterial.TempMaterialRequest;
import psn.lotus.wechat.param.template.PMaterialType;

import java.io.File;

/**
 * 素材管理测试
 *
 * @author: nicee
 * @since: 2016/1/20
 */
@ContextConfiguration(locations = {"classpath:/spring/spring-context.xml"})
public class MaterialTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private MaterialAPI materialAPI;

    @Autowired
    private CardAPI cardAPI;

    @Test(enabled = false)
    public void testTemp() {
        TempMaterialRequest tmpMaterial = new TempMaterialRequest();
        tmpMaterial.setType(MaterialType.IMAGE);
        tmpMaterial.setFile(new File("D:\\tt.jpg"));
        JSONObject image = materialAPI.uploadTempMaterial(tmpMaterial);
        System.out.println(image);
    }

    @Test(enabled = false)
    public void testNews() {
        //获取卡券链接
        String link = cardAPI.getMPNews("pVLeQt6tEJywK_mzt-LZacPM2mvs");

        //准备数据
        NewsMaterialRequest material = new NewsMaterialRequest();
        material.setTitle("图文标题");
        material.setAuthor("nicee");
        material.setThumb_media_id("nvuPuFybp7PemE1mpvNnzDFE31xufOK9A81HlJLLhaA");
        material.setContent_source_url("https://www.baidu.com");
        material.setShow_cover_pic(0);
        material.setDigest("这是一个测试卡券嵌入的图文消息");
        material.setContent(link);

        String mediaId = materialAPI.addNewsMaterial(new NewsMaterialRequest[]{material});
        System.out.println(mediaId);
    }

    @Test
    public void testGet() {
        QueryMaterialsRequest request = new QueryMaterialsRequest();
        request.setType(PMaterialType.news);
        request.setCount(20);
        request.setOffset(0);

        //image media_id => nvuPuFybp7PemE1mpvNnzJmsVAWs0-g5aCeXrm_ygdc
        //news media_id => vrflnsZATR7Z9Tr29VHgXEflky3m-HzemR3uZprxFH8

        JSONObject result = materialAPI.getMaterialsTypeSorted(request);
        System.out.println(result);
    }

    @Test
    public void testGetLong() {
        String mediaId = "vrflnsZATR7Z9Tr29VHgXEflky3m-HzemR3uZprxFH8";
        JSONObject result = materialAPI.getPermanentMaterial(mediaId);
        System.out.println(result);
    }

    @Test
    public void testUploadImg() {
        File file = new File("D:\\tt.jpg");
        String url = materialAPI.uploadImage(file);
        System.out.println(url);
    }

    @Test
    public void testDownload() {
        String mediaId = "vrflnsZATR7Z9Tr29VHgXEflky3m-HzemR3uZprxFH8";
        JSONObject result = materialAPI.downloadTempMaterial(mediaId);
    }

    @Test
    public void testCount() {
        JSONObject result = materialAPI.materialCountDetail();
        System.out.println(result);
    }

}
