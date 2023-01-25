package be.technifutur.simon.mvc.models;

import be.technifutur.simon.mvc.services.RoomService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class Hotel {
    private static int IDCounter = 0;
    private int ID;
    private String nomHotel;
    private String adresse;
    private String nomReceptionniste;
    private int nbrEtoiles;
    private List<Room> listRooms  = new ArrayList<>();

    public Hotel(String nomHotel, String adresse, int nbrEtoiles, String nomReceptionniste) {
        this.nomHotel = nomHotel;
        this.adresse = adresse;
        this.nbrEtoiles = nbrEtoiles;
        this.nomReceptionniste = nomReceptionniste;
        this.ID = IDCounter;
        IDCounter++;

        this.listRooms.add(new Room(1, 1, 0, 20, nomHotel));
        this.listRooms.add(new Room(2, 2, 0, 25, nomHotel));
        this.listRooms.add(new Room(3, 0, 1, 30, nomHotel));
        this.listRooms.add(new Room(4, 1, 1, 30, nomHotel));
    }
}
