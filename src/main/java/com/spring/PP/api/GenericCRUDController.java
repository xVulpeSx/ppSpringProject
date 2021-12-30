package com.spring.PP.api;

import com.spring.PP.db.model.AbstractData;
import com.spring.PP.exception.MissingEntityException;
import com.spring.PP.service.GenericCRUDService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.MalformedInputException;
import java.util.List;

@AllArgsConstructor
public abstract class GenericCRUDController <T extends AbstractData> {

    private final GenericCRUDService<T> service;

    @ExceptionHandler({MissingEntityException.class})
    public void handleException(){

    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getOne(@PathVariable Long id) throws MissingEntityException {
        return ResponseEntity.ok(this.service.findById(id));
    }

    @GetMapping("/all/{page}")
    public ResponseEntity<List<T>> getAll(@PathVariable Pageable paging){
        return ResponseEntity.ok(this.service.findAllPagination(paging));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> create(@RequestBody T model){
        return ResponseEntity.ok(this.service.create(model));
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@RequestBody T model, @PathVariable Long id){
        return ResponseEntity.ok(this.service.update(id, model));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
