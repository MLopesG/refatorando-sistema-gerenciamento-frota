package com.app.controller;

import com.app.entity.Patio;
import com.app.service.PatioService;

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
@RequestMapping("/registros-patio")
public class PatioController {
    
    @Autowired
    PatioService service;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return  ResponseEntity.ok(service.all());
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Patio patio) {
        return ResponseEntity.ok(service.save(patio));
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable(value = "id")  Integer id, @RequestBody Patio patio)
    {   
        Patio patioBody = patio;
        patioBody.setId(id);

        return ResponseEntity.ok(service.save(patioBody));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteVeiculo(@PathVariable(value = "id")  Integer id){
        return ResponseEntity.ok(service.delete(id));
    }
}