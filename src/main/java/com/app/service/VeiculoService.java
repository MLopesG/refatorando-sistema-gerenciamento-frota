package com.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.app.entity.Veiculo;
import com.app.entity.Timeline;
import com.app.repository.VeiculoRepository;
import com.app.repository.TimelineRepository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {
    
    VeiculoRepository repository;
    TimelineRepository repositoryTimeline;

    VeiculoService(VeiculoRepository repository, TimelineRepository repositoryTimeline){
        this.repository = repository;
        this.repositoryTimeline = repositoryTimeline;
    }

    public Map<String, Object> all(){
        List<Veiculo> registros = repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
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

    public Map<String, Object> save(Veiculo veiculo){
        Map<String, Object> result =  new HashMap<>();

        try{
            Timeline timeline = new Timeline();
            
            timeline.setDescricao("Veiculo: " + veiculo.getDescricao());

            if(veiculo.getId() != null){
                timeline.setTipo("Alteração");
                result.put("message", "Veiculo alterado com sucesso!");

            }else{
                timeline.setTipo("Novo");
                result.put("message", "Veiculo criada com sucesso!");
            }

            result.put("status", true);

            repositoryTimeline.save(timeline);
            repository.save(veiculo);

        }catch(Exception error){
            result.put("status", false);
            result.put("message", error.getStackTrace());
        }
        
        return result;
    }

    public Veiculo get(Integer id){
        return repository.findById(id).get();
    }

    public Map<String, Object> delete(Integer id){
        Map<String, Object> result =  new HashMap<>();

        try {
            Optional<Veiculo> veiculo = repository.findById(id);

            if(!veiculo.isPresent()){
                result.put("status", false);
                result.put("message", "Nenhum veiculo foi encontrado com essa identificação!");

                return result;
            }

            Timeline timeline = new Timeline();    
            timeline.setDescricao("Veiculo: " + veiculo.get().getPlaca());
            timeline.setTipo("Deletar");
            repositoryTimeline.save(timeline);

            result.put("status", true);
            result.put("message", "Veiculo excluido com sucesso!");

            repository.deleteById(id);

        } catch (Exception error) {
            result.put("status", false);
            result.put("message", error.getMessage());
        }

        return result;
    }
}