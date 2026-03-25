package dev.paul.javamon.repository;

import dev.paul.javamon.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}