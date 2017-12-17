package saqs.eis.service;

import saqs.eis.model.Station;

import java.util.List;

public interface IStationService {
    List<Station> findAll();
}
