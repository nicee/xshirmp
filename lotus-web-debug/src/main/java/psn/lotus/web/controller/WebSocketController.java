package psn.lotus.web.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import psn.lotus.web.bean.Greeting;
import psn.lotus.web.bean.SimpleMessage;

/**
 * @project lotus
 * @time 2017/6/6 13:19
 */
@Controller()
public class WebSocketController {

    @MessageMapping(value = "/greet")
    @SendTo(value = "/topic/greeting")
    public Greeting greeting(SimpleMessage message) throws Exception {
        Thread.sleep(1000);
        return new Greeting("hello, " + message.getName());
    }

}
