package be.technifutur.simon.mvc.controller;

import be.technifutur.simon.mvc.models.Room;
import be.technifutur.simon.mvc.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room")
public class RoomController {

    /**
     * 3 conditions à DI :
     * 1 - Je peux injecter une dépendance pour créer un Bean
     * 2 - il existe un Bean qui correspond au type de la dépendance souhaitée
     * 3 - la dépendance est déclarée
     */

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/all")
    public String allRoom(Model model) {
        model.addAttribute("rooms", roomService.getAll());

        return "room/all";
    }

    @GetMapping("/{numRoom}")
    public String oneRoom(Model model, @PathVariable int numRoom) {
        model.addAttribute("room", roomService.getOne(numRoom));

        return "room/one";
    }

    @GetMapping("/add")
    public String insertForm(Model model) {
        model.addAttribute("room", new Room());
        return "room/insert";
    }

    @PostMapping("/add")
    public String processInsert(Room fRoom) {
        roomService.insert(fRoom);

        return "redirect:all";
    }

    @GetMapping("/update/{num}")
    public String updateForm(Model model, @PathVariable int num){
        Room toUpdate = roomService.getOne(num);

        model.addAttribute("room", toUpdate);

        return "room/update";
    }

    @PostMapping("/update/{num}")
    public String processUpdate(Room room, @PathVariable int num){
        roomService.update(num, room);

        return "redirect:/room/all";
    }

}