package uci.tesis.carlostesis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uci.tesis.carlostesis.entity.ChargePoint;

import java.util.List;

@Repository
public interface ChargePointRepository extends JpaRepository<ChargePoint,Integer> {
    List<ChargePoint> findAllByIdentityContainingAndCentralSystemPathContainingAndChargeBoxSerialNumberContainingAndChargePointModelContainingAndChargePointSerialNumberContainingAndMeterSerialNumberContainingAndMeterTypeContaining(
            String identity,String centralSystemPath,String chargeBoxSerialNumber,String chargePointModel,String chargePointSerialNumber,String meterSerialNumber,String meterType
    );
}
