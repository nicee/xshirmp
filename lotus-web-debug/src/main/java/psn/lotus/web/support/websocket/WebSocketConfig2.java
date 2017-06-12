package psn.lotus.web.support.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @project lotus
 * @time 2017/6/6 15:20
 */
//@Configuration
//@EnableWebMvc
//@EnableWebSocket
public class WebSocketConfig2 extends WebMvcConfigurerAdapter implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(createHandler(), "simple websocket handler");
    }

    @Bean
    public SimpleWebSocketHandler createHandler() {
        return new SimpleWebSocketHandler();
    }

}
