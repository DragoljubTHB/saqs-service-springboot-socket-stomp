package saqs.eis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/stations")
public class StationsRESTController {

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Station> getAllStations() {
        return StationMemory.getInstance().getAllStations();
    }
}