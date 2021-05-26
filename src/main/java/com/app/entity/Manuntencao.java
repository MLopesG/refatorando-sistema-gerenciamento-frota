package com.app.entity;


import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "manuntencoes")
public class Manuntencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    @NotNull(message = "Campo obrigatório.")
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "cadastro_id")
    @NotNull(message = "Campo obrigatório.")
    private Cadastro cadastro;

    @ManyToOne
    @JoinColumn(name = "tipo_manuntencao_id")
    @NotNull(message = "Campo obrigatório.")
    private TipoManuntecao tipoManuntencao;

    @NotNull
    @Size(min = 2, message = "Campo obrigatório.")
    @Column(name = "tipo", nullable = true)
    private String tipo;

    @NotNull
    @Size(min = 2, message = "Campo obrigatório.")
    @Column(name = "proxima_manuntencao", nullable = true)
    private String proximaManuntencao;

    @Column(name = "observacao", nullable = true)
    private String observacao;
    
    @NotNull(message = "Campo obrigatório.")
    @Column(name = "quilometragem", nullable = true)
    private Float quilometragem;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    @Column(name = "created_at", insertable = false, updatable = false, nullable = true, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created_at;                  

    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    @Column(name = "modified_at",  insertable = false, updatable = false, nullable = true, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime modified_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cadastro getCadastro() {
        return cadastro;
    }

    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }

    public TipoManuntecao getTipoManuntencao() {
        return tipoManuntencao;
    }

    public void setTipoManuntencao(TipoManuntecao tipoManuntencao) {
        this.tipoManuntencao = tipoManuntencao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getProximaManuntencao() {
        return proximaManuntencao;
    }

    public void setProximaManuntencao(String proximaManuntencao) {
        this.proximaManuntencao = proximaManuntencao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Float getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Float quilometragem) {
        this.quilometragem = quilometragem;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getModified_at() {
        return modified_at;
    }

    public void setModified_at(LocalDateTime modified_at) {
        this.modified_at = modified_at;
    }    
}