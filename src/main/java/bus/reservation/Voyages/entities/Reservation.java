package bus.reservation.Voyages.entities;

import bus.reservation.Clients.Entities.Client;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateReservation;

    private int nombrePlaces;

    @ManyToOne
    @JoinColumn(name = "client_id")
//    @com.fasterxml.jackson.annotation.JsonIgnore
    @JsonBackReference
    private Client client;

    @ManyToOne
    @JoinColumn(name = "voyage_id")
    @JsonBackReference(value = "voyage-reservations")
    private Voyage voyage;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDate dateReservation) {
        this.dateReservation = dateReservation;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    public void setNombrePlaces(int nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Voyage getVoyage() {
        return voyage;
    }

    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }
}

