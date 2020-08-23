package com.app.controller;

import com.app.entity.Cargo;
import com.app.services.CargoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cargos")
public class CargoController {
    
    @Autowired
    private CargoService service;

    @GetMapping("index")
    public ResponseEntity<?> getAll(){
        List<Cargo> registros = service.all();
        Map<String, Object> result = new HashMap<>();
        
        try{
            result.put("data", registros);
            result.put("success", true);
            result.put("message", "");
            
            return ResponseEntity.unprocessableEntity().body(result);
        }
        catch(Exception error){
            result.put("success", false);
            result.put("message", error.getMessage());
            
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Cargo cargo) {
        return ResponseEntity.unprocessableEntity().body(service.save(cargo));
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable(value = "id")  Integer id, @RequestBody Cargo cargo)
    {   
        Cargo cargoBody = cargo;
        cargoBody.setId(id);

        return ResponseEntity.unprocessableEntity().body(service.save(cargoBody));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteVeiculo(@PathVariable(value = "id")  Integer id){
        return ResponseEntity.unprocessableEntity().body(service.delete(id));
    }
}