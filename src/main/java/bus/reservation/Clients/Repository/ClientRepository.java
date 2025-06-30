package bus.reservation.Clients.Repository;

import bus.reservation.Clients.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<bus.reservation.Clients.Entities.Client, Integer> {
    @Override
    Optional<Client> findById(Integer id);

}
