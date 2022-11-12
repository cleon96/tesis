package uci.tesis.carlostesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uci.tesis.carlostesis.entity.ChargePoint;
import uci.tesis.carlostesis.model.ChargePointModel;
import uci.tesis.carlostesis.model.FilterChargePoint;
import uci.tesis.carlostesis.repository.ChargePointRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ChargePointServiceImpl implements ChargePointService {
    @Autowired
    private ChargePointRepository repository;

    @Override
    public ChargePoint CreateChargePoint(ChargePoint chargePoint) {
        return repository.save(chargePoint);
    }

    @Override
    public ChargePoint UpdateChargePoint(ChargePoint chargePoint) {
        ChargePoint point = repository.findById(chargePoint.getChargePointId()).orElse(null);
        if (chargePoint.getIdentity() != null) {
            point.setIdentity(chargePoint.getIdentity());
        }
        if (chargePoint.getCentralSystemPath() != null) {
            point.setCentralSystemPath(chargePoint.getCentralSystemPath());
        }
        if (chargePoint.getDescription() != null) {
            point.setDescription(chargePoint.getDescription());
        }
        if (chargePoint.getChargeBoxVendor() != null) {
            point.setChargeBoxVendor(chargePoint.getChargeBoxVendor());
        }
        if (chargePoint.getIccid() != null) {
            point.setIccid(chargePoint.getIccid());
        }
        if (chargePoint.getImsi() != null) {
            point.setImsi(chargePoint.getImsi());
        }
        if (chargePoint.getMeterType() != null) {
            point.setMeterType(chargePoint.getMeterType());
        }
        return repository.save(point);
    }

    @Override
    public void DeleteChargePoint(Integer point) {
        repository.deleteById(point);
    }

    @Override
    public Optional<ChargePoint> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<ChargePoint> getByFilter(FilterChargePoint filterChargePoint) {
        List<ChargePoint> chargePoints = repository.findAllByIdentityContainingAndCentralSystemPathContainingAndChargeBoxSerialNumberContainingAndChargePointModelContainingAndChargePointSerialNumberContainingAndMeterSerialNumberContainingAndMeterTypeContaining(
                filterChargePoint.getIdentity(), filterChargePoint.getCentralSystemPath(), filterChargePoint.getChargeBoxSerialNumber(), filterChargePoint.getChargePointModel(), filterChargePoint.getChargePointSerialNumber(), filterChargePoint.getMeterSerialNumber(),
                filterChargePoint.getMeterType()
        );
        return chargePoints;
    }

    @Override
    public ChargePointModel getChargePoint(ChargePoint chargePoint) {
        ChargePointModel model = ChargePointModel.builder()
                .statusRegistration(chargePoint.getStatusRegistration())
                .identity(chargePoint.getIdentity())
                .centralSystemPath(chargePoint.getCentralSystemPath())
                .description(chargePoint.getDescription())
                .lastHeartBeat(chargePoint.getLastHeartBeat())
                .chargeBoxSerialNumber(chargePoint.getChargeBoxSerialNumber())
                .chargePointModel(chargePoint.getChargePointModel())
                .chargePointSerialNumber(chargePoint.getChargePointSerialNumber())
                .chargeBoxVendor(chargePoint.getChargeBoxVendor())
                .firmwareVersion(chargePoint.getFirmwareVersion())
                .iccid(chargePoint.getIccid())
                .imsi(chargePoint.getImsi())
                .meterSerialNumber(chargePoint.getMeterSerialNumber())
                .meterType(chargePoint.getMeterType())
                .build();
        return model;
    }
        @Override
        public List<ChargePoint> chargePointList(){
            List<ChargePoint> list = repository.findAll();
            return list;

    }
}
