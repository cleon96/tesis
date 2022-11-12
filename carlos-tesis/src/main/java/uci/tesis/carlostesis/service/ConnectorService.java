package uci.tesis.carlostesis.service;

import uci.tesis.carlostesis.entity.Connector;
import uci.tesis.carlostesis.model.ConnectorModel;
import uci.tesis.carlostesis.model.FilterConnector;

import java.util.List;
import java.util.Optional;

public interface ConnectorService {
    Connector CreateConnector(Connector connector);
    void DeleteConnector(Integer connectorId);
    Connector UpdateConnector(Connector connector);
    Optional<Connector> getById(Integer id);
    List<Connector> getByFilter(FilterConnector filterConnector);
    ConnectorModel getConnector(Connector connector);
    List<Connector> connectorList();
}
