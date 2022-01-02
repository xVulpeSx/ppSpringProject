package com.spring.PP.service;

import com.spring.PP.db.dto.ClubDto;
import com.spring.PP.db.model.Address;
import com.spring.PP.db.model.Club;
import com.spring.PP.db.model.Coach;
import com.spring.PP.db.model.Player;
import com.spring.PP.db.repo.AddressRepository;
import com.spring.PP.db.repo.ClubRepository;
import com.spring.PP.db.repo.CoachRepository;
import com.spring.PP.db.repo.PlayerRepository;
import com.spring.PP.exception.MissingEntityException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClubService extends GenericCRUDService<Club>{
    private final ClubRepository repository;

    private final AddressRepository addressRepository;

    private final CoachRepository coachRepository;

    private final PlayerRepository playerRepository;

    public ClubService(ClubRepository repository, ClubRepository repository1, AddressRepository addressRepository, CoachRepository coachRepository, PlayerRepository playerRepository) {
        super(repository);
        this.repository = repository1;
        this.addressRepository = addressRepository;
        this.coachRepository = coachRepository;
        this.playerRepository = playerRepository;
    }

    public Club createDto(ClubDto model){
        Club club = new Club();

        club.setName(model.getName());

        Address address = null;
        if(model.getAddress() != null){
            address = this.addressRepository.findById(model.getAddress()).orElseThrow(()->new MissingEntityException("AddressNotFound"));
            club.setAddress(address);
        }

        Coach coach = null;
        if(model.getCoach() != null){
            coach = this.coachRepository.findById(model.getCoach()).orElseThrow(()->new MissingEntityException("CoachNotFound"));
            club.setCoach(coach);
        }

        List<Player> team = new ArrayList<>();
        if(model.getTeam() != null){
            for(Long id : model.getTeam()){
                team.add(this.playerRepository.findById(id).orElseThrow(()-> new MissingEntityException("PlayerNotFound")));
            }
            club.setTeam(team);
        }

        Club savedClub = this.repository.save(club);

        if(model.getAddress() != null){
            address.setClub(savedClub);
            this.addressRepository.save(address);
        }

        if(model.getCoach() != null){
            coach.setClub(savedClub);
            this.coachRepository.save(coach);
        }

        if(savedClub.getTeam() != null){
            for(Player player : savedClub.getTeam()){
                player.setClub(savedClub);
                this.playerRepository.save(player);
            }
        }

        return savedClub;
    }

    public Club updateDto(Long id, ClubDto model){
        Club entity = this.repository.findById(id).orElseThrow(()-> new MissingEntityException("ClubNotFound"));
        Address address = entity.getAddress();
        Coach coach = entity.getCoach();
        List<Player> team = entity.getTeam();

        if(address != null){
            if(!address.getId().equals(model.getAddress())){
                address.setClub(null);
                this.addressRepository.save(address);
            }
        }

        if(coach != null) {
            if(!coach.getId().equals(model.getCoach())){
                coach.setClub(null);
                this.coachRepository.save(coach);
            }
        }

        for(Player player : team){
            player.setClub(null);
            this.playerRepository.save(player);
        }

        Address newAddress = null;
        if(model.getAddress() != null){
            newAddress= this.addressRepository.findById(model.getAddress()).orElseThrow(()->new MissingEntityException("addresNotFound"));
            entity.setAddress(newAddress);
        }

        Coach newCoach = null;
        if(model.getCoach() != null){
            newCoach = this.coachRepository.findById(model.getCoach()).orElseThrow(()-> new MissingEntityException("CoachNotFound"));
            entity.setCoach(newCoach);
        }

        List<Player> newTeam = new ArrayList<>();
        for(Long playerId : model.getTeam()){
            Player player = this.playerRepository.findById(playerId).orElseThrow(()->new MissingEntityException("playerNotFound"));
            newTeam.add(player);
        }
        entity.setTeam(team);

        Club savedClub = this.repository.save(entity);

        if(model.getAddress() != null && address != null){
            address.setClub(savedClub);
            this.addressRepository.save(address);
        }

        if(model.getCoach() != null && coach != null){
            coach.setClub(savedClub);
            this.coachRepository.save(coach);
        }

        for (Player player : savedClub.getTeam()){
            player.setClub(savedClub);
            this.playerRepository.save(player);
        }

        return savedClub;
    }
}
