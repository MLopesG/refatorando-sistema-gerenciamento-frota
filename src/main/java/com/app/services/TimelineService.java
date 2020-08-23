package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import com.app.entity.Timeline;
import com.app.repository.TimelineRepository;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class TimelineService {

    private TimelineRepository repository;
    
    TimelineService(TimelineRepository timelineRepository){
        this.repository = timelineRepository;
    }

    public List<Timeline> all(){
        return repository.findAll();
    }

    public void save(Timeline timeline){
        repository.save(timeline);
    }

    public Timeline get(Integer id){
        return repository.findById(id).get();
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }
}