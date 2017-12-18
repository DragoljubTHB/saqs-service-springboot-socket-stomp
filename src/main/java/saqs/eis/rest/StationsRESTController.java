package saqs.eis.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import saqs.eis.model.Station;
import saqs.eis.persistence.StationMemory;
import saqs.eis.service.IStationService;
import saqs.eis.transfer.StationDTO;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/stations")
public class StationsRESTController {

    @Autowired
    private IStationService stationService;

    @Autowired
    private ModelMapper modelMapper;

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<StationDTO> getAllStations() {

        List<Station> stations = stationService.findAll();
        return stations.stream()
                .map(this::convertToStationDTO)
                .collect(Collectors.toList());
    }

    private StationDTO convertToStationDTO(Station station) {
        StationDTO stationDTO = modelMapper.map(station, StationDTO.class);
        stationDTO.setVariance(stationDTO.getActual()-stationDTO.getTarget());
        stationDTO.setColour(
                calculateDangerFlag(stationDTO.getTarget(), stationDTO.getVariance()));
        return stationDTO;
    }

    private String calculateDangerFlag(Integer target, Integer variance) {
        String res = "none";
        if(variance>0 && Math.abs(variance)/target * 100 > 5) {//green
            res = "red";
        } else if (variance/target * 100 > 10) { // red
            res = "green";
        }
        return res;
    }
}