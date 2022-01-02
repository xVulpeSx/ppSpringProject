package com.spring.PP.service;

import com.spring.PP.db.dto.CoachDto;
import com.spring.PP.db.dto.ManagerDto;
import com.spring.PP.db.model.Club;
import com.spring.PP.db.model.Coach;
import com.spring.PP.db.model.Manager;
import com.spring.PP.db.model.Player;
import com.spring.PP.db.repo.ManagerRepository;
import com.spring.PP.db.repo.PlayerRepository;
import com.spring.PP.exception.MissingEntityException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerService extends GenericCRUDService<Manager> {
    private final ManagerRepository repository;

    private final PlayerRepository playerRepository;
    public ManagerService(ManagerRepository repository, PlayerRepository playerRepository) {
        super(repository);
        this.repository = repository;
        this.playerRepository = playerRepository;
    }

    public Manager createDto(ManagerDto model) throws MissingEntityException {
        Manager entity = new Manager();
        List<Player> players = new ArrayList<>();

        entity.setName(model.getName());

        for (Long id: model.getPlayers()) {
            Player player = this.playerRepository.findById(id).orElseThrow(()-> new MissingEntityException("Entity not found"));

            players.add(player);
        }

        entity.setPlayers(players);

        Manager savedManager = this.repository.save(entity);

        for(Long id : model.getPlayers()){
            Player player = this.playerRepository.findById(id).orElseThrow(()-> new MissingEntityException("Entity not found"));

            player.setManager(savedManager);
            this.playerRepository.save(player);
        }

        return savedManager;
    }

    public Manager updateDto(Long id, ManagerDto model) throws MissingEntityException {
        Manager entity = this.repository.findById(id).orElseThrow(() -> new MissingEntityException("Entity not found."));
        List<Player> players = entity.getPlayers();

        for (Player player: players) {
            player.setManager(null);
            this.playerRepository.save(player);
        }

        List<Player> newPlayers = new ArrayList<>();

        for(Long playersId : model.getPlayers()){
            Player player = this.playerRepository.findById(playersId).orElseThrow(() -> new MissingEntityException("PlayerNotFound"));

            player.setManager(entity);
            newPlayers.add(player);
        }

        entity.setName(model.getName());
        entity.setPlayers(newPlayers);

        return this.repository.save(entity);
    }
}
