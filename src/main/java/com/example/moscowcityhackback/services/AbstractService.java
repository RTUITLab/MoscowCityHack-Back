package com.example.moscowcityhackback.services;

import com.example.moscowcityhackback.entity.AbstractEntity;
import com.example.moscowcityhackback.repositories.CommonRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class AbstractService<E extends AbstractEntity, R extends CommonRepository<E>> {
    protected final R repository;

    public List<E> getAll() {
        return repository.findAll();
    }

    public E getById(long id) {
        return repository.getReferenceById(id);
    }

    public List<E> create(E e) {
        repository.save(e);
        return repository.findAll();
    }

    public E update(long id, E newE) {
        newE.setId(id);
        repository.save(newE);
        return repository.getReferenceById(id);
    }

    public List<E> delete(long id) {
        repository.deleteById(id);
        return repository.findAll();
    }

    public List<E> deleteAll() {
        repository.deleteAll();
        return repository.findAll();
    }
}
