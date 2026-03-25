package dev.paul.javamon.repository;

import dev.paul.javamon.model.Move;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoveRepository extends JpaRepository<Move, Long> {
}