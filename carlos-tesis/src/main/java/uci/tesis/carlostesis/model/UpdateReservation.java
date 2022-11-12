package uci.tesis.carlostesis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReservation {
    private Integer reservationId;
    private Integer reservationStatus;
    private Date expiryDate;
}
