package saqs.eis.websockets;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class StationsWebSocketController {

    @MessageMapping("/basestations")
    @SendTo("/basestations")
    public String greeting() throws Exception {
        System.out.println("got message-> ");
        return "hello!";
    }

}
