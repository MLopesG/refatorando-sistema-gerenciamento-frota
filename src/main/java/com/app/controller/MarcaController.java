package com.app.controller;

import javax.validation.Valid;

import com.app.entity.Marca;
import com.app.service.MarcaService;

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
@RequestMapping("/marcas")
public class MarcaController {
    
    @Autowired
    MarcaService service;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return  ResponseEntity.ok(service.all());
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody Marca marca) {
        return ResponseEntity.ok(service.save(marca));
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable(value = "id")  Integer id,@Valid @RequestBody Marca marca)
    {   
        Marca marcaBody = marca;
        marcaBody.setId(id);

        return ResponseEntity.ok(service.save(marcaBody));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteVeiculo(@PathVariable(value = "id")  Integer id){
        return ResponseEntity.ok(service.delete(id));
    }

}