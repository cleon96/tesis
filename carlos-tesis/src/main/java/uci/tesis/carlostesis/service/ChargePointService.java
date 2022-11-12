package uci.tesis.carlostesis.service;

import org.springframework.stereotype.Service;
import uci.tesis.carlostesis.entity.ChargePoint;
import uci.tesis.carlostesis.model.ChargePointModel;
import uci.tesis.carlostesis.model.FilterChargePoint;

import java.util.List;
import java.util.Optional;

@Service
public interface ChargePointService {
    ChargePoint CreateChargePoint(ChargePoint chargePoint);
    void DeleteChargePoint(Integer point);
    ChargePoint UpdateChargePoint(ChargePoint chargePoint);
    Optional<ChargePoint> getById(Integer id);
    List<ChargePoint> getByFilter(FilterChargePoint filterChargePoint);
    ChargePointModel getChargePoint(ChargePoint chargePoint);
    List<ChargePoint> chargePointList();
}
