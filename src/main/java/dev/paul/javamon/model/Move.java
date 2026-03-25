package dev.paul.javamon.model;

import jakarta.persistence.*;

@Entity
public class Move {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int power;
    private int accuracy; /* Maybe a status effect on some moves, like burn, poison, etc? Do i make a Effect Entity? Also, I don't want any types.. It's too complicated that way.. no effective/weak combinations */
}