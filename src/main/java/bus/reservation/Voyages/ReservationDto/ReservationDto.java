package bus.reservation.Voyages.ReservationDto;

import bus.reservation.Clients.Dto.ClientDto;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationDto {

    private Long id;
    private LocalDate dateReservation;
    private int nombrePlaces;

    private Integer clientId;
    private Integer voyageId;

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

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getVoyageId() {
        return voyageId;
    }

    public void setVoyageId(Integer voyageId) {
        this.voyageId = voyageId;
    }
}
