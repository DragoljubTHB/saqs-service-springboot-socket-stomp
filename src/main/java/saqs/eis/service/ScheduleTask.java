package saqs.eis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import saqs.eis.model.Station;
import saqs.eis.persistence.StationMemory;
import saqs.eis.transfer.StationDTO;
import saqs.eis.websockets.Greeting;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

@Service
public class ScheduleTask implements Observer{

    public ScheduleTask(){
        StationMemory.getInstance().addObserver(this);
    }

    @Autowired
    private IStationService stationService;

    @Autowired
    private SimpMessagingTemplate template;

    // this will send a message to an endpoint on which a client can subscribe
    @Scheduled(fixedRate = 5000)
    public void trigger() {
        StationDTO stationDTO = new StationDTO();
        stationDTO.setName("name" +(new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
        stationDTO.setTarget((int) (Math.random()*100));
        stationDTO.setActual((int) (Math.random()*100));
        stationDTO.setDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        stationService.createStation(stationDTO);
        System.out.println("added");
        System.out.println(stationDTO);
        // template.convertAndSend("/topic/basestations", new Greeting("stations"));
    }

    @Override
    public void update(Observable observable, Object o) {
        System.out.println("update");
        template.convertAndSend("/topic/basestations", stationService.getAllStationsDTO());
    }
}
