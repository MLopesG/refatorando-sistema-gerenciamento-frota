package com.app.repository;

import java.util.Optional;

import com.app.entity.Cadastro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {
    Optional<Cadastro> findByCpf(String cpf);
}