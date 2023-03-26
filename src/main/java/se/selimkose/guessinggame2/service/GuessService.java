package se.selimkose.guessinggame2.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import se.selimkose.guessinggame2.entity.Player;
import se.selimkose.guessinggame2.entity.Score;
import se.selimkose.guessinggame2.repository.GuessRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@AllArgsConstructor
@NoArgsConstructor
@Service
@SessionScope
public class GuessService {

    @Autowired
    GuessRepository guessRepository;
    @Autowired
    PlayerService playerService;


    private Random random = new Random();
    private int randomNr;
    private String message;
    private List<Long> guesses = new ArrayList<>();




    public void play(Long score) {

        if (randomNr == 0) {
            randomNr = random.nextInt(1, 101);
        }
        if(score > randomNr){
            message = "to high!";
            guesses.add(score);

        }else if(score < randomNr) {
            message = "to low!";
            guesses.add(score);

        }else{
            guesses.add(score);
            Score scoreToSave = new Score();
            scoreToSave.setPlayer(playerService.getActivePlayer());
            scoreToSave.setNumberOfGuesses((long)guesses.size());
            scoreToSave.setId(1l);
            //System.out.println(scoreToSave);
            guessRepository.save(scoreToSave);
            message = "You won with "+ guesses.size() +"!";
            guesses.clear();
            randomNr = random.nextInt(1,101);
        }

    }

    public void addRandom(int number) {
        this.randomNr = number;
    }

    public int getRandom() {
        return this.randomNr;
    }

    public String getMessage(){
        return message;
    }
    public List<Long> getPreviousGuesses() {
        return this.guesses;
    }
}
