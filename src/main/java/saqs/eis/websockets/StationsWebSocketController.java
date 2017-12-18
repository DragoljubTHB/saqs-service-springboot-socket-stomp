package saqs.eis.websockets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import saqs.eis.service.IStationService;
import saqs.eis.transfer.StationDTO;

import java.util.List;

@Controller
public class StationsWebSocketController {

    @Autowired
    private IStationService stationService;

    @MessageMapping("/basestations")
    @SendTo("/topic/basestations")
    public List<StationDTO> greeting(HelloMessage message) throws Exception {
        return stationService.getAllStationsDTO();
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting2(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }


}
