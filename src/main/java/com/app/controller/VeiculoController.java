package com.app.controller;

import javax.validation.Valid;

import com.app.entity.Veiculo;
import com.app.service.VeiculoService;

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
@RequestMapping("/veiculos")
public class VeiculoController {
    
    @Autowired
    VeiculoService service;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return  ResponseEntity.ok(service.all());
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody Veiculo veiculo) {
        return ResponseEntity.ok(service.save(veiculo));
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable(value = "id")  Integer id,@Valid @RequestBody Veiculo veiculo)
    {   
        Veiculo veiculoBody = veiculo;
        veiculoBody.setId(id);

        return ResponseEntity.ok(service.save(veiculoBody));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteVeiculo(@PathVariable(value = "id")  Integer id){
        return ResponseEntity.ok(service.delete(id));
    }

}