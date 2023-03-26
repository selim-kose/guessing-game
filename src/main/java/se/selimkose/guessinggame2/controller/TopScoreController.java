package se.selimkose.guessinggame2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.selimkose.guessinggame2.service.TopScoreService;

@Controller
public class TopScoreController {


    @Autowired
    TopScoreService topScoreService;
    @GetMapping("/top")
    public String getToplist(Model model) {
      model.addAttribute("topScores", topScoreService.getTopList());
        return "topscores";
    }
}


