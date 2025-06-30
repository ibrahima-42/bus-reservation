package bus.reservation.Voyages.Services;

import bus.reservation.Voyages.Repository.VoyageRepository;
import bus.reservation.Voyages.entities.Voyage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoyageService {
    @Autowired
    private VoyageRepository voyageRepository;

    //fonction pour afficher tous les voyages
    public List<Voyage> getAllVoyages() {
        return voyageRepository.findAll();
    }

    //fonction pour cree un voyage
    public Voyage addVoyage(Voyage voyage) {
        return voyageRepository.save(voyage);
    }

    //fonction pour supprimer un voyage
    public void deleteVoyage(Integer id) {
        voyageRepository.deleteById(id);
    }

    //fonction pour mettre a jour un message
    public void updateVoyage(Voyage voyage) {
        voyageRepository.save(voyage);
    }
}
