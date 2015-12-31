package psn.lotus.wechat.error;

/**
 * @author: nicee
 * @since: 2015/12/30
 */
public interface ErrorMessage {

    String LOAD_PROPERTIES_FAILURE = "Load default wechat configuration file name of '%s' failure";

    String ACCESS_TOKEN_INVALID = "Access token '%s' invalid";

    String CREATE_SSL_CONTEXT_FAILURE = "Create SSL/TLS context failure";

    String SEND_HTTPS_REQUEST_FAILURE = "Send https request failure";

    String CLOSE_HTTP_CLIENT_FAILURE = "close http client failure";

    String HTTP_POST_PARAMS_RESOLVER_ERROR = "Http post parameters resolved error";

}
