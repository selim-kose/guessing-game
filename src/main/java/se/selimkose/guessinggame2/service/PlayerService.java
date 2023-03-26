package se.selimkose.guessinggame2.service;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.selimkose.guessinggame2.entity.Player;
import se.selimkose.guessinggame2.repository.PlayerRepository;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
//@SessionScope
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    private Player activePlayer;


   public List<Player> getPlayerByName(String name) {
      List<Player> players = playerRepository.findByName(name);
       return players;
   }

    public void savePlayer(Player player) {
        if(getPlayerByName(player.getName()).isEmpty()){
            playerRepository.save(player);
            activePlayer = player;
        }else {
            for(Player i: getPlayerByName(player.getName())){
                if(i.getName().equals(player.getName())){
                    activePlayer = i;
                }
            }
        }
    }
}
