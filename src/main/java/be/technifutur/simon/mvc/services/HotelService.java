package be.technifutur.simon.mvc.services;

import be.technifutur.simon.mvc.models.Hotel;
import be.technifutur.simon.mvc.models.HotelForm;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {

    private final List<Hotel> hotels = new ArrayList<>();

    public HotelService() {
        hotels.add(new Hotel("Hilton", "Carr de l'Europe 3, 1000 Bruxelles", 4, "Michel"));
        hotels.add(new Hotel("Mercure", "Rue St Léonard 182, 4000 Liège", 3, "Jean"));
        hotels.add(new Hotel("La maison de Daniyal", "par là-bas", 1000, "Eude"));
        hotels.add(new Hotel("Chez Julie", "Dans mon cœur", 99999, "Gilbert"));
    }

    public List<Hotel> getAll() {return new ArrayList<>(hotels);}

    public Hotel getOne(int numHotel) {
        return hotels.stream()
                .filter(hotel -> hotel.getID() == numHotel)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Pas d'hotel avec ce numéro"));
    }

    public void addHotel(HotelForm hotelForm) {
        hotels.add(new Hotel(hotelForm.getNomHotel(), hotelForm.getAdresse(), hotelForm.getNbrEtoiles(), hotelForm.getNomReceptionniste()));
    }
}
