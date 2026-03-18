package dev.paul.javamon.service;

import dev.paul.javamon.model.User;
import dev.paul.javamon.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public boolean register(User user) {

        if(user.getUsername() == null || user.getUsername().isBlank()){
            return false;
        }

        if(user.getPassword() == null || user.getPassword().isBlank()){
            return false;
        }

        if(repository.findByUsername(user.getUsername()).isPresent()){
            return false;
        }

        repository.save(user);
        return true;
    }

    public boolean login(String username, String password) {
        Optional<User> user = repository.findByUsername(username);

        if(user.isPresent()) {
            return user.get().getPassword().equals(password);
        }

        return false;
    }
}
