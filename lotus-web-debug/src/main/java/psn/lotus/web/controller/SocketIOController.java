package psn.lotus.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.xkeshi.messageplatform.sdk.api.TokenGenerateApi;
import com.xkeshi.messageplatform.sdk.api.UserImportApi;
import com.xkeshi.messageplatform.sdk.api.WebsocketMessageApi;
import com.xkeshi.messageplatform.sdk.common.proxy.MessageApiProxy;
import com.xkeshi.messageplatform.sdk.request.PushWebsocketMessageRequest;
import com.xkeshi.messageplatform.sdk.request.SingleExportUserRequest;
import com.xkeshi.messageplatform.sdk.request.TokenRequest;
import com.xkeshi.messageplatform.sdk.request.WebSocketMessageCategory;
import com.xkeshi.messageplatform.sdk.response.ResultResponse;
import com.xkeshi.messageplatform.sdk.response.WsTokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @project lotus
 * @time 2017/6/7 13:39
 */
@Controller
public class SocketIOController {

    private static final Logger logger = LoggerFactory.getLogger(SocketIOController.class);

    private static final Long USER_ID = 100L;
    private static final Long BUSINESS_ID = 114239L;
    private static final String BUSINESS_TYPE = "SHOP";
    private static final String PLATFORM = "KOUBEI_TEST";
    private static final String ROLE = "test";

    @RequestMapping(value = "/socket")
    public String socket() {
        return "socket";
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ResultResponse register() {
        ResultResponse response = MessageApiProxy
                .getInstance(UserImportApi.class).singleSave(initSingleUser());
        logger.info("save one user: " + JSONObject.toJSONString(response));
        return response;
    }

    private SingleExportUserRequest initSingleUser() {
        SingleExportUserRequest userRequest = new SingleExportUserRequest();
        userRequest.setRole(ROLE);
        userRequest.setUserId(USER_ID);
        userRequest.setPlatform(PLATFORM);
        userRequest.setBusinessId(BUSINESS_ID);
        userRequest.setBusinessType(BUSINESS_TYPE);
        return userRequest;
    }

    @ResponseBody
    @RequestMapping(value = "/token", method = RequestMethod.GET)
    public String token() {
//        WsTokenResponse response = MessageApiProxy
//                .getInstance(TokenGenerateApi.class).wsCToken(initSessionRequest());
//        String token = response.getWsToken();
        String token = "SOCKET-20170608102135-Q19DTElFTlQsS09VQkVJX1RFU1QsMTAwLDExNDIzOSxTSE9Q-314";
        logger.info("get token: " + token);
        return token;
    }

    private TokenRequest initSessionRequest() {
        TokenRequest tokenRequest = new TokenRequest();
        tokenRequest.setRole(ROLE);
        tokenRequest.setUserId(USER_ID);
        tokenRequest.setPlatform(PLATFORM);
        tokenRequest.setBusinessId(BUSINESS_ID);
        tokenRequest.setBusinessType(BUSINESS_TYPE);
        return tokenRequest;
    }

    @ResponseBody
    @RequestMapping(value = "/message/push", method = RequestMethod.GET)
    public String push() {
        MessageApiProxy.getInstance(WebsocketMessageApi.class).pushMessage(buildOneMessage());

        logger.info("成功测试推送一条消息给消息平台");
        return "推送成功";
    }

    private PushWebsocketMessageRequest buildOneMessage() {
        PushWebsocketMessageRequest messageRequest = new PushWebsocketMessageRequest();
        messageRequest.setRole(ROLE);
        messageRequest.setUserId(USER_ID);
        messageRequest.setPlatform(PLATFORM);
        messageRequest.setBusinessId(BUSINESS_ID);
        messageRequest.setBusinessType(BUSINESS_TYPE);
        messageRequest.setCategory(WebSocketMessageCategory.NOTIFY);

        messageRequest.setContent("{\"accountId\":10000256,\"content\":\"爱客仕通过您发起的333元提现申请，在1~3个工作日内将钱款打到账户，请注意查收。\",\"type\":\"WITHDRAW_AUDIT\",\"typeEnum\":\"WITHDRAW_AUDIT\",\"userType\":\"wemall_create_business_admin\",\"withdrawId\":74}");
        messageRequest.setCustomCategoryName("口碑socket测试");
        messageRequest.setCustomContent("这是自定义消息body...");
        return messageRequest;
    }

}
