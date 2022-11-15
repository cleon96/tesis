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
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reservation_id")
    private Integer reservationId;
    @Column(name = "charge_point_id")
    private Integer chargePointId;
    @Column(name = "connector_id")
    private Integer connectorId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "reservation_status")
    private Integer reservationStatus;
    @Column(name = "expiry_date")
    private Date expiryDate;
}
