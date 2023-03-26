package se.selimkose.guessinggame2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.selimkose.guessinggame2.entity.Score;

import java.util.List;


public interface GuessRepository extends JpaRepository<Score,Long> {

    List<Score> findByPlayerId(Long id);
   // Long findByPlayerId(Long id);



}
