package com.app.repository;

import com.app.entity.Manuntencao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ManuntencaoRepository extends JpaRepository<Manuntencao, Integer> {
    
}