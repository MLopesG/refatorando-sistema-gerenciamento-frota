package com.app.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.app.entity.Cargo;
import com.app.entity.Timeline;
import com.app.repository.CargoRepository;
import com.app.repository.TimelineRepository;

import org.springframework.stereotype.Service;

@Service
public class CargoService {
    
    CargoRepository repository;
    TimelineRepository repositoryTimeline;

    CargoService(CargoRepository cargoRepository, TimelineRepository timelineRepository){
        this.repository = cargoRepository;
        this.repositoryTimeline = timelineRepository;
    }

    public List<Cargo> all(){
        return repository.findAll();
    }

    public Map<String, Object> save(Cargo cargo){
        Map<String, Object> result =  new HashMap<>();

        try{
            Timeline timeline = new Timeline();
            
            timeline.setDescricao("Cargo: " + cargo.getDescricao());

            if(cargo.getId() != null){
                timeline.setTipo("Alteração no cargo");
                result.put("message", "Cargo alterada com sucesso!");

            }else{
                timeline.setTipo("Novo Cadastro");
                result.put("message", "Cargo criado com sucesso!");
            }

            result.put("success", true);

            repositoryTimeline.save(timeline);
            repository.save(cargo);

        }catch(Exception error){
            result.put("success", false);
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
                result.put("success", false);
                result.put("message", "Nenhum cargo foi encontrado com essa identificação!");

                return result;
            }

            Timeline timeline = new Timeline();    
            timeline.setDescricao("Cargo: " + cargo.get().getDescricao());
            timeline.setTipo("Novo Cadastro");
            repositoryTimeline.save(timeline);

            result.put("success", true);
            result.put("message", "Cargo excluido com sucesso!");

            repository.deleteById(id);

        } catch (Exception error) {
            result.put("success", false);
            result.put("message", error.getMessage());
        }

        return result;
    }
}