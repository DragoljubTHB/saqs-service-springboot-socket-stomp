package saqs.eis.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saqs.eis.model.Station;
import saqs.eis.persistence.StationMemory;
import saqs.eis.repository.IStationRepository;
import saqs.eis.transfer.StationDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StationService implements IStationService {

    @Autowired
    private IStationRepository stationRepository;

    @Autowired
    private ModelMapper modelMapper;

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

    public List<StationDTO> getAllStationsDTO() {

        List<Station> stations = findAll();
        return stations.stream()
                .map(this::convertToStationDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void createStation(StationDTO stationDTO) {
        Station station = modelMapper.map(stationDTO, Station.class);
        stationRepository.createStation(station);
    }

    @Override
    public List<Station> findAll() {
        return stationRepository.findAll();
    }
}
