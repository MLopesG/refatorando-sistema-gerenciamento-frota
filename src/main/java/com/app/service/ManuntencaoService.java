package com.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.app.entity.Manuntencao;
import com.app.entity.Timeline;
import com.app.repository.ManuntencaoRepository;
import com.app.repository.TimelineRepository;

import org.springframework.stereotype.Service;

@Service
public class ManuntencaoService {
    
    ManuntencaoRepository repository;
    TimelineRepository repositoryTimeline;

    ManuntencaoService(ManuntencaoRepository repository, TimelineRepository repositoryTimeline){
        this.repository = repository;
        this.repositoryTimeline = repositoryTimeline;
    }

    public Map<String, Object> all(){
        List<Manuntencao> registros = repository.findAll();
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

    public Map<String, Object> save(Manuntencao manuntencao){
        Map<String, Object> result =  new HashMap<>();

        try{
            Timeline timeline = new Timeline();
            
            timeline.setDescricao("Manuntenção: " + manuntencao.getObservacao());

            if(manuntencao.getId() != null){
                timeline.setTipo("Alteração");
                result.put("message", "Manuntenção alterada com sucesso!");

            }else{
                timeline.setTipo("Novo");
                result.put("message", "Manuntenção resgistrado com sucesso!");
            }

            result.put("status", true);

            repositoryTimeline.save(timeline);
            repository.save(manuntencao);

        }catch(Exception error){
            result.put("status", false);
            result.put("message", error.getStackTrace());
        }
        
        return result;
    }

    public Manuntencao get(Integer id){
        return repository.findById(id).get();
    }

    public Map<String, Object> delete(Integer id){
        Map<String, Object> result =  new HashMap<>();

        try {
            Optional<Manuntencao> manuntencao = repository.findById(id);

            if(!manuntencao.isPresent()){
                result.put("status", false);
                result.put("message", "Nenhum registro de manunteção foi encontrado com essa identificação!");

                return result;
            }

            Timeline timeline = new Timeline();    
            timeline.setDescricao("Manuntenção: " + manuntencao.get().getObservacao());
            timeline.setTipo("Deletar");
            repositoryTimeline.save(timeline);

            result.put("status", true);
            result.put("message", "Manuntenção excluida com sucesso!");

            repository.deleteById(id);

        } catch (Exception error) {
            result.put("status", false);
            result.put("message", error.getMessage());
        }

        return result;
    }
}