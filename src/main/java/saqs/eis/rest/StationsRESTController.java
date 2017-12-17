package saqs.eis.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import saqs.eis.model.Station;
import saqs.eis.persistence.StationMemory;
import saqs.eis.service.IStationService;

import java.util.List;

@Controller
@RequestMapping("/stations")
public class StationsRESTController {

    @Autowired
    private IStationService stationService;

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Station> getAllStations() {
        return stationService.findAll();
    }
}