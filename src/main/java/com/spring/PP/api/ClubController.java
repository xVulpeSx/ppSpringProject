package com.spring.PP.api;

import com.spring.PP.db.dto.AddressDto;
import com.spring.PP.db.dto.ClubDto;
import com.spring.PP.service.AddressService;
import com.spring.PP.service.ClubService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/club")
public class ClubController {
    private final ClubService service;

    public ClubController(ClubService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.findById(id));
    }

    @GetMapping("/all/{page}")
    public ResponseEntity<List<?>> getAll(@PathVariable Pageable paging){
        return ResponseEntity.ok(this.service.findAllPagination(paging));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody ClubDto model){
        return ResponseEntity.ok(this.service.createDto(model));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ClubDto model, @PathVariable Long id){
        return ResponseEntity.ok(this.service.updateDto(id, model));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        this.service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
