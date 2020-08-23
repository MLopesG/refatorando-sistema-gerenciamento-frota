package com.app.repository;

import com.app.entity.Patio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatioRepository extends JpaRepository<Patio, Integer> {
    
}