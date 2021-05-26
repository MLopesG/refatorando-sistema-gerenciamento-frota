package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import com.app.entity.Timeline;
import com.app.repository.TimelineRepository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class TimelineService {

    private TimelineRepository repository;
    
    TimelineService(TimelineRepository timelineRepository){
        this.repository = timelineRepository;
    }

    public Map<String, Object> all(){
        List<Timeline> registros = repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        Map<String, Object> result = new HashMap<>();
        
        try{
            result.put("data", registros);
            result.put("status", true);
            result.put("message", "");
        }
        catch(Exception error){
            result.put("status", false);
            result.put("message", error.getMessage());
        }

        return result;
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