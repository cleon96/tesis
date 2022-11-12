package uci.tesis.carlostesis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uci.tesis.carlostesis.entity.ChargingSession;
import uci.tesis.carlostesis.entity.Connector;
import uci.tesis.carlostesis.model.*;
import uci.tesis.carlostesis.service.ConnectorService;

import java.util.*;

@RestController
@RequestMapping("/connectors")
public class ConnectorController {
    private final ConnectorService service;

    public ConnectorController(ConnectorService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Connector> CreateConnector(@RequestBody Connector connector) {
        Connector conn = service.CreateConnector(connector);
        return ResponseEntity.ok(conn);
    }

    @PutMapping("/update")
    public ResponseEntity<Connector> UpdateConnector(@RequestBody UpdateConnector updateConnector) {
        Connector connector = Connector.builder()
                .connectorId(updateConnector.getConnectorId())
                .chargePointStatus(updateConnector.getChargePointStatus())
                .info(updateConnector.getInfo())
                .vendorErrorCode(updateConnector.getVendorErrorCode())
                .build();

        return ResponseEntity.ok(service.UpdateConnector(connector));
    }

    @DeleteMapping("/delete")
    public String UpdateChargePoint(Integer connectorId) {
        service.DeleteConnector(connectorId);
        return "Se ha Eliminado correctamente";
    }

    @GetMapping("/getById")
    public ResponseEntity<Optional<Connector>> getById(@RequestParam Integer id) {
        Optional<Connector> connector = service.getById(id);
        if (connector.isEmpty()) {
            return (ResponseEntity<Optional<Connector>>) ResponseEntity.noContent();
        }
        return ResponseEntity.ok(connector);
    }

    @GetMapping("/getByFilter")
    public ResponseEntity<Map<String, List<ConnectorModel>>> getByFilter(@RequestParam(required = false) String info,
                                                                         @RequestParam(required = false) String vendorId,
                                                                         @RequestParam(required = false) String vendorErrorCode) {
        Map<String, List<ConnectorModel>> result = new HashMap<>();

        FilterConnector filterConnector = FilterConnector.builder()
                .info(info == null ? "" : info)
                .vendorId(vendorId == null ? "" : vendorId)
                .vendorErrorCode(vendorErrorCode == null ? "" : vendorErrorCode)
                .build();
        List<Connector> connectors = service.getByFilter(filterConnector);

        if (connectors.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<ConnectorModel> modelList = new ArrayList<>();
        for (Connector connect : connectors) {
            modelList.add(service.getConnector(connect));
        }
        result.put("connectors", modelList);

        return ResponseEntity.ok(result);
    }
    @GetMapping("/getList")
    public ResponseEntity<List<Connector>> connectorList(){
        List<Connector> list = service.connectorList();
        return ResponseEntity.ok(list);
    }

}
