package be.technifutur.simon.mvc.controller;

import be.technifutur.simon.mvc.models.HotelForm;
import be.technifutur.simon.mvc.services.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HotelController {

    private final HotelService hotelService;

    @GetMapping("/hotel/add")
    public String addHotel(Model model) {
        model.addAttribute("hotelForm", new HotelForm());

        return "hotel/add";
    }

    @PostMapping("/hotel/add")
    public String processHotelForm(HotelForm hotelForm) {
        hotelService.addHotel(hotelForm);

        return "redirect:/hotel/all";
    }

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/hotel/all")
    public String allHotels(Model model) {
        model.addAttribute("hotels", hotelService.getAll());

        return "hotel/all";
    }

    @GetMapping("hotel/{numHotel}")
    public String oneHotel(Model model, @PathVariable int numHotel) {
        model.addAttribute("hotel", hotelService.getOne(numHotel));

        return "hotel/one";
    }
}
