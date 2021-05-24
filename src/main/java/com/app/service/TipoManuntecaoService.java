package com.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.app.entity.TipoManuntecao;
import com.app.entity.Timeline;
import com.app.repository.TipoManuntecaoRepository;
import com.app.repository.TimelineRepository;

import org.springframework.stereotype.Service;

@Service
public class TipoManuntecaoService {
    
    TipoManuntecaoRepository repository;
    TimelineRepository repositoryTimeline;

    TipoManuntecaoService(TipoManuntecaoRepository repository, TimelineRepository repositoryTimeline){
        this.repository = repository;
        this.repositoryTimeline = repositoryTimeline;
    }

    public Map<String, Object> all(){
        List<TipoManuntecao> registros = repository.findAll();
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

    public Map<String, Object> save(TipoManuntecao tipo){
        Map<String, Object> result =  new HashMap<>();

        try{
            Timeline timeline = new Timeline();
            
            timeline.setDescricao("Tipo Manuntenção: " + tipo.getDescricao());

            if(tipo.getId() != null){
                timeline.setTipo("Alteração");
                result.put("message", "Tipo de manuntenção alterada com sucesso!");

            }else{
                timeline.setTipo("Novo");
                result.put("message", "Novo tipo de manuntenção foi criada com sucesso!");
            }

            result.put("status", true);

            repositoryTimeline.save(timeline);
            repository.save(tipo);

        }catch(Exception error){
            result.put("status", false);
            result.put("message", error.getStackTrace());
        }
        
        return result;
    }

    public TipoManuntecao get(Integer id){
        return repository.findById(id).get();
    }

    public Map<String, Object> delete(Integer id){
        Map<String, Object> result =  new HashMap<>();

        try {
            Optional<TipoManuntecao> tipo = repository.findById(id);

            if(!tipo.isPresent()){
                result.put("status", false);
                result.put("message", "Nenhum tipo de manunteção foi encontrado com essa identificação!");

                return result;
            }

            Timeline timeline = new Timeline();    
            timeline.setDescricao("Tipo Manuntenção: " + tipo.get().getDescricao());
            timeline.setTipo("Deletar");
            repositoryTimeline.save(timeline);

            result.put("status", true);
            result.put("message", "Tipo de manuntenção foi excluida com sucesso!");

            repository.deleteById(id);

        } catch (Exception error) {
            result.put("status", false);
            result.put("message", error.getMessage());
        }

        return result;
    }
}