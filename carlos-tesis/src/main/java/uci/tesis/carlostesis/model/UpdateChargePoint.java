package uci.tesis.carlostesis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateChargePoint {
    private Integer chargePointId;
    private String identity;
    private String centralSystemPath;
    private String description;
    private String chargeBoxVendor;
    private String iccid;
    private String imsi;
    private String meterType;
}
