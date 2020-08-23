package com.app.repository;

import com.app.entity.Estoque;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {
    
}