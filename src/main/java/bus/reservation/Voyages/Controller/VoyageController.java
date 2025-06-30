package bus.reservation.Voyages.Controller;

import bus.reservation.Voyages.ReservationDto.VoyageDto;
import bus.reservation.Voyages.Services.VoyageService;
import bus.reservation.Voyages.entities.Voyage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/voyages")
public class VoyageController {

    @Autowired
    private VoyageService voyageService;

    @GetMapping
    public List<Voyage> getAllVoyages() {
        return voyageService.getAllVoyages();
    }

    @PostMapping("add")
    public ResponseEntity<String> addVoyage(@RequestBody VoyageDto  voyageDto) {
        try {
            Voyage voyage = convertToEntity(voyageDto);
            voyageService.addVoyage(voyage);
            return ResponseEntity.ok("voyage enregistrer aves success");
        }catch (Exception e) {
            return ResponseEntity.status(500).body("Erreur lor de l'enregistrement du voyage " +e.getMessage());
        }
    }

    public Voyage convertToEntity(VoyageDto voyageDto) {
        Voyage voyage = new Voyage();
        voyage.setPrix(voyageDto.getPrix());
        voyage.setPlaceDisponibles(voyageDto.getPlaceDisponibles());
        voyage.setHeureDepart(voyageDto.getHeureDepart());
        voyage.setDateDepart(voyageDto.getDateDepart());
        voyage.setVilleDepart(voyageDto.getVilleDepart());
        voyage.setVilleArrivee(voyageDto.getVilleArrivee());
        return  voyage;
    }

}
