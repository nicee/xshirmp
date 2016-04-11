package psn.lotus.aliyun;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.junit.Test;

/**
 * @author xjl
 * @project lotus
 * @time 2016/4/7 10:12
 */
public class ONSTest {

    @Test
    public void acs() {
        String regionId = "cn-hangzhou";
        String accessKey = "waLW9oWIkyE4Dvi2";
        String secretKey = "LvFlpDQIDnMdMtMWyRW1fFTjH3vqZC";
        IClientProfile profile = DefaultProfile.getProfile(regionId, accessKey, secretKey);
        IAcsClient iAcsClient = new DefaultAcsClient(profile);

    }

}
