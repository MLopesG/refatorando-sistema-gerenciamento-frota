package com.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.app.entity.Cargo;
import com.app.entity.Timeline;
import com.app.repository.CargoRepository;
import com.app.repository.TimelineRepository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CargoService {
    
    CargoRepository repository;
    TimelineRepository repositoryTimeline;

    CargoService(CargoRepository cargoRepository, TimelineRepository timelineRepository){
        this.repository = cargoRepository;
        this.repositoryTimeline = timelineRepository;
    }

    public Map<String, Object> all(){
        List<Cargo> registros = repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
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

    public Map<String, Object> save(Cargo cargo){
        Map<String, Object> result =  new HashMap<>();

        try{
            Timeline timeline = new Timeline();
            
            timeline.setDescricao("Cargo: " + cargo.getDescricao());

            if(cargo.getId() != null){
                timeline.setTipo("Alteração");
                result.put("message", "Cargo alterado com sucesso!");

            }else{
                timeline.setTipo("Novo");
                result.put("message", "Cargo criado com sucesso!");
            }

            result.put("status", true);

            repositoryTimeline.save(timeline);
            repository.save(cargo);

        }catch(Exception error){
            result.put("status", false);
            result.put("message", error.getStackTrace());
        }
        
        return result;
    }

    public Cargo get(Integer id){
        return repository.findById(id).get();
    }

    public Map<String, Object> delete(Integer id){
        Map<String, Object> result =  new HashMap<>();

        try {
            Optional<Cargo> cargo = repository.findById(id);

            if(!cargo.isPresent()){
                result.put("status", false);
                result.put("message", "Nenhum cargo foi encontrado com essa identificação!");

                return result;
            }

            Timeline timeline = new Timeline();    
            timeline.setDescricao("Cargo: " + cargo.get().getDescricao());
            timeline.setTipo("Deletar");
            repositoryTimeline.save(timeline);

            result.put("status", true);
            result.put("message", "Cargo excluido com sucesso!");

            repository.deleteById(id);

        } catch (Exception error) {
            result.put("status", false);
            result.put("message", error.getMessage());
        }

        return result;
    }
}