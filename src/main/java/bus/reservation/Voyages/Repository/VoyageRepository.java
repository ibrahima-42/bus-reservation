package bus.reservation.Voyages.Repository;

import bus.reservation.Voyages.entities.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoyageRepository extends JpaRepository<Voyage, Long> {
    List<Voyage> findByVilleArrivee(String villeArrivee);
    List<Voyage> findByVilleDepart(String villeDepart);
}
