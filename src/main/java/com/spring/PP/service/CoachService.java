package com.spring.PP.service;

import com.spring.PP.db.dto.AddressDto;
import com.spring.PP.db.dto.CoachDto;
import com.spring.PP.db.model.Address;
import com.spring.PP.db.model.Club;
import com.spring.PP.db.model.Coach;
import com.spring.PP.db.repo.ClubRepository;
import com.spring.PP.db.repo.CoachRepository;
import com.spring.PP.exception.MissingEntityException;
import org.springframework.stereotype.Service;

@Service
public class CoachService extends GenericCRUDService<Coach> {
    private final CoachRepository repository;

    private final ClubRepository clubRepository;

    public CoachService(CoachRepository repository, ClubRepository clubRepository) {
        super(repository);
        this.repository = repository;
        this.clubRepository = clubRepository;
    }

    public Coach createDto(CoachDto model) throws MissingEntityException {
        Coach entity = new Coach();
        Club club = null;
        if(model.getClub() != null){
            club = this.clubRepository.findById(model.getClub()).orElseThrow(()-> new MissingEntityException("Club not found."));
            entity.setClub(club);
        }

        entity.setName(model.getName());

        Coach savedCoach = this.repository.save(entity);
        if(model.getClub() != null){
            club.setCoach(savedCoach);
            this.clubRepository.save(club);
        }

        return savedCoach;
    }

    public Coach updateDto(Long id, CoachDto model) throws MissingEntityException {
        Coach entity = this.repository.findById(id).orElseThrow(() -> new MissingEntityException("Entity not found."));
        Club club = entity.getClub();
        if(club!=null) {
            if(!entity.getClub().getId().equals(model.getClub())){
                club.setAddress(null);
                this.clubRepository.save(club);
                if(model.getClub() != null){
                    club = this.clubRepository.findById(model.getClub()).orElseThrow(() -> new MissingEntityException("Club not found"));
                    entity.setClub(club);
                }
            }
        }

        entity.setName(model.getName());

        Coach savedCoach = this.repository.save(entity);

        if(model.getClub() != null && club != null){
            club.setCoach(savedCoach);
            this.clubRepository.save(club);
        }


        return savedCoach;
    }
}
