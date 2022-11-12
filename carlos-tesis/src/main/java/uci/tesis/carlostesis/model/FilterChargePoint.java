package uci.tesis.carlostesis.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FilterChargePoint {
    private String identity;
    private String centralSystemPath;
    private String chargeBoxSerialNumber;
    private String chargePointModel;
    private String chargePointSerialNumber;
    private String meterSerialNumber;
    private String meterType;
}
