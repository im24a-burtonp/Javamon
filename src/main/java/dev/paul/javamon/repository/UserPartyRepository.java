package dev.paul.javamon.repository;

import dev.paul.javamon.model.UserParty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserPartyRepository extends JpaRepository<UserParty, Long> {
    List<UserParty> findByUserId(Long userId);
}