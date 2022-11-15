package uci.tesis.carlostesis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Connector {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "connector_id")
    private Integer connectorId;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "charge_point_id")
    private Integer chargePointId;
    @GeneratedValue(strategy = GenerationType.AUTO)
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
