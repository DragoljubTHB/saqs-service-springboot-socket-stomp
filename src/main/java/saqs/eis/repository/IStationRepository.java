package saqs.eis.repository;

import saqs.eis.model.Station;

import java.util.List;

public interface IStationRepository {
    List<Station> findAll();
}
