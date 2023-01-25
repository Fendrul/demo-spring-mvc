package be.technifutur.simon.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {

    // GET - htpp://localhost:8080/message
    @GetMapping("/message")
    public String displayMessage(Model model) {
        String message = "message depuis contrôlleur";

        model.addAttribute("message", message);
        return "message";
    }

    // GET - htpp://localhost:8080/redirect
    @GetMapping("/redirect")
    public String redirect() {
        return "redirect:message";
    }

    // GET - htpp://localhost:8080/forward
    @GetMapping("/forward")
    public String forward() {
        System.out.println("FORWARDEEEEEEEEEE");
        return "forward:message";
    }

}
