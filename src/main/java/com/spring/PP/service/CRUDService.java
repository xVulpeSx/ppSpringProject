package com.spring.PP.service;

import com.spring.PP.db.model.AbstractData;
import com.spring.PP.exception.MissingEntityException;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CRUDService <T extends AbstractData> {
    T findById(Long id) throws MissingEntityException;
    List<T> findAllPagination(Pageable paging);
    T create(T model);
    T update(Long id, T model) throws MissingEntityException;
    void delete(Long id) throws MissingEntityException;
}
