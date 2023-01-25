package be.technifutur.simon.mvc.models;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Person {
    String nom;
    String prenom;
    LocalDate dateNaissance;

    public Person(String nom, String prenom, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }
}

