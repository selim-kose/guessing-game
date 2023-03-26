package se.selimkose.guessinggame2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.selimkose.guessinggame2.entity.Player;

import java.util.List;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

   List<Player> findByName(String name);
}
