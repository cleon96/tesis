package uci.tesis.carlostesis.service;

import org.springframework.stereotype.Service;
import uci.tesis.carlostesis.entity.ChargingSession;

import java.util.List;
import java.util.Optional;

@Service
public interface ChargingSessionService {
    ChargingSession CreateReservation(ChargingSession chargingSession);
    void DeleteChargingSession(Integer chargingSessionId);
    Optional<ChargingSession> getById(Integer id);
    ChargingSession UpdateChargingSession(ChargingSession chargingSession);
    List<ChargingSession> chargingSessionList();
    void status(ChargingSession chargingSession);
}
