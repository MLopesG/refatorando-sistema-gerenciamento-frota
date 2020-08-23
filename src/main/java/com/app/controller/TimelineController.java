package com.app.controller;

import com.app.service.TimelineService;

import org.springframework.beans.factory.annotation.Autowired;
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
        return ResponseEntity.unprocessableEntity().body(service.all());
    }
}