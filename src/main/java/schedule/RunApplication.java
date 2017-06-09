package schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import org.springframework.web.socket.server.standard.ServerEndpointRegistration;
import schedule.websocket.WebSocketConnection;

@SpringBootApplication
public class RunApplication {
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }

    @Bean
    public ServerEndpointRegistration serverEndpointRegistration(){
        return new ServerEndpointRegistration("/bla", WebSocketConnection.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(RunApplication.class, args);
    }
}
