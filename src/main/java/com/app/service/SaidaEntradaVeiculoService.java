package com.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.app.entity.SaidaEntradaVeiculo;
import com.app.entity.Timeline;
import com.app.repository.SaidaEntradaVeiculoRepository;
import com.app.repository.TimelineRepository;

import org.springframework.stereotype.Service;

@Service
public class SaidaEntradaVeiculoService {
    
    SaidaEntradaVeiculoRepository repository;
    TimelineRepository repositoryTimeline;

    SaidaEntradaVeiculoService(SaidaEntradaVeiculoRepository repository, TimelineRepository repositoryTimeline){
        this.repository = repository;
        this.repositoryTimeline = repositoryTimeline;
    }

    public Map<String, Object> all(){
        List<SaidaEntradaVeiculo> registros = repository.findAll();
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

    public Map<String, Object> save(SaidaEntradaVeiculo registro){
        Map<String, Object> result =  new HashMap<>();

        try{
            Timeline timeline = new Timeline();
            
            timeline.setDescricao("Resgistro: " + registro.getId());

            if(registro.getId() != null){
                timeline.setTipo("Alteração");
                result.put("message", "Saida/entrada de veiculo foi alterada com sucesso!");

            }else{
                timeline.setTipo("Novo");
                result.put("message", "Saida/entrada de veiculo registrada com sucesso!");
            }

            result.put("status", true);

            repositoryTimeline.save(timeline);
            repository.save(registro);

        }catch(Exception error){
            result.put("status", false);
            result.put("message", error.getStackTrace());
        }
        
        return result;
    }

    public SaidaEntradaVeiculo get(Integer id){
        return repository.findById(id).get();
    }

    public Map<String, Object> delete(Integer id){
        Map<String, Object> result =  new HashMap<>();

        try {
            Optional<SaidaEntradaVeiculo> entradaSaida = repository.findById(id);

            if(!entradaSaida.isPresent()){
                result.put("status", false);
                result.put("message", "Nenhuma Saida/entrada de veiculo foi encontrada com essa identificação!");

                return result;
            }

            Timeline timeline = new Timeline();    
            timeline.setDescricao("Entrada: " + entradaSaida.get().getId());
            timeline.setTipo("Deletar");
            repositoryTimeline.save(timeline);

            result.put("status", true);
            result.put("message", "Saida/entrada de veiculo excluida com sucesso!");

            repository.deleteById(id);

        } catch (Exception error) {
            result.put("status", false);
            result.put("message", error.getMessage());
        }

        return result;
    }
}