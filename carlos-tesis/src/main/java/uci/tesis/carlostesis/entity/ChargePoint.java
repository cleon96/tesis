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
public class ChargePoint {
    @Id
    @Column(name = "charge_point_id")
    private Integer chargePointId;
    @Column(name = "status_registration")
    private Integer statusRegistration;
    private String identity;
    @Column(name = "central_system_path")
    private String centralSystemPath;
    private String description;
    @Column(name = "last_heart_beat")
    private Date lastHeartBeat;
    @Column(name = "charge_box_seral_number")
    private String chargeBoxSerialNumber;
    @Column(name = "charge_point_model")
    private String chargePointModel;
    @Column(name = "charge_point_serial_number")
    private String chargePointSerialNumber;
    @Column(name = "charge_box_vendor")
    private String chargeBoxVendor;
    @Column(name = "firmware_version")
    private String firmwareVersion;
    private String iccid;
    private String imsi;
    @Column(name = "meter_serial_number")
    private String meterSerialNumber;
    @Column(name = "meter_type")
    private String meterType;

}
