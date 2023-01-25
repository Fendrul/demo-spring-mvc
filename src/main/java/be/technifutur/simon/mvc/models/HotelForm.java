package be.technifutur.simon.mvc.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class HotelForm {
    
    @NotBlank
    @Size(max = 25)
    private String nomHotel;
    @NotBlank
    @Size(max = 50)
    private String adresse;
    @Size(max = 25)
    private String nomReceptionniste;
    @Max(5)
    private int nbrEtoiles;
    private List<Room> listRooms  = new ArrayList<>();
}
