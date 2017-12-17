package saqs.eis.service;

import org.springframework.stereotype.Service;
import saqs.eis.model.Station;
import saqs.eis.persistence.StationMemory;

import java.util.List;

@Service
public class StationService implements IStationService {

    @Override
    public List<Station> findAll() {
        return StationMemory.getInstance().getAllStations();
    }
}
