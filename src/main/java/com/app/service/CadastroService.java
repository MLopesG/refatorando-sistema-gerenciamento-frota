package com.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.app.entity.Cadastro;
import com.app.entity.Timeline;
import com.app.repository.CadastroRepository;
import com.app.repository.TimelineRepository;

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
        List<Cadastro> registros = repository.findAll();
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

    public Map<String, Object> save(Cadastro cadastro){
        Map<String, Object> result =  new HashMap<>();

        try{
            Timeline timeline = new Timeline();
            timeline.setDescricao("Cadastro: " + cadastro.getNome());

            if(cadastro.getId() != null){
                timeline.setTipo("Alteração no Cadastro");
                result.put("message", "Cadastro alterada com sucesso!");

            }else{
                timeline.setTipo("Novo Cadastro");
                result.put("message", "Cadastro criado com sucesso!");
            }

            result.put("success", true);

            repositoryTimeline.save(timeline);
            repository.save(cadastro);

        }catch(Exception error){
            result.put("success", false);
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
                result.put("success", false);
                result.put("message", "Nenhum cadastro foi encontrado com essa identificação!");

                return result;
            }

            Timeline timeline = new Timeline();    
            timeline.setDescricao("Cadastro: " + cadastro.get().getNome());
            timeline.setTipo("Deletar Cadastro");
            repositoryTimeline.save(timeline);

            result.put("success", true);
            result.put("message", "Cadastro excluido com sucesso!");

            repository.deleteById(id);

        } catch (Exception error) {
            result.put("success", false);
            result.put("message", error.getMessage());
        }

        return result;
    }
}