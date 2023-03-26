package se.selimkose.guessinggame2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

//@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "player_id")
    private Long id;
    @Column(name = "player_name")
    private String name;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<Score> scores;



}
