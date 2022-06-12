package com.example.moscowcityhackback.services;

import com.example.moscowcityhackback.entity.AbstractEntity;
import com.example.moscowcityhackback.repositories.CommonRepository;
import lombok.AllArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Transactional
public class AbstractService<E extends AbstractEntity, R extends CommonRepository<E>> {
    protected final R repository;

    public List<E> getAll() {
        return repository.findAll();
    }

    public E getById(long id) {
        return repository.findById(id).orElse(null);
    }

    public E create(E e) {
        repository.save(e);
        return repository.findById(e.getId()).orElse(null);
    }

    public E update(long id, E newE) {
        newE.setId(id);
        repository.save(newE);
        return repository.findById(id).orElse(null);
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
