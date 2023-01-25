package be.technifutur.simon.mvc.services;

import be.technifutur.simon.mvc.models.Room;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    private final List<Room> rooms = new ArrayList<>();

    public RoomService() {
        rooms.add(new Room(1, 1, 0, 20, "nomHotel"));
        rooms.add(new Room(2, 2, 0, 25, "Mercure"));
        rooms.add(new Room(3, 0, 1, 30, "La maison de Daniyal"));
        rooms.add(new Room(4, 1, 1, 30, "Chez Julie"));
    }

    public List<Room> getAll() {
        return new ArrayList<>(rooms);
    }

    public Room getOne(int numRoom) {
        return rooms.stream()
                .filter(room -> room.getNumRoom() == numRoom)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Pas de chambre avec ce num"));
    }

    public void insert(Room room) {
        if (room.getNumRoom() <= 0 ||
            room.getNbrSimpleBed() < 0 || 
            room.getNbrDoubleBed() < 0 ||
            room.getSize() < 0)
        throw new RuntimeException("Valeur pour la chambre invalide");
        
        rooms.add(room);
    }

    public void update(int num, Room room){
        Room toUpdate = getOne(num);
        toUpdate.setNbrSimpleBed(room.getNbrSimpleBed());
        toUpdate.setNbrDoubleBed(room.getNbrDoubleBed());
        toUpdate.setSize(room.getSize());
    }
}
