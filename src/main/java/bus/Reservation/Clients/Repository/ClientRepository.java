package bus.Reservation.Clients.Repository;

import bus.Reservation.Clients.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<bus.Reservation.Clients.Entities.Client, Integer> {
    @Override
    Optional<Client> findById(Integer integer);

}
