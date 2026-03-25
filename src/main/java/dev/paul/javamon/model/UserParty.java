package dev.paul.javamon.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserParty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long pokemonId;
    private int slot;
}