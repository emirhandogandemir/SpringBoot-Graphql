package com.example.baskett.resource;

import com.example.baskett.domain.Player;
import com.example.baskett.dto.PlayerDto;
import com.example.baskett.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerMutationResolver implements GraphQLMutationResolver {

    private final PlayerRepository playerRepository;

    public Player addPlayer(PlayerDto playerDto) {
        if (checkIfPlayerLimitExceed()) {
            return playerRepository.save(dtoToEntity(playerDto)); // Takım içerisindeki sayı aşılmammışa ekleyip
        }
        return playerRepository.getByName(playerDto.getName()); // eğer aşılmışssa eklenilmeye çalışılan playerin adını döndürücek bize
    }

    public boolean deletePlayer(int id) {
        playerRepository.deleteById(id);
        return true;
    }

    public boolean checkIfPlayerLimitExceed() {
        if (playerRepository.count() > 12) {
            return false;
        }
        return true;
    }

    private Player dtoToEntity(PlayerDto playerDto) {
        Player player = new Player();
        player.setName(playerDto.getName());
        player.setPosition(playerDto.getPosition());
        player.setSurname(playerDto.getSurname());
        return player;
    }
}
