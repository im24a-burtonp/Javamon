package dev.paul.javamon.controller;

import dev.paul.javamon.model.User;
import dev.paul.javamon.model.UserParty;
import dev.paul.javamon.repository.UserPartyRepository;
import dev.paul.javamon.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/party")
public class PartyController {

    private final UserRepository userRepository;
    private final UserPartyRepository userPartyRepository;

    public PartyController(UserRepository userRepository,
                           UserPartyRepository userPartyRepository) {
        this.userRepository = userRepository;
        this.userPartyRepository = userPartyRepository;
    }

    @PostMapping("/add")
    public void addToParty(@RequestParam Long pokemonId, HttpSession session){

        String username = (String) session.getAttribute("user");

        if(username == null){
            throw new RuntimeException("Not logged in");
        }

        User user = userRepository.findByUsername(username).get();

        UserParty party = new UserParty();
        party.setUserId(user.getId());
        party.setPokemonId(pokemonId);
        party.setSlot(1);

        userPartyRepository.save(party);
    }

    @GetMapping
    public List<UserParty> getParty(HttpSession session){

        String username = (String) session.getAttribute("user");

        if(username == null){
            throw new RuntimeException("Not logged in");
        }

        User user = userRepository.findByUsername(username).get();

        return userPartyRepository.findByUserId(user.getId());
    }
}