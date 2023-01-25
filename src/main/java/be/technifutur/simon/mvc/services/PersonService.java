package be.technifutur.simon.mvc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import be.technifutur.simon.mvc.models.Person;
import be.technifutur.simon.mvc.models.PersonForm;

@Service
public class PersonService {
    List<Person> personList = new ArrayList<>();

    public void addPerson(PersonForm personForm) {
        personList.add(new Person(
            personForm.getNom(),
            personForm.getPrenom(),
            personForm.getDateNaissance()
        ));
    }

    public List<Person> getAll() {return new ArrayList<>(personList);}
}
