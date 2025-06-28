package bus.reservation.Voyages.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Voyage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String villeDepart;
    private String villeArrivee;
    private LocalDate dateDepart;
    private LocalTime heureDepart;
    private int placeDisponibles;

    @OneToMany (mappedBy = "voyage", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public LocalDate getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(LocalDate dateDepart) {
        this.dateDepart = dateDepart;
    }

    public LocalTime getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(LocalTime heureDepart) {
        this.heureDepart = heureDepart;
    }

    public int getPlaceDisponibles() {
        return placeDisponibles;
    }

    public void setPlaceDisponibles(int placeDisponibles) {
        this.placeDisponibles = placeDisponibles;
    }
}
