package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.entity.Timeline;
import com.app.services.TimelineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/timeline")
public class TimelineController {

    @Autowired
    private TimelineService service;

    @GetMapping("index")
    public ResponseEntity<?> getAll(){
        List<Timeline> registros = service.all();
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
}