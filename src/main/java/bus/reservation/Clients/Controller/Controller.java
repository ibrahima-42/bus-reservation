package bus.reservation.Clients.Controller;


import bus.reservation.Clients.Dto.ClientDto;
import bus.reservation.Clients.Entities.Client;
import bus.reservation.Clients.Repository.ClientRepository;
import bus.reservation.Clients.Services.ClientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/client")
public class Controller {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<ClientDto> getAllClients() {
        return clientService.getAllClients().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @PostMapping("add")
    public ClientDto addClient(@RequestBody ClientDto dto) {
        Client client = convertToEntity(dto);
        Client saved = clientService.addClient(client);
        return convertToDto(saved);
    }

    @PutMapping("update")
    public ClientDto updateClient(@RequestBody ClientDto dto) {
        try {
            Client client = convertToEntity(dto);
            Client update = clientService.updateClient(client);
            return convertToDto(update);
        }catch (Exception e) {
            e.printStackTrace(); //pour afficher lerreur dans la console
            throw  e; //retourner une reponse personnalier
        }

    }

    //fonction pour supprimer un client
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteClientById(@PathVariable Integer id) {
        Client client = clientService.getClientById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client introuvable avec l'id " + id));

        //supprimer le client
        clientService.deleteClientById(id);
        return ResponseEntity.ok("Client with id:"+ id + " is deleted with sucesss.");
    }


    //convertir en entite
    private Client convertToEntity(ClientDto dto) {
        Client client = new Client();
        client.setId(dto.getId());
        client.setNom(dto.getNom());
        client.setPrenom(dto.getPrenom());
        client.setEmail(dto.getEmail());
        client.setTelephone(dto.getTelephone());
        return client;
    }

    //convertir lentite en dto
    private ClientDto convertToDto(Client client) {
        ClientDto dto = new ClientDto();
        dto.setId(client.getId());
        dto.setNom(client.getNom());
        dto.setPrenom(client.getPrenom());
        dto.setEmail(client.getEmail());
        dto.setTelephone(client.getTelephone());
        return dto;
    }
}
