package bus.reservation.Voyages.ReservationDto;

import java.time.LocalDate;
import java.time.LocalTime;


public class VoyageDto {

    private Long id;
    private String villeDepart;
    private String villeArrivee;
    private LocalDate dateDepart;
    private LocalTime heureDepart;
    private int placeDisponibles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
