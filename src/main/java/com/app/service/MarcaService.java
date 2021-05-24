package com.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.app.entity.Marca;
import com.app.entity.Timeline;
import com.app.repository.MarcaRepository;
import com.app.repository.TimelineRepository;

import org.springframework.stereotype.Service;

@Service
public class MarcaService {
    
    MarcaRepository repository;
    TimelineRepository repositoryTimeline;

    MarcaService(MarcaRepository repository, TimelineRepository repositoryTimeline){
        this.repository = repository;
        this.repositoryTimeline = repositoryTimeline;
    }

    public Map<String, Object> all(){
        List<Marca> registros = repository.findAll();
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

    public Map<String, Object> save(Marca marca){
        Map<String, Object> result =  new HashMap<>();

        try{
            Timeline timeline = new Timeline();
            
            timeline.setDescricao("Marca: " + marca.getDescricao());

            if(marca.getId() != null){
                timeline.setTipo("Alteração");
                result.put("message", "Marca alterado com sucesso!");

            }else{
                timeline.setTipo("Novo");
                result.put("message", "Marca criada com sucesso!");
            }

            result.put("status", true);

            repositoryTimeline.save(timeline);
            repository.save(marca);

        }catch(Exception error){
            result.put("status", false);
            result.put("message", error.getStackTrace());
        }
        
        return result;
    }

    public Marca get(Integer id){
        return repository.findById(id).get();
    }

    public Map<String, Object> delete(Integer id){
        Map<String, Object> result =  new HashMap<>();

        try {
            Optional<Marca> marca = repository.findById(id);

            if(!marca.isPresent()){
                result.put("status", false);
                result.put("message", "Nenhuma marca foi encontrada com essa identificação!");

                return result;
            }

            Timeline timeline = new Timeline();    
            timeline.setDescricao("Marca: " + marca.get().getDescricao());
            timeline.setTipo("Deletar");
            repositoryTimeline.save(timeline);

            result.put("status", true);
            result.put("message", "Marca excluida com sucesso!");

            repository.deleteById(id);

        } catch (Exception error) {
            result.put("status", false);
            result.put("message", error.getMessage());
        }

        return result;
    }
}