package com.app.controller;

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

    @GetMapping("/index")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.unprocessableEntity().body(service.all());
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Veiculo veiculo) {
        return ResponseEntity.unprocessableEntity().body(service.save(veiculo));
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable(value = "id")  Integer id, @RequestBody Veiculo veiculo)
    {   
        Veiculo veiculoBody = veiculo;
        veiculoBody.setId(id);

        return ResponseEntity.unprocessableEntity().body(service.save(veiculoBody));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteVeiculo(@PathVariable(value = "id")  Integer id){
        return ResponseEntity.unprocessableEntity().body(service.delete(id));
    }

}