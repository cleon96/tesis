package uci.tesis.carlostesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uci.tesis.carlostesis.entity.Connector;
import uci.tesis.carlostesis.entity.Reservation;
import uci.tesis.carlostesis.repository.ReservationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService{
    @Autowired
    private ReservationRepository repository;

    @Override
    public Reservation CreateReservation(Reservation reservation){
        return repository.save(reservation);
    }
    @Override
    public void DeleteReservation(Integer reservationId){
        repository.deleteById(reservationId);
    }
    @Override
    public Optional<Reservation> getById(Integer id){
        return repository.findById(id);
    }
    @Override
    public Reservation UpdateReservation(Reservation reservation){
        Reservation reserv = repository.findById(reservation.getReservationId()).orElse(null);
        if (reservation.getReservationStatus()!=null){
            reserv.setReservationStatus(reservation.getReservationStatus());
        }
        if (reservation.getExpiryDate()!=null){
            reserv.setExpiryDate(reservation.getExpiryDate());
        }
        return repository.save(reserv);
    }
    @Override
    public List<Reservation> reservationList(){
        List<Reservation> list = repository.findAll();
        return list;

    }
}
