package saqs.eis.websockets;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class StationsWebSocketController {

    @MessageMapping("/basestations")
    @SendTo("/topic/basestations")
    public Greeting greeting(HelloMessage message) throws Exception {
        System.out.println("got message-> "+message);
        return new Greeting("hello");
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting2(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }


}
