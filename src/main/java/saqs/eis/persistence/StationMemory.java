package saqs.eis.persistence;

import saqs.eis.model.Station;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class StationMemory {

    private ConcurrentHashMap<String, Station> stationsMap;

    private static StationMemory ourInstance = new StationMemory();

    public static StationMemory getInstance() {
        return ourInstance;
    }

    private StationMemory() {
        stationsMap = new ConcurrentHashMap<>();
        for (int i = 0; i < 5; i++) {
            Station s = new Station();
            s.setId("id_"+i);
            s.setName("name_"+i);
            s.setTarget((int) (1 + Math.random()*100));
            s.setActual((int) (1 + Math.random()*100));
            s.setDate(new SimpleDateFormat("dd/M/yyyy").format(new Date()));
            stationsMap.put(s.getId(), s);
        }
    }

    public Station put(Station newStation) {
        return stationsMap.putIfAbsent(newStation.getId(), newStation);
    }
    public List<Station> getAllStations() {
        return new ArrayList<>(stationsMap.values());
    }
}
