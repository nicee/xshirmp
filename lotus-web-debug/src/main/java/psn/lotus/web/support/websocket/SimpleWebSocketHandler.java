package psn.lotus.web.support.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.*;
import psn.lotus.web.service.WebSocketService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @project lotus
 * @time 2017/6/6 15:32
 */
public class SimpleWebSocketHandler implements WebSocketHandler {

    private static final Logger logger = LoggerFactory.getLogger(SimpleWebSocketHandler.class);

    private static final List<WebSocketSession> users = new ArrayList<>();

    @Autowired
    private WebSocketService webSocketService;

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        users.add(webSocketSession);

        Map<String, Object> attributes = webSocketSession.getAttributes();
        String username = (String) attributes.get("username");
        String uri = String.valueOf(webSocketSession.getUri());
        logger.info("user[" + username + "]connect to the websocket success, from uri[" + uri + "]");

        if (Objects.nonNull(username)) {
            int num = webSocketService.getUnReadNews(username);
            if (num > 0) {
                webSocketSession.sendMessage(new TextMessage("您有" + String.valueOf(num) + "条未读消息"));
            }
        }
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        logger.info("ready to send message...");

    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        logger.debug("websocket connection closed...");
        if (closeStatus.getCode() == 200) {
            users.remove(webSocketSession);
        }
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

}
