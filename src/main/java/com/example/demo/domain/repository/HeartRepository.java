package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Board;
import com.example.demo.domain.entity.Heart;
import com.example.demo.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface HeartRepository extends JpaRepository<Heart, Long> {

    boolean existsByUserAndBoard(User user, Board board);

    Optional<Heart> findByUserAndBoard(User user, Board board);

    @Modifying
    @Transactional
    @Query("DELETE FROM Heart h WHERE h.user = ?1 AND h.board = ?2")
    void deleteByUserAndBoard(User user, Board board);

}
