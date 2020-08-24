package com.app.controller;

import com.app.entity.Manuntencao;
import com.app.service.ManuntencaoService;

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
@RequestMapping("/manuntencoes")
public class ManuntencaoController {
    
    @Autowired
    ManuntencaoService service;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.unprocessableEntity().body(service.all());
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Manuntencao manuntencao) {
        return ResponseEntity.unprocessableEntity().body(service.save(manuntencao));
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable(value = "id")  Integer id, @RequestBody Manuntencao manuntencao)
    {   
        Manuntencao manuntencaoBody = manuntencao;
        manuntencaoBody.setId(id);

        return ResponseEntity.unprocessableEntity().body(service.save(manuntencaoBody));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteVeiculo(@PathVariable(value = "id")  Integer id){
        return ResponseEntity.unprocessableEntity().body(service.delete(id));
    }

}