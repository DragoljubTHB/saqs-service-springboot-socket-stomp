package saqs.eis.repository;

import org.springframework.stereotype.Repository;
import saqs.eis.model.Station;
import saqs.eis.persistence.StationMemory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class StationRepository implements IStationRepository{
    @Override
    public List<Station> findAll() {
        return StationMemory.getInstance().getAllStations();
    }

    @Override
    public void createStation(Station station) {
        station.setId(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
        StationMemory.getInstance().put(station);
    }
}
