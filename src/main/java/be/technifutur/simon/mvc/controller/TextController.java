package be.technifutur.simon.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import be.technifutur.simon.mvc.services.TextService;


@Controller
public class TextController {

    private static final int TAILLE_MAX_MOT = 11;
    private static final int TAILLE_MIN_MOT = 5;
    
    // GET - htpp://localhost:8080/message
    @GetMapping("/text/{numMots}")
    public String displayMots(Model model, @PathVariable int numMots) {
        List<String> listeMots = TextService.motGenerateur(numMots);

        model.addAttribute("listeMots", listeMots);

        return "textGenerator/textGenerator";
    }
}
