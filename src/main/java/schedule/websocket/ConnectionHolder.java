package schedule.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class ConnectionHolder {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private Map<Integer, WebSocketConnection> connections = Collections.synchronizedMap(new HashMap<>());

    public void add(Integer id, WebSocketConnection connection) {
        logger.error("add connection from user " + connection.getUser().getLogin());
        connections.put(id, connection);
    }

    public WebSocketConnection remove(Integer id) {
        WebSocketConnection connection = connections.remove(id);
        logger.error("add connection from user " + connection.getUser().getLogin());
        return connection;
    }
}
