package se.selimkose.guessinggame2.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.selimkose.guessinggame2.entity.Player;
import se.selimkose.guessinggame2.service.PlayerService;

@AllArgsConstructor
@Controller
public class PlayerController {

    PlayerService playerService;

    @GetMapping("/")
    public String getLoginPage(Model model){
        model.addAttribute("player", new Player());
        return "loginpage";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(Player player){

        System.out.println(player);
        playerService.savePlayer(player);
        return "redirect:/guess";
    }

}
