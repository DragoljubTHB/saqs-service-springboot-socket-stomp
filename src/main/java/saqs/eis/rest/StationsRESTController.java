package saqs.eis.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import saqs.eis.model.Station;
import saqs.eis.service.IStationService;
import saqs.eis.transfer.StationDTO;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/stations")
public class StationsRESTController {

    @Autowired
    private IStationService stationService;


    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<StationDTO> getAllStations() {
        return stationService.getAllStationsDTO();
    }


}