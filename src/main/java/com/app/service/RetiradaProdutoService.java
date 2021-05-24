package com.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.app.entity.RetiradaProduto;
import com.app.entity.Produto;
import com.app.entity.Timeline;
import com.app.repository.RetiradaProdutoRepository;
import com.app.repository.ProdutoRepository;
import com.app.repository.TimelineRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RetiradaProdutoService {
    
    RetiradaProdutoRepository repository;
    ProdutoRepository repositoryProduto;
    TimelineRepository repositoryTimeline;

    RetiradaProdutoService(RetiradaProdutoRepository repository, TimelineRepository timelineRepository, ProdutoRepository produtoRepository){
        this.repository =  repository;
        this.repositoryTimeline = timelineRepository;
        this.repositoryProduto = produtoRepository;
    }

    public Map<String, Object> all(){
        List<RetiradaProduto> registros = repository.findAll();
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

    @Transactional
    public Map<String, Object> save(RetiradaProduto retiradaProduto){
        Map<String, Object> result =  new HashMap<>();

        try{
             /// Pesquisar produto e retornar valores retirados
             Optional<Produto> produto = repositoryProduto.findById(retiradaProduto.getProduto().getId());
             Produto produtoEdit = produto.get();
           
             /// Calculos de retirada de produtos
             Integer calcularRetiradaProduto = (produtoEdit.getQuantidadeRestante() - retiradaProduto.getQuantidade());
             Float calcularTotal  = (produtoEdit.getValor() + retiradaProduto.getTotal());
             Float calcularTotalRetirada = (retiradaProduto.getQuantidade() * produtoEdit.getValor()); 
            
             /// Atualizar Produto
             produtoEdit.setQuantidadeRestante(calcularRetiradaProduto);
             produtoEdit.setValor(calcularTotal);
             repositoryProduto.save(produtoEdit);
            
             /// Salvar retirada
             retiradaProduto.setStatus("Concluido");
             retiradaProduto.setTotal(calcularTotalRetirada);
             repository.save(retiradaProduto);

             /// Salvar Timeline
            Timeline timeline = new Timeline();
            timeline.setDescricao("Nova Retirada: " + retiradaProduto.getId());

            if(retiradaProduto.getId() != null){
                timeline.setTipo("Alteração");
                result.put("message", "Retirada foi alterada com sucesso!");
            }else{
                timeline.setTipo("Novo");
                result.put("message", "Registrada com sucesso!");
            }

            repositoryTimeline.save(timeline);

            // Retornar result
            result.put("status", true);

        }catch(Exception error){
            result.put("status", false);
            result.put("message", error.getStackTrace());
        }
        
        return result;
    }

    public RetiradaProduto get(Integer id){
        return repository.findById(id).get();
    }

    @Transactional
    public Map<String, Object> delete(Integer id){
        Map<String, Object> result =  new HashMap<>();

        try {
            Optional<RetiradaProduto> retirada = repository.findById(id);
            RetiradaProduto retiradaProduto = retirada.get();

            if(!retirada.isPresent()){
                result.put("status", false);
                result.put("message", "Nenhuma retirada foi encontrado com essa identificação!");

                return result;
            }
            /// Pesquisar produto e retornar valores retirados
            Optional<Produto> produto = repositoryProduto.findById(retiradaProduto.getProduto().getId());
            Produto produtoEdit = produto.get();

            /// Calculos de retiradas de produtos
            Integer calcularRetiradaProduto = (produtoEdit.getQuantidadeRestante() + retiradaProduto.getQuantidade());
            Float calcularTotal  = (produtoEdit.getValor() - retiradaProduto.getTotal());
            
            /// Atualizar Produto
            produtoEdit.setQuantidadeRestante(calcularRetiradaProduto);
            produtoEdit.setValor(calcularTotal);
            repositoryProduto.save(produtoEdit);

            /// Atualizar Status para cancelado
            retiradaProduto.setStatus("Cancelado");
            repository.save(retiradaProduto);
            
            /// Salvar Timeline
            Timeline timeline = new Timeline();    
            timeline.setDescricao("Cancelamento de Retirada: " + retiradaProduto.getId());
            timeline.setTipo("Cancelamento");
            repositoryTimeline.save(timeline);

            // Retornar result
            result.put("status", true);
            result.put("message", "Retirada de produto cancelado com sucesso!");

        } catch (Exception error) {
            result.put("status", false);
            result.put("message", error.getMessage());
        }

        return result;
    }
}