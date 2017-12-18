package saqs.eis.service;

import saqs.eis.model.Station;
import saqs.eis.transfer.StationDTO;

import java.util.List;

public interface IStationService {
    List<Station> findAll();

    List<StationDTO> getAllStationsDTO();
}
