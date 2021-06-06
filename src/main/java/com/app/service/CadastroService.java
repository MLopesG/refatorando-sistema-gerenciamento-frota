package com.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.app.entity.Cadastro;
import com.app.entity.Timeline;
import com.app.repository.CadastroRepository;
import com.app.repository.TimelineRepository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CadastroService {

    CadastroRepository repository;
    TimelineRepository repositoryTimeline;

    CadastroService(CadastroRepository cadastroRepository, TimelineRepository timelineRepository){
        this.repository = cadastroRepository;
        this.repositoryTimeline = timelineRepository;
    }

    public Map<String, Object> all(){
        List<Cadastro> registros = repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
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

    public Map<String, Object> save(Cadastro cadastro){

        Map<String, Object> result =  new HashMap<>();

        try{
            Timeline timeline = new Timeline();
            timeline.setDescricao("Cadastro: " + cadastro.getNome());

            if(cadastro.getId() != null){
                timeline.setTipo("Alteração");
                result.put("message", "Cadastro alterada com sucesso!");

            }else{
                timeline.setTipo("Novo");
                result.put("message", "Cadastro criado com sucesso!");
            }

            result.put("status", true);

            repositoryTimeline.save(timeline);
            repository.save(cadastro);

        }catch(Exception error){
            result.put("status", false);
            result.put("message", error.getStackTrace());
        }
        
        return result;
    }

	public Cadastro get(Integer id){
        return repository.findById(id).get();
    }

    public Map<String, Object> delete(Integer id){
        Map<String, Object> result =  new HashMap<>();

        try {
            Optional<Cadastro> cadastro = repository.findById(id);

            if(!cadastro.isPresent()){
                result.put("status", false);
                result.put("message", "Nenhum cadastro foi encontrado com essa identificação!");

                return result;
            }

            Timeline timeline = new Timeline();    
            timeline.setDescricao("Cadastro: " + cadastro.get().getNome());
            timeline.setTipo("Excluir");
            repositoryTimeline.save(timeline);

            result.put("status", true);
            result.put("message", "Cadastro excluido com sucesso!");

            repository.deleteById(id);

        } catch (Exception error) {
            result.put("status", false);
            result.put("message", error.getMessage());
        }

        return result;
    }
}