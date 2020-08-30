package com.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.app.entity.Produto;
import com.app.entity.Timeline;
import com.app.repository.ProdutoRepository;
import com.app.repository.TimelineRepository;

import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    
    ProdutoRepository repository;
    TimelineRepository repositoryTimeline;

    ProdutoService(ProdutoRepository produtoRepository, TimelineRepository timelineRepository){
        this.repository = produtoRepository;
        this.repositoryTimeline = timelineRepository;
    }

    public Map<String, Object> all(){
        List<Produto> registros = repository.findAll();
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

    public Map<String, Object> save(Produto produto){
        Map<String, Object> result =  new HashMap<>();

        try{
            Timeline timeline = new Timeline();
            
            timeline.setDescricao("Produto: " + produto.getDescricao());

            if(produto.getId() != null){
                timeline.setTipo("Alteração");
                result.put("message", "Produto alterado com sucesso!");
            }else{
                timeline.setTipo("Novo");
                result.put("message", "Produto criado com sucesso!");
            }

            result.put("success", true);

            repositoryTimeline.save(timeline);
            repository.save(produto);

        }catch(Exception error){
            result.put("success", false);
            result.put("message", error.getStackTrace());
        }
        
        return result;
    }

    public Produto get(Integer id){
        return repository.findById(id).get();
    }

    public Map<String, Object> delete(Integer id){
        Map<String, Object> result =  new HashMap<>();

        try {
            Optional<Produto> produto = repository.findById(id);

            if(!produto.isPresent()){
                result.put("success", false);
                result.put("message", "Nenhum produto foi encontrado com essa identificação!");

                return result;
            }

            Timeline timeline = new Timeline();    
            timeline.setDescricao("Produto: " + produto.get().getDescricao());
            timeline.setTipo("Deletar");
            repositoryTimeline.save(timeline);

            result.put("success", true);
            result.put("message", "Produto excluido com sucesso!");

            repository.deleteById(id);

        } catch (Exception error) {
            result.put("success", false);
            result.put("message", error.getMessage());
        }

        return result;
    }
}