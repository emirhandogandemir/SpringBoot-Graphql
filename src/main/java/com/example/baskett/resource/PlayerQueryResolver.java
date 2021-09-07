package com.example.baskett.resource;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import com.example.baskett.domain.Player;
import com.example.baskett.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PlayerQueryResolver implements GraphQLQueryResolver{

    private final PlayerRepository playerRepository;

    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }

    public Optional<Player> getById(int id) {
        return playerRepository.findById(id);
    }
}