package bus.reservation.Voyages.Services;


import bus.reservation.Clients.Entities.Client;
import bus.reservation.Clients.Repository.ClientRepository;
import bus.reservation.Voyages.Repository.ReservationRepository;
import bus.reservation.Voyages.Repository.VoyageRepository;
import bus.reservation.Voyages.entities.Reservation;
import bus.reservation.Voyages.entities.Voyage;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Transactional
@Component
public class initVoyage implements CommandLineRunner {

    @Autowired
    private VoyageRepository voyageRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public void run(String... args) throws Exception {
        System.out.println("#######initVoyage");
        System.out.println("#######Starting des voyage ..............");

        //init voyage
        Voyage voyage1 = new Voyage();
        voyage1.setVilleDepart("Saint-louis");
        voyage1.setVilleArrivee("Dakar");
        voyage1.setCompagny("Mashalla-Transport");
        voyage1.setDateDepart(LocalDate.now());
        voyage1.setHeureDepart(LocalTime.now());
        voyage1.setPrix(6000);
        voyage1.setPlaceDisponibles(15);
        voyageRepository.save(voyage1);

        Voyage voyage2 = new Voyage();
        voyage2.setVilleDepart("Dakar");
        voyage2.setVilleArrivee("Mbour");
        voyage2.setCompagny("Dem-Dikk");
        voyage2.setPrix(5000);
        voyage2.setDateDepart(LocalDate.now());
        voyage2.setHeureDepart(LocalTime.now());
        voyage2.setPlaceDisponibles(20);
        voyageRepository.save(voyage2);
        //end init voyage

        //init client
        Client client1 = new Client();
        client1.setNom("Diagne");
        client1.setPrenom("Khalil");
        client1.setEmail("diagne112@icloud.com");
        client1.setTelephone("+221 771566814");
        clientRepository.save(client1);

        Client client2 = new Client();
        client2.setNom("Ange");
        client2.setPrenom("dgn");
        client2.setEmail("ange10@icloud.com");
        client2.setTelephone("+221 771566814");
        clientRepository.save(client2);
        //end init client

        //init reseration
        Reservation reservation1 = new Reservation();
        reservation1.setClient(client1);
        reservation1.setVoyage(voyage1);
        reservation1.setDateReservation(LocalDate.now());
        reservation1.setNombrePlaces(3);
        reservationRepository.save(reservation1);

        Reservation reservation2 = new Reservation();
        reservation2.setClient(client2);
        reservation2.setVoyage(voyage2);
        reservation2.setDateReservation(LocalDate.now());
        reservation2.setNombrePlaces(1);
        reservationRepository.save(reservation2);
        //end init reservation
        System.out.println("#######Voyage et reservation initialisation suceess");
    }
}
