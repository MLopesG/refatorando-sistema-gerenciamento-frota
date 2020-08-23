package com.app.repository;

import com.app.entity.RetiradaProduto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RetiradaProdutoRepository extends JpaRepository<RetiradaProduto, Integer> {
    
}