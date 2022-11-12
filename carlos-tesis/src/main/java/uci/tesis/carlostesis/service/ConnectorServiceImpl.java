package uci.tesis.carlostesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uci.tesis.carlostesis.entity.ChargePoint;
import uci.tesis.carlostesis.entity.ChargingSession;
import uci.tesis.carlostesis.entity.Connector;

import uci.tesis.carlostesis.model.ChargePointModel;
import uci.tesis.carlostesis.model.ConnectorModel;
import uci.tesis.carlostesis.model.FilterChargePoint;
import uci.tesis.carlostesis.model.FilterConnector;
import uci.tesis.carlostesis.repository.ConnectorRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ConnectorServiceImpl implements ConnectorService {
    @Autowired
    private ConnectorRepository repository;

    @Override
    public Connector CreateConnector(Connector connector) {
        return repository.save(connector);
    }

    @Override
    public Connector UpdateConnector(Connector connector) {
        Connector conn = repository.findById(connector.getConnectorId()).orElse(null);
        if (connector.getChargePointStatus() != null) {
            conn.setChargePointStatus(connector.getChargePointStatus());
        }
        if (connector.getInfo() != null) {
            conn.setInfo(connector.getInfo());
        }
        if (connector.getVendorErrorCode() != null) {
            conn.setVendorErrorCode(connector.getVendorErrorCode());
        }
        return repository.save(conn);
    }

    @Override
    public void DeleteConnector(Integer connectorId) {
        repository.deleteById(connectorId);
    }

    @Override
    public Optional<Connector> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Connector> getByFilter(FilterConnector filterConnector) {
        List<Connector> connectors = repository.findAllByInfoContainingAndVendorIdContainingAndVendorErrorCodeContaining(
                filterConnector.getInfo(), filterConnector.getVendorId(), filterConnector.getVendorErrorCode()
        );
        return connectors;
    }

    @Override
    public ConnectorModel getConnector(Connector connector) {
        ConnectorModel model = ConnectorModel.builder()
                .chargePointId(connector.getChargePointId())
                .availabilityTypeId(connector.getAvailabilityTypeId())
                .chargePointStatus(connector.getChargePointStatus())
                .chargePointErrorCodeId(connector.getChargePointErrorCodeId())
                .changeStatus(connector.getChangeStatus())
                .info(connector.getInfo())
                .vendorId(connector.getVendorId())
                .vendorErrorCode(connector.getVendorErrorCode())
                .build();

        return model;
    }
    @Override
    public List<Connector> connectorList(){
        List<Connector> list = repository.findAll();
        return list;

    }
}
