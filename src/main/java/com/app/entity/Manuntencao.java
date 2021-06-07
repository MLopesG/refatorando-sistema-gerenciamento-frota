package com.app.entity;


import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "manuntencao")
public class Manuntencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "veiculo_id", insertable = false, updatable = false)
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "cadastro_id", insertable = false, updatable = false)
    private Cadastro cadastro;

    @Column(name = "cadastro_id", nullable = true)
    @NotNull(message = "Campo obrigatório.")
    private Integer cadastroId;

    @Column(name = "veiculo_id", nullable = true)
    @NotNull(message = "Campo obrigatório.")
    private Integer veiculoId;

    @Column(name = "veiculo_substituto_id", nullable = true)
    private Integer veiculoSubstitutoId;

    @ManyToOne
    @JoinColumn(name = "tipo_manuntencao_id", insertable = false, updatable = false)
    private TipoManuntecao tipoManuntencao;

    @NotNull
    @NotNull(message = "Campo obrigatório.")
    @Column(name = "tipo_manuntencao_id", nullable = true)
    private Integer tipoManuntencaoId;

    @NotNull
    @Size(min = 2, message = "Campo obrigatório.")
    @Column(name = "proxima_manuntencao", nullable = true)
    private String proximaManuntencao;

    @Column(name = "descricao", nullable = true)
    private String descricao;

    @Column(name = "observacao_geral", nullable = true)
    private String observacao_geral;

    @Column(name = "observacao_veiculo_substituto_nao_usado", nullable = true)
    private String observacao_veiculo_substituto_nao_usado;
    
    @NotNull(message = "Campo obrigatório.")
    @Column(name = "quilometragem", nullable = true)
    private Float quilometragem;

    @Column(name = "status", nullable = true)
    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    @Column(name = "created_at", insertable = false, updatable = false, nullable = true, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created_at;                  

    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    @Column(name = "modified_at",  insertable = false, updatable = false, nullable = true, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime modified_at;


    public Manuntencao() {
    }


    public Manuntencao(Integer id, Veiculo veiculo, Cadastro cadastro, Integer cadastroId, Integer veiculoId, Integer veiculoSubstitutoId, TipoManuntecao tipoManuntencao, Integer tipoManuntencaoId, String proximaManuntencao, String descricao, String observacao_geral, String observacao_veiculo_substituto_nao_usado, Float quilometragem, Status status, LocalDateTime created_at, LocalDateTime modified_at) {
        this.id = id;
        this.veiculo = veiculo;
        this.cadastro = cadastro;
        this.cadastroId = cadastroId;
        this.veiculoId = veiculoId;
        this.veiculoSubstitutoId = veiculoSubstitutoId;
        this.tipoManuntencao = tipoManuntencao;
        this.tipoManuntencaoId = tipoManuntencaoId;
        this.proximaManuntencao = proximaManuntencao;
        this.descricao = descricao;
        this.observacao_geral = observacao_geral;
        this.observacao_veiculo_substituto_nao_usado = observacao_veiculo_substituto_nao_usado;
        this.quilometragem = quilometragem;
        this.status = status;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cadastro getCadastro() {
        return this.cadastro;
    }

    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }

    public Integer getCadastroId() {
        return this.cadastroId;
    }

    public void setCadastroId(Integer cadastroId) {
        this.cadastroId = cadastroId;
    }

    public Integer getVeiculoId() {
        return this.veiculoId;
    }

    public void setVeiculoId(Integer veiculoId) {
        this.veiculoId = veiculoId;
    }

    public Integer getVeiculoSubstitutoId() {
        return this.veiculoSubstitutoId;
    }

    public void setVeiculoSubstitutoId(Integer veiculoSubstitutoId) {
        this.veiculoSubstitutoId = veiculoSubstitutoId;
    }

    public TipoManuntecao getTipoManuntencao() {
        return this.tipoManuntencao;
    }

    public void setTipoManuntencao(TipoManuntecao tipoManuntencao) {
        this.tipoManuntencao = tipoManuntencao;
    }

    public Integer getTipoManuntencaoId() {
        return this.tipoManuntencaoId;
    }

    public void setTipoManuntencaoId(Integer tipoManuntencaoId) {
        this.tipoManuntencaoId = tipoManuntencaoId;
    }

    public String getProximaManuntencao() {
        return this.proximaManuntencao;
    }

    public void setProximaManuntencao(String proximaManuntencao) {
        this.proximaManuntencao = proximaManuntencao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacao_geral() {
        return this.observacao_geral;
    }

    public void setObservacao_geral(String observacao_geral) {
        this.observacao_geral = observacao_geral;
    }

    public String getObservacao_veiculo_substituto_nao_usado() {
        return this.observacao_veiculo_substituto_nao_usado;
    }

    public void setObservacao_veiculo_substituto_nao_usado(String observacao_veiculo_substituto_nao_usado) {
        this.observacao_veiculo_substituto_nao_usado = observacao_veiculo_substituto_nao_usado;
    }

    public Float getQuilometragem() {
        return this.quilometragem;
    }

    public void setQuilometragem(Float quilometragem) {
        this.quilometragem = quilometragem;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getModified_at() {
        return this.modified_at;
    }

    public void setModified_at(LocalDateTime modified_at) {
        this.modified_at = modified_at;
    }
}