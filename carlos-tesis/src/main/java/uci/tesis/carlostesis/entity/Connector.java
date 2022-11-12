package uci.tesis.carlostesis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Connector {
    @Id
    @Column(name = "connector_id")
    private Integer connectorId;
    @Column(name = "charge_point_id")
    private Integer chargePointId;
    @Column(name = "availability_type_id")
    private Integer availabilityTypeId;
    @Column(name = "charge_point_status")
    private Integer chargePointStatus;
    @Column(name = "charge_point_error_code_id")
    private Integer chargePointErrorCodeId;
    @Column(name = "change_status")
    private Date changeStatus;
    private String info;
    @Column(name = "vendor_id")
    private String vendorId;
    @Column(name = "vendor_error_code")
    private String vendorErrorCode;

}
