package bus.Reservation.Clients.Services;

import bus.Reservation.Clients.Entities.Client;
import bus.Reservation.Clients.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class initClient implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("#####initClient");
        System.out.println("#########Starting init Client ........");

        Client client = new Client();
        client.setNom("Diagne");
        client.setPrenom("Khalil");
        client.setEmail("diagne112@icloud.com");
        client.setTelephone("+221 771566814");
        clientRepository.save(client);
    }
}
