package uci.tesis.carlostesis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChargingSession {
    @Id
    private Integer chargingSessionId;
    private Integer transactionId;
    private Integer userId;
    private Integer chargePointId;
    private Integer connectorId;
    private Integer reasonsId;
    private Date timeStampStart;
    private Integer meterStart;
    private Date timeStampStop;
    private Integer meterStop;
    private Integer duration;
    private Double charged;
    private Integer reservationId;
    private Boolean status;
}
