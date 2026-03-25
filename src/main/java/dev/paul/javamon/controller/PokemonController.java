package dev.paul.javamon.controller;

import dev.paul.javamon.model.Pokemon;
import dev.paul.javamon.repository.PokemonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {


    private final PokemonRepository pokemonRepository;

    public PokemonController(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @GetMapping
    public List<Pokemon> getAll(){
        return pokemonRepository.findAll();
    }
}