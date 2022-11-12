package uci.tesis.carlostesis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uci.tesis.carlostesis.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
}
