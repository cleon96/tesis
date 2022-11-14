package uci.tesis.carlostesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uci.tesis.carlostesis.entity.ChargePoint;
import uci.tesis.carlostesis.entity.ChargingSession;
import uci.tesis.carlostesis.repository.ChargingSessionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ChargingSessionServiceImpl implements ChargingSessionService{
    @Autowired
    private ChargingSessionRepository repository;

    @Override
    public ChargingSession CreateReservation(ChargingSession chargingSession){
        return repository.save(chargingSession);
    }
    @Override
    public void DeleteChargingSession(Integer chargingSessionId){
        repository.deleteById(chargingSessionId);
    }
    @Override
    public Optional<ChargingSession> getById(Integer id){
        return repository.findById(id);
    }
    @Override
    public ChargingSession UpdateChargingSession(ChargingSession chargingSession){
        ChargingSession session = repository.findById(chargingSession.getChargingSessionId()).orElse(null);
        if (chargingSession.getTimeStampStart()!=null){
            session.setTimeStampStart(chargingSession.getTimeStampStart());
        }
        if (chargingSession.getMeterStart()!=null){
            session.setMeterStart(chargingSession.getMeterStart());
        }
        if (chargingSession.getTimeStampStop()!=null){
            session.setTimeStampStop(chargingSession.getTimeStampStop());
        }
        if (chargingSession.getMeterStop()!=null){
            session.setMeterStop(chargingSession.getMeterStop());
        }
        if (chargingSession.getDuration()!=null){
            session.setDuration(chargingSession.getDuration());
        }
        if (chargingSession.getCharged()!=null){
            session.setDuration(chargingSession.getDuration());
        }
        return repository.save(session);
    }
    @Override
    public List<ChargingSession> chargingSessionList(){
        List<ChargingSession> list = repository.findAll();
        return list;
    }
    @Override
    public void status(ChargingSession chargingSession){
        ChargingSession session = repository.findById(chargingSession.getChargingSessionId()).orElse(null);
        if (session.getStatus()==false) {
            session.setStatus(true);
        }
        else{
            session.setStatus(false);
        }
        repository.save(session);
    }
}
