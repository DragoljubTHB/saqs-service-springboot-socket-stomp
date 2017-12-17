package saqs.eis;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class StationsWebSocketController {

    @MessageMapping("/stations")
    @SendTo("/basestations")
    public String greeting(String message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return "hello!";
    }

}
