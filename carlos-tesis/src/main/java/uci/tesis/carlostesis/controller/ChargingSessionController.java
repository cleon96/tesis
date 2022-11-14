package uci.tesis.carlostesis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uci.tesis.carlostesis.entity.ChargingSession;
import uci.tesis.carlostesis.model.UpdateChargingSession;
import uci.tesis.carlostesis.model.UpdateStatus;
import uci.tesis.carlostesis.service.ChargingSessionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chargingSessions")
public class ChargingSessionController {
    private final ChargingSessionService chargingSessionService;

    public ChargingSessionController(ChargingSessionService chargingSessionService) {
        this.chargingSessionService = chargingSessionService;
    }

    @PostMapping("/create")
    public ResponseEntity<ChargingSession> CreateChargingSession(@RequestBody ChargingSession chargingSession) {
        ChargingSession session = chargingSessionService.CreateReservation(chargingSession);
        return ResponseEntity.ok(session);
    }

    @DeleteMapping("/delete")
    public String UpdateChargePoint(Integer chargingSessionId) {
        chargingSessionService.DeleteChargingSession(chargingSessionId);
        return "Se ha Eliminado correctamente";
    }

    @PutMapping("/update")
    public ResponseEntity<ChargingSession> UpdateChargingSession(@RequestBody UpdateChargingSession updateChargingSession) {
        ChargingSession session = ChargingSession.builder()
                .chargingSessionId(updateChargingSession.getChargingSessionId())
                .timeStampStart(updateChargingSession.getTimeStampStart())
                .meterStart(updateChargingSession.getMeterStart())
                .timeStampStop(updateChargingSession.getTimeStampStop())
                .meterStop(updateChargingSession.getMeterStop())
                .duration(updateChargingSession.getDuration())
                .charged(updateChargingSession.getCharged())
                .build();
        return ResponseEntity.ok(chargingSessionService.UpdateChargingSession(session));
    }

    @GetMapping("/getById")
    public ResponseEntity<Optional<ChargingSession>> getById(@RequestParam Integer id) {
        Optional<ChargingSession> chargingSession = chargingSessionService.getById(id);
        if (chargingSession.isEmpty()) {
            return (ResponseEntity<Optional<ChargingSession>>) ResponseEntity.noContent();
        }
        return ResponseEntity.ok(chargingSession);
    }

    @GetMapping("/getList")
    public ResponseEntity<List<ChargingSession>> chargeSession() {
        List<ChargingSession> list = chargingSessionService.chargingSessionList();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/status")
    public void Status(@RequestBody UpdateStatus updateStatus) {
        ChargingSession session = ChargingSession.builder()
                .chargingSessionId(updateStatus.getChargingSessionId())
                .build();
        chargingSessionService.status(session);
    }
}