package com.app.repository;

import com.app.entity.Veiculo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
    
}