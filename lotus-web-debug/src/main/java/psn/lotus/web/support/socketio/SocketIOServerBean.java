package psn.lotus.web.support.socketio;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;

import java.util.List;

/**
 * @project lotus
 * @time 2017/6/7 14:45
 */
public class SocketIOServerBean {

    private String hostname;

    private Integer port;

    private List<DataListener> listeners;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public List<DataListener> getListeners() {
        return listeners;
    }

    public void setListeners(List<DataListener> listeners) {
        this.listeners = listeners;
    }

    public void startServer() {
        Configuration configuration = new Configuration();
        configuration.setHostname(hostname);
        configuration.setPort(port);

        final SocketIOServer server = new SocketIOServer(configuration);
        if (listeners != null && !listeners.isEmpty()) {
            for (DataListener dataListener : listeners) {
                String clazzName = dataListener.getClass().getName();
                server.addListeners(clazzName, dataListener.getClass());
            }
        }

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        server.start();
    }

}
