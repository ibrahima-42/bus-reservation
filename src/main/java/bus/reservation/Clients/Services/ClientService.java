package bus.reservation.Clients.Services;

import bus.reservation.Clients.Entities.Client;
import bus.reservation.Clients.Repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    //fonction pour ajouter client
    public Client addClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    //fonction pour mettre a jour un client
    public Client updateClient(@RequestBody Client client) {
        Optional<Client> existingClient = clientRepository.findById(client.getId());

        if (existingClient.isPresent()){
            Client updatedClient = existingClient.get();
            updatedClient.setNom(client.getNom());
            updatedClient.setPrenom(client.getPrenom());
            updatedClient.setEmail(client.getEmail());
            updatedClient.setTelephone(client.getTelephone());
            return clientRepository.save(updatedClient);
        }
        else {
            throw new EntityNotFoundException("Client not found"+client.getId());
        }
    }


    public Optional<Client> getClientById(Integer id) {
        return clientRepository.findById(id);
    }

    //fonction filter client by Id
    public void deleteClientById(Integer id) {
        clientRepository.deleteById(id);
    }
}
