package saqs.eis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saqs.eis.model.Station;
import saqs.eis.persistence.StationMemory;
import saqs.eis.repository.IStationRepository;

import java.util.List;

@Service
public class StationService implements IStationService {

    @Autowired
    private IStationRepository stationRepository;

    @Override
    public List<Station> findAll() {
        return stationRepository.findAll();
    }
}
