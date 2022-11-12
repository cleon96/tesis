package uci.tesis.carlostesis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uci.tesis.carlostesis.entity.Connector;
import uci.tesis.carlostesis.entity.Reservation;
import uci.tesis.carlostesis.model.UpdateConnector;
import uci.tesis.carlostesis.model.UpdateReservation;
import uci.tesis.carlostesis.service.ReservationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @PostMapping("/create")
    public ResponseEntity<Reservation> CreateConnector(@RequestBody Reservation reservation){
        Reservation reserv = reservationService.CreateReservation(reservation);
        return ResponseEntity.ok(reserv);
    }
    @DeleteMapping("/delete")
    public String UpdateChargePoint(Integer reservationId){
        reservationService.DeleteReservation(reservationId);
        return "Se ha Eliminado correctamente";
    }
    @PutMapping("/update")
    public ResponseEntity<Reservation> UpdateConnector(@RequestBody UpdateReservation updateReservation){
        Reservation reservation = Reservation.builder()
                .reservationId(updateReservation.getReservationId())
                .reservationStatus(updateReservation.getReservationStatus())
                .expiryDate(updateReservation.getExpiryDate())
                .build();
        return ResponseEntity.ok(reservationService.UpdateReservation(reservation));
    }
    @GetMapping("/getById")
    public ResponseEntity<Optional<Reservation>> getById(@RequestParam Integer id){
        Optional<Reservation> reservation = reservationService.getById(id);
        if ( reservation.isEmpty()){
            return (ResponseEntity<Optional<Reservation>>) ResponseEntity.noContent();
        }
        return ResponseEntity.ok(reservation);
    }
    @GetMapping("/getList")
    public ResponseEntity<List<Reservation>> reservationList(){
        List<Reservation> list = reservationService.reservationList();
        return ResponseEntity.ok(list);
    }
}
