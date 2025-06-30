package bus.reservation.Voyages.Services;

import bus.reservation.Voyages.Repository.ReservationRepository;
import bus.reservation.Voyages.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    //fonction pour recup tout les reservation
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    //fonction pour trouver une reservation par son Id
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    //fonction pour ajouter une reservation
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    //fonction pour mettre a jour une reservation
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    //fonction pour supprimer une reservation
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

}
