package com.app.controller;

import com.app.entity.Cargo;
import com.app.service.CargoService;

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
@RequestMapping("/cargos")
public class CargoController {
    
    @Autowired
    private CargoService service;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return  ResponseEntity.ok(service.all());
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Cargo cargo) {
        return ResponseEntity.ok(service.save(cargo));
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable(value = "id")  Integer id, @RequestBody Cargo cargo)
    {   
        Cargo cargoBody = cargo;
        cargoBody.setId(id);

        return ResponseEntity.ok(service.save(cargoBody));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteVeiculo(@PathVariable(value = "id")  Integer id){
        return ResponseEntity.ok(service.delete(id));
    }
}