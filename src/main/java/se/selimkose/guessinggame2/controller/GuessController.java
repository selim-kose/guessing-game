package se.selimkose.guessinggame2.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import se.selimkose.guessinggame2.service.GuessService;


@AllArgsConstructor
@Controller
public class GuessController {
    private GuessService guessService;

    @PostMapping("/guess")
    public String post(Long guess, Model model) {
        guessService.play(guess);
        model.addAttribute("previousGuess", guessService.getPreviousGuesses());
        model.addAttribute("random", guessService.getRandom());
        model.addAttribute("message", guessService.getMessage());
        return "guesspage";
    }

    @GetMapping("/guess")
    public String get(Model model) {
        return "guesspage";
    }
}
