package uci.tesis.carlostesis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateConnector {
    private Integer connectorId;
    private Integer chargePointStatus;
    private String info;
    private String vendorErrorCode;
}
