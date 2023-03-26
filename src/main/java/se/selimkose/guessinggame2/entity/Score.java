package se.selimkose.guessinggame2.entity;


import jakarta.persistence.*;
import lombok.*;

@RequiredArgsConstructor
//@NoArgsConstructor
@Entity
@Data
@Table(name = "score")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "guesses", nullable = false)
    private Long numberOfGuesses;


    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "player_id", referencedColumnName = "player_id")
    private Player player;



}
