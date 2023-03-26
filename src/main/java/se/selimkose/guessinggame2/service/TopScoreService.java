package se.selimkose.guessinggame2.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.selimkose.guessinggame2.entity.Player;
import se.selimkose.guessinggame2.entity.Score;
import se.selimkose.guessinggame2.repository.GuessRepository;
import se.selimkose.guessinggame2.repository.PlayerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Getter
@Service
public class TopScoreService {
    @Autowired
    GuessRepository guessRepository;
    @Autowired
    PlayerRepository playerRepository;

    public List<Long> getPlayerScoresByPlayerId(Long id){
       List<Long> scores = new ArrayList<>();
        for(Score i : guessRepository.findByPlayerId(id)){
            scores.add(i.getNumberOfGuesses());
        }
            return scores;
    }

    public Long countAvgScore(List<Long> scores){
        Long total = 0l;
        for (Long i: scores) {
            total += i;
        }
        return total / scores.size();
    }

    public List<Long> GetAllPlayerId(){
        List<Long> playerIds = new ArrayList<>();
       for(Player i:playerRepository.findAll()){
           playerIds.add(i.getId());
       }
       return playerIds;
    }

    public List<String> getTopList(){
        List<String> topScore = new ArrayList<>();
        for (Long i: GetAllPlayerId()){
            Optional<Player> player = getPlayerNameById(i);
            topScore.add(player.get().getName() +" "+countAvgScore(getPlayerScoresByPlayerId(i)));
        }
        return topScore;
    }
    public Optional<Player> getPlayerNameById(Long id) {
        return playerRepository.findById(id);
    }


}
