package be.technifutur.simon.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import be.technifutur.simon.mvc.models.Calculatrice;
import be.technifutur.simon.mvc.services.CalculatriceService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/calculatrice")
public class CalculatriceController {
    
    @GetMapping("/calcul")
    public String Insertcalcul(Model model) {
        model.addAttribute("calculatrice", new Calculatrice());
        return "calculatrice/calcul";
    }

    @PostMapping("/calcul")
    public String processCalcul(@Valid Calculatrice calc) {
        CalculatriceService.processCalcul(calc);

        return "/calculatrice/result";
    }
}
