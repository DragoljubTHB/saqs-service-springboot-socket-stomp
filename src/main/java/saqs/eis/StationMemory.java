package saqs.eis;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

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
