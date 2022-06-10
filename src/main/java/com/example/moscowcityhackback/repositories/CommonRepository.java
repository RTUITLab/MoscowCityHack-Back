package com.example.moscowcityhackback.repositories;

import com.example.moscowcityhackback.entity.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonRepository<E extends AbstractEntity> extends JpaRepository<E, Long> {

}
