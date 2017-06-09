package schedule.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import schedule.entity.User;
import schedule.service.UserService;

import javax.websocket.*;
import java.io.IOException;
import java.util.List;

public class WebSocketConnection extends Endpoint implements MessageHandler.Whole<String> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ConnectionHolder holder;

    @Autowired
    private UserService userService;

    private List<NewChange> changes;

    private Session session;

    private User user;

    @Override
    public void onOpen(Session session, EndpointConfig config) {
        session.addMessageHandler(this);

        this.session = session;
        logger.error("OPEN");
    }

    @Override
    public void onClose(Session session, CloseReason closeReason) {
        holder.remove(user.getId());
    }

    @Override
    public void onMessage(String message) {
        Integer id = Integer.parseInt(message);
        System.out.println(changes.size());
        //что-то сотворила
        logger.error(message);
        user = userService.findOne(id);
        try {
            session.getBasicRemote().sendText("text");
        } catch (IOException e) {
            e.printStackTrace();
        }
        holder.add(id, this);
    }

    public Session getSession() {
        return session;
    }

    public User getUser() {
        return user;
    }
}
