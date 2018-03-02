package psn.lotus.web.support.socketio;

import com.corundumstudio.socketio.AckCallback;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.DataListener;
import psn.lotus.web.bean.ChatMessage;

/**
 * @project lotus
 * @time 2017/6/7 14:10
 */
public class ChatDataListener implements DataListener<ChatMessage> {

    @Override
    public void onData(SocketIOClient socketIOClient, ChatMessage chatMessage, AckRequest ackRequest) throws Exception {
        if (ackRequest.isAckRequested()) {
            ackRequest.sendAckData("client message was delivered to server!", "yeah!");
        }

        ChatMessage chatMessageAck = new ChatMessage(chatMessage.getUsername(), "message with ack data");
        socketIOClient.sendEvent("ackevent2", new AckCallback<String>(String.class) {
            @Override
            public void onSuccess(String result) {
                System.out.println("ack from client: " + socketIOClient.getSessionId() + " data: " + result);
            }
        }, chatMessageAck);
    }

}
