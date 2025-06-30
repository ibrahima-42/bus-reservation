package bus.reservation.Voyages.Controller;

import bus.reservation.Clients.Entities.Client;
import bus.reservation.Clients.Repository.ClientRepository;
import bus.reservation.Voyages.Repository.VoyageRepository;
import bus.reservation.Voyages.ReservationDto.ReservationDto;
import bus.reservation.Voyages.Services.ReservationService;
import bus.reservation.Voyages.entities.Reservation;
import bus.reservation.Voyages.entities.Voyage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private VoyageRepository voyageRepository;

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @PostMapping("add")
    public ResponseEntity<String> addReservation(@RequestBody ReservationDto reservationDto) {
        try {
            Reservation reservation = converToEntity(reservationDto);
            reservationService.addReservation(reservation);
            return ResponseEntity.ok("Reservation ajouter avec success");
        }catch (Exception e){
            return ResponseEntity.status(500).body("Erreur lor de l'enregistrement du reservation"+e.getMessage());
        }
    }

    //fonction pour supprimer une reservation
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable Long id){
        try {
            Reservation reservation = reservationService.getReservationById(id)
                    .orElseThrow(() -> new RuntimeException("reservation not found"));
            reservationService.deleteReservation(id);
            return ResponseEntity.ok("Reservation supprimer avec success");
        }catch (Exception e) {
            return  ResponseEntity.status(500).body("Erreur lors de l'enregistrement du reservation");
        }
    }

    //fonction pour convertir le dto en entite
    public Reservation converToEntity(ReservationDto dto) {
        Reservation reservation = new Reservation();
        reservation.setId(dto.getId());
        reservation.setDateReservation(dto.getDateReservation());
        reservation.setNombrePlaces(dto.getNombrePlaces());

        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        clientRepository.save(client);
        reservation.setClient(client);

        Voyage voyage = voyageRepository.findById(dto.getVoyageId())
                .orElseThrow(() -> new RuntimeException("Voyage not found"));

        voyageRepository.save(voyage);
        reservation.setVoyage(voyage);

        return reservation;
    }
}
