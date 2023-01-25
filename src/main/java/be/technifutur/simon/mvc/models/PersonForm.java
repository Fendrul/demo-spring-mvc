package be.technifutur.simon.mvc.models;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PersonForm {
    
    @NotNull
    @Size(min = 5, max = 20)
    String nom;

    @NotNull
    @Size(min = 5, max = 20)
    String prenom;

    @Past
    LocalDate dateNaissance;
}
