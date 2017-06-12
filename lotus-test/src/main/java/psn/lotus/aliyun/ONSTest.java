package psn.lotus.aliyun;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * @author xjl
 * @project lotus
 * @time 2016/4/7 10:12
 */
public class ONSTest {

//    @Test
    public void acs() {
        String regionId = "";
        String accessKey = "";
        String secretKey = "";
        IClientProfile profile = DefaultProfile.getProfile(regionId, accessKey, secretKey);
        IAcsClient iAcsClient = new DefaultAcsClient(profile);

    }

}
