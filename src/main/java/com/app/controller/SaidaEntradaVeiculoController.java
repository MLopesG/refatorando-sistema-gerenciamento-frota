package com.app.controller;

import javax.validation.Valid;

import com.app.entity.SaidaEntradaVeiculo;
import com.app.service.SaidaEntradaVeiculoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/entrada-saidas-veiculos")
public class SaidaEntradaVeiculoController {
    
    @Autowired
    SaidaEntradaVeiculoService service;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return  ResponseEntity.ok(service.all());
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody SaidaEntradaVeiculo saidaEntrada) {
        return ResponseEntity.ok(service.save(saidaEntrada));
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable(value = "id")  Integer id, @Valid @RequestBody SaidaEntradaVeiculo saidaEntrada)
    {   
        SaidaEntradaVeiculo saidaEntradaBody = saidaEntrada;
        saidaEntradaBody.setId(id);

        return ResponseEntity.ok(service.save(saidaEntradaBody));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteVeiculo(@PathVariable(value = "id")  Integer id){
        return ResponseEntity.ok(service.delete(id));
    }

}