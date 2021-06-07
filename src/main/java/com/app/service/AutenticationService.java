package com.app.service;

import com.app.entity.Cadastro;
import com.app.repository.CadastroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

@Service
public class AutenticationService implements UserDetailsService {

    @Autowired
    private CadastroRepository repository;

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException{

        Cadastro cadastro = repository
                            .findByCpf(cpf)
                            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return User
                .builder()
                .username(cadastro.getNome())
                .password(cadastro.getPassword())
                .roles("USER")
                .build();
    }
}
