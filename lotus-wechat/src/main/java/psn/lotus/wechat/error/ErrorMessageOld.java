package psn.lotus.wechat.error;

/**
 * 错误信息
 *
 * @author: nicee
 * @since: 2015/12/30
 */
public interface ErrorMessageOld {

    /**
     * 加载微信配置文件失败
     * 注：改用spring注解方式注入，不再手动加载配置文件
     */
    @Deprecated
    String LOAD_PROPERTIES_FAILURE = "Load default wechat configuration file name of '%s' failure";

    /**
     * Access token 失效
     */
    String ACCESS_TOKEN_INVALID = "Access token '%s' invalid";

    /**
     * 创建SSL上下文失败
     */
    String CREATE_SSL_CONTEXT_FAILURE = "Create SSL/TLS context failure";

    /**
     * 发送HTTPS请求失败
     */
    String SEND_HTTPS_REQUEST_FAILURE = "Send https request failure";

    /**
     * 关闭HTTP客户端失败
     */
    String CLOSE_HTTP_CLIENT_FAILURE = "close http client failure";

    /**
     * HTTP post数据解析失败
     */
    String HTTP_POST_PARAMS_RESOLVER_ERROR = "Http post parameters resolved error";

}
