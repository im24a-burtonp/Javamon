package dev.paul.javamon.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int hp;
    private int attack;
    private int defense;
    private int speed;
    private String image;
    private Long move1Id;
    private Long move2Id;
    private Long move3Id;
    private Long move4Id;
}