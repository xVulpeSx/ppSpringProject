package com.spring.PP.service;

import com.spring.PP.db.model.AbstractData;
import com.spring.PP.exception.MissingEntityException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public abstract class GenericCRUDService <T extends AbstractData> implements CRUDService<T>{
    private final JpaRepository<T, Long> repository;

    @Override
    public T findById(Long id) throws MissingEntityException {
        return this.repository.findById(id).orElseThrow(() -> new MissingEntityException("Entity not found"));
    }

    @Override
    public List<T> findAllPagination(Pageable paging) {
        return this.repository.findAll(paging).stream().collect(Collectors.toList());
    }

    @Override
    public T create(T model) {
        return this.repository.save(model);
    }

    @Override
    public T update(Long id, T model) throws MissingEntityException {
        T entity = this.repository.findById(id).orElseThrow(()-> new MissingEntityException("Entity not found"));

        return this.repository.save(model);
    }

    @Override
    public void delete(Long id) throws MissingEntityException {
        this.repository.deleteById(id);
    }
}
