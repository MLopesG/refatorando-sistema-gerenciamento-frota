package com.app.repository;

import com.app.entity.Cadastro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {
    
}