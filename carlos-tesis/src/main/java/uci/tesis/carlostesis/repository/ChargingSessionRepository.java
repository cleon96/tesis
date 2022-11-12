package uci.tesis.carlostesis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uci.tesis.carlostesis.entity.ChargingSession;

@Repository
public interface ChargingSessionRepository extends JpaRepository<ChargingSession,Integer> {
}
