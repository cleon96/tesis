package uci.tesis.carlostesis.service;

import org.springframework.stereotype.Service;
import uci.tesis.carlostesis.entity.Reservation;

import java.util.List;
import java.util.Optional;

@Service
public interface ReservationService {
    Reservation CreateReservation(Reservation reservation);
    void DeleteReservation(Integer reservationId);
    Optional<Reservation> getById(Integer id);
    Reservation UpdateReservation(Reservation connector);
    List<Reservation> reservationList();
}
