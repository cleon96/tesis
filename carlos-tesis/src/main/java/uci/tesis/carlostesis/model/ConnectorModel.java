package uci.tesis.carlostesis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConnectorModel {
    private Integer chargePointId;
    private Integer availabilityTypeId;
    private Integer chargePointStatus;
    private Integer chargePointErrorCodeId;
    private Date changeStatus;
    private String info;
    private String vendorId;
    private String vendorErrorCode;
}
