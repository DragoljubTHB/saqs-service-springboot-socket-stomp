package saqs.eis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import saqs.eis.websockets.Greeting;

import java.util.Date;

@Service
public class ScheduleTask {

    @Autowired
    private SimpMessagingTemplate template;

    // this will send a message to an endpoint on which a client can subscribe
    @Scheduled(fixedRate = 5000)
    public void trigger() {
        template.convertAndSend("/eis", new Greeting("hello there"));
        template.convertAndSend("/basestations", new Greeting("hello there"));
        template.convertAndSend("/topic/greetings", new Greeting("hello there"));
    }

}
