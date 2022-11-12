package uci.tesis.carlostesis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uci.tesis.carlostesis.entity.ChargePoint;
import uci.tesis.carlostesis.model.ChargePointModel;
import uci.tesis.carlostesis.model.FilterChargePoint;
import uci.tesis.carlostesis.model.UpdateChargePoint;
import uci.tesis.carlostesis.service.ChargePointService;

import java.util.*;

@RestController
@RequestMapping("/chargePoint")
public class ChargePointController {
    private final ChargePointService service;

    public ChargePointController(ChargePointService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<ChargePoint> CreateChargePoint(@RequestBody ChargePoint chargePoint) {
        ChargePoint point = service.CreateChargePoint(chargePoint);
        return ResponseEntity.ok(point);
    }

    @PutMapping("/update")
    public ResponseEntity<ChargePoint> UpdateChargePoint(@RequestBody UpdateChargePoint updateChargePoint) {
        ChargePoint point = ChargePoint.builder()
                .chargePointId(updateChargePoint.getChargePointId())
                .identity(updateChargePoint.getIdentity())
                .centralSystemPath(updateChargePoint.getCentralSystemPath())
                .description(updateChargePoint.getDescription())
                .chargeBoxVendor(updateChargePoint.getChargeBoxVendor())
                .iccid(updateChargePoint.getIccid())
                .imsi(updateChargePoint.getImsi())
                .meterType(updateChargePoint.getMeterType())
                .build();
        return ResponseEntity.ok(service.UpdateChargePoint(point));
    }

    @DeleteMapping("/delete")
    public String UpdateChargePoint(Integer chargePointId) {
        service.DeleteChargePoint(chargePointId);
        return "Se ha Eliminado correctamente";
    }

    @GetMapping("/getById")
    public ResponseEntity<Optional<ChargePoint>> getById(@RequestParam Integer id) {
        Optional<ChargePoint> point = service.getById(id);
        if (point.isEmpty()) {
            return (ResponseEntity<Optional<ChargePoint>>) ResponseEntity.noContent();
        }
        return ResponseEntity.ok(point);
    }

    @GetMapping("/getByFilter")
    public ResponseEntity<Map<String, List<ChargePointModel>>> getByFilter(@RequestParam(required = false) String identity,
                                                                           @RequestParam(required = false) String centralSystemPath,
                                                                           @RequestParam(required = false) String chargeBoxSerialNumber,
                                                                           @RequestParam(required = false) String chargePointModel,
                                                                           @RequestParam(required = false) String chargePointSerialNumber,
                                                                           @RequestParam(required = false) String meterSerialNumber,
                                                                           @RequestParam(required = false) String meterType) {
        Map<String, List<ChargePointModel>> result = new HashMap<>();

        FilterChargePoint filterChargePoint = FilterChargePoint.builder()
                .identity(identity == null ? "" : identity)
                .centralSystemPath(centralSystemPath == null ? "" : centralSystemPath)
                .chargeBoxSerialNumber(chargeBoxSerialNumber == null ? "" : chargeBoxSerialNumber)
                .chargePointModel(chargePointModel == null ? "" : chargePointModel)
                .chargePointSerialNumber(chargePointSerialNumber == null ? "" : chargePointSerialNumber)
                .meterSerialNumber(meterSerialNumber == null ? "" : meterSerialNumber)
                .meterType(meterType == null ? "" : meterType)
                .build();
        List<ChargePoint> chargePoints = service.getByFilter(filterChargePoint);
        System.out.println("---->>>>>" + chargePoints);
        if (chargePoints.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<ChargePointModel> modelList = new ArrayList<>();
        for (ChargePoint point : chargePoints) {
            modelList.add(service.getChargePoint(point));
        }
        result.put("chargePoint", modelList);

        return ResponseEntity.ok(result);
    }
    @GetMapping("/getList")
    public ResponseEntity<List<ChargePoint>> chargePointList(){
        List<ChargePoint> list = service.chargePointList();
        return ResponseEntity.ok(list);
    }
}
