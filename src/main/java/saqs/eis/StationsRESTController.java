package saqs.eis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/stations")
public class StationsRESTController {

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Station> getAllStations() {
        List<Station> stations = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            Station s = new Station();
            s.setName("id_"+i);
            s.setName("name_"+i);
            s.setTarget(i);
            stations.add(s);
        }
        return stations;
    }
}
