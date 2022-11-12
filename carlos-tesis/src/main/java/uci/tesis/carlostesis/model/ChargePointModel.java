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
public class ChargePointModel {
    private Integer statusRegistration;
    private String identity;
    private String centralSystemPath;
    private String description;
    private Date lastHeartBeat;
    private String chargeBoxSerialNumber;
    private String chargePointModel;
    private String chargePointSerialNumber;
    private String chargeBoxVendor;
    private String firmwareVersion;
    private String iccid;
    private String imsi;
    private String meterSerialNumber;
    private String meterType;
}
