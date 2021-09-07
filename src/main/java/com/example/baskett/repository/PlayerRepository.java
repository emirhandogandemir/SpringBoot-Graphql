package com.example.baskett.repository;

import com.example.baskett.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

Player getByName(String name);

}