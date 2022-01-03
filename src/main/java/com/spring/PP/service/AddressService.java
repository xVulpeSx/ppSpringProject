package com.spring.PP.service;

import com.spring.PP.db.dto.AddressDto;
import com.spring.PP.db.model.Address;
import com.spring.PP.db.model.Club;
import com.spring.PP.db.repo.AddressRepository;
import com.spring.PP.db.repo.ClubRepository;
import com.spring.PP.exception.MissingEntityException;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends  GenericCRUDService<Address> {
    private final AddressRepository repository;

    private final ClubRepository clubRepository;

    public AddressService(AddressRepository repository, ClubRepository clubRepository) {
        super(repository);
        this.repository = repository;
        this.clubRepository = clubRepository;
    }

    public Address createDto(AddressDto model) throws MissingEntityException{
        Address entity = new Address();
        Club club = null;
        if(model.getClub() != null){
            club = this.clubRepository.findById(model.getClub()).orElseThrow(()-> new MissingEntityException("Club not found."));
            if(club.getAddress() != null){
                Address oldAddress = club.getAddress();
                oldAddress.setClub(null);
                this.repository.save(oldAddress);
            }
            entity.setClub(club);
        }

        entity.setStreet(model.getStreet());
        entity.setNumber(model.getNumber());

        Address savedAddress = this.repository.save(entity);
        if(model.getClub() != null){
            club.setAddress(savedAddress);
            this.clubRepository.save(club);
        }

        return savedAddress;
    }

    public Address updateDto(Long id, AddressDto model) throws MissingEntityException {
        Address entity = this.repository.findById(id).orElseThrow(() -> new MissingEntityException("Entity not found."));
        Club club = entity.getClub();
        if(club != null){
            if(!entity.getClub().getId().equals(model.getClub()) && model.getClub() != null){
                club.setAddress(null);
                this.clubRepository.save(club);
                club = this.clubRepository.findById(model.getClub()).orElseThrow(() -> new MissingEntityException("Club not found"));
                entity.setClub(club);
            }
        }


        entity.setStreet(model.getStreet());
        entity.setNumber(model.getNumber());

        Address savedAddress = this.repository.save(entity);
        if(model.getClub() != null && club != null){
            club.setAddress(savedAddress);
            this.clubRepository.save(club);
        }
        return savedAddress;
    }
}
