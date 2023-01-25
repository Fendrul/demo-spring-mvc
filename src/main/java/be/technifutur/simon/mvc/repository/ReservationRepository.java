package be.technifutur.simon.mvc.repository;

import be.technifutur.simon.mvc.models.entity.Reservation;

import java.util.HashSet;
import java.util.Set;

public interface ReservationRepository {

    Set<Reservation> getFromMonth = new HashSet<>();
}
