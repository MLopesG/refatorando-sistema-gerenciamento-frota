package com.app.controller;

import com.app.entity.TipoManuntecao;
import com.app.service.TipoManuntecaoService;

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
@RequestMapping("/tipo-manuntencoes")
public class TipoManuntecaoController {
    
    @Autowired
   TipoManuntecaoService service;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return  ResponseEntity.ok(service.all());
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody TipoManuntecao tipo) {
        return ResponseEntity.ok(service.save(tipo));
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable(value = "id")  Integer id, @RequestBody TipoManuntecao tipo)
    {   
        TipoManuntecao tipoBody = tipo;
        tipoBody.setId(id);

        return ResponseEntity.ok(service.save(tipoBody));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteVeiculo(@PathVariable(value = "id")  Integer id){
        return ResponseEntity.ok(service.delete(id));
    }

}