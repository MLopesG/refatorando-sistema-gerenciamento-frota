package com.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.app.entity.Patio;
import com.app.entity.Timeline;
import com.app.repository.PatioRepository;
import com.app.repository.TimelineRepository;

import org.springframework.stereotype.Service;

@Service
public class PatioService {
    
    PatioRepository repository;
    TimelineRepository repositoryTimeline;

    PatioService(PatioRepository repository, TimelineRepository repositoryTimeline){
        this.repository = repository;
        this.repositoryTimeline = repositoryTimeline;
    }

    public Map<String, Object> all(){
        List<Patio> registros = repository.findAll();
        Map<String, Object> result = new HashMap<>();
        
        try{
            result.put("data", registros);
            result.put("success", true);
            result.put("message", "");
        }
        catch(Exception error){
            result.put("success", false);
            result.put("message", error.getMessage());
        }

        return result;
    }

    public Map<String, Object> save(Patio patio){
        Map<String, Object> result =  new HashMap<>();

        try{
            Timeline timeline = new Timeline();
            
            timeline.setDescricao("Padio: " + patio.getId());

            if(patio.getId() != null){
                timeline.setTipo("Alteração");
                result.put("message", "Registro de patio foi alterado com sucesso!");

            }else{
                timeline.setTipo("Novo");
                result.put("message", "Registro de patio registrado com sucesso!");
            }

            result.put("success", true);

            repositoryTimeline.save(timeline);
            repository.save(patio);

        }catch(Exception error){
            result.put("success", false);
            result.put("message", error.getStackTrace());
        }
        
        return result;
    }

    public Patio get(Integer id){
        return repository.findById(id).get();
    }

    public Map<String, Object> delete(Integer id){
        Map<String, Object> result =  new HashMap<>();

        try {
            Optional<Patio> patio = repository.findById(id);

            if(!patio.isPresent()){
                result.put("success", false);
                result.put("message", "Nenhum resgistro de patio foi encontrado com essa identificação!");

                return result;
            }

            Timeline timeline = new Timeline();    
            timeline.setDescricao("Patio: " + patio.get().getId());
            timeline.setTipo("Deletar");
            repositoryTimeline.save(timeline);

            result.put("success", true);
            result.put("message", "Registro de patio excluido com sucesso!");

            repository.deleteById(id);

        } catch (Exception error) {
            result.put("success", false);
            result.put("message", error.getMessage());
        }

        return result;
    }
}