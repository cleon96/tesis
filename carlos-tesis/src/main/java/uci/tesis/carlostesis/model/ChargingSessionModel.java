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
public class ChargingSessionModel {
    private Date timeStampStart;
    private Integer meterStart;
    private Date timeStampStop;
    private Integer meterStop;
    private Integer duration;
    private Double charged;
}
