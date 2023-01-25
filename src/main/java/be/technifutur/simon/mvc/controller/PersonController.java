package be.technifutur.simon.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import be.technifutur.simon.mvc.models.PersonForm;
import be.technifutur.simon.mvc.services.PersonService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public String allPersons(Model model) {
        model.addAttribute("listPerson", personService.getAll());

        return "person/all";
    }
    
    @GetMapping("/insert")
    public String insertPerson(@ModelAttribute("personForm") PersonForm personForm) {
        return "person/insert";
    }

    @PostMapping("/insert")
    public String processPerson(@ModelAttribute("personForm") @Valid PersonForm personForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "person/insert";

        personService.addPerson(personForm);

        return "redirect:all";
    }
}
