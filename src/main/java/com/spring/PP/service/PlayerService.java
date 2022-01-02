package com.spring.PP.service;

import com.spring.PP.db.dto.ManagerDto;
import com.spring.PP.db.dto.PlayerDto;
import com.spring.PP.db.model.Club;
import com.spring.PP.db.model.Manager;
import com.spring.PP.db.model.Player;
import com.spring.PP.db.repo.ClubRepository;
import com.spring.PP.db.repo.ManagerRepository;
import com.spring.PP.db.repo.PlayerRepository;
import com.spring.PP.exception.MissingEntityException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService extends GenericCRUDService<Player>{
    private final PlayerRepository repository;

    private final ClubRepository clubRepository;

    private final ManagerRepository managerRepository;

    public PlayerService(PlayerRepository repository, PlayerRepository repository1, ClubRepository clubRepository, ManagerRepository managerRepository) {
        super(repository);
        this.repository = repository1;
        this.clubRepository = clubRepository;
        this.managerRepository = managerRepository;
    }

    public Player createDto(PlayerDto model) throws MissingEntityException {
        Player entity = new Player();

        entity.setName(model.getName());

        Club club = null;
        if(model.getClub() != null){
            club = this.clubRepository.findById(model.getClub()).orElseThrow(()-> new MissingEntityException("ClubNotFound"));
            entity.setClub(club);
        }

        Manager manager = null;
        if(model.getManager() != null){
            manager = this.managerRepository.findById(model.getManager()).orElseThrow(()-> new MissingEntityException("ManagerNotFound"));
            entity.setManager(manager);
        }

        Player savedPlayer = this.repository.save(entity);

        if(club != null){
            club.addPlayer(savedPlayer);
            this.clubRepository.save(club);
        }

        if(manager != null){
            manager.addPlayer(savedPlayer);
            this.managerRepository.save(manager);
        }

        return savedPlayer;
    }

    public Player updateDto(Long id, PlayerDto model) throws MissingEntityException {
        Player entity = this.repository.findById(id).orElseThrow(() -> new MissingEntityException("Entity not found."));
        Club club = entity.getClub();
        Manager manager = entity.getManager();

        if(club !=null){
            if(!club.getId().equals(model.getClub())){
                List<Player> team = club.getTeam();
                team.remove(entity);
                club.setTeam(team);
                this.clubRepository.save(club);
                if(model.getClub() != null){
                    club = this.clubRepository.findById(model.getClub()).orElseThrow(()->new MissingEntityException("ClubNOtFOund"));
                    entity.setClub(club);
                }
            }
        }

        if(manager != null){
            if(!manager.getId().equals(model.getManager())){
                List<Player> players = manager.getPlayers();
                players.remove(entity);
                manager.setPlayers(players);
                this.managerRepository.save(manager);
                if(model.getManager() != null){
                    manager = this.managerRepository.findById(model.getManager()).orElseThrow(()->new MissingEntityException("ManagerNotFound"));
                    entity.setManager(manager);
                }
            }
        }


        entity.setName(model.getName());

        Player savedPlayer = this.repository.save(entity);

        if(!club.getTeam().contains(savedPlayer) && club != null){
            club.addPlayer(savedPlayer);
            this.clubRepository.save(club);
        }

        if(!manager.getPlayers().contains(savedPlayer) && club != null){
            manager.addPlayer(savedPlayer);
            this.managerRepository.save(manager);
        }

        return savedPlayer;
    }
}
