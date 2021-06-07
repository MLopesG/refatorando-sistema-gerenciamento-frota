package com.app.entity;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "saida_entrada_veiculo")
public class SaidaEntradaVeiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "veiculo_id", insertable = false, updatable = false)
    private Veiculo veiculo;

    @Column(name = "veiculo_id", nullable = true)
    @NotNull(message = "Campo obrigatório.")
    private Integer veiculoId;

    @Column(name = "saida", nullable = true)
    @NotNull(message = "Campo obrigatório.")
    private LocalDateTime saida;

    @Column(name = "entrada", nullable = true)
    @NotNull(message = "Campo obrigatório.")
    private LocalDateTime entrada;

    @Column(name = "justificativa", nullable = true)
    @NotNull(message = "Campo obrigatório.")
    private String justificativa;

    @Column(name = "km_entrada", nullable = true)
    @NotNull(message = "Campo obrigatório.")
    private Float km_entrada;

    @Column(name = "km_saida", nullable = true)
    @NotNull(message = "Campo obrigatório.")
    private Float km_saida;

    @Column(name = "km_diferenca", nullable = true)
    @NotNull(message = "Campo obrigatório.")
    private Float km_diferenca;

    @Column(name = "status", nullable = true)
    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "created_at", insertable = false, updatable = false, nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created_at;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "modified_at", insertable = false, updatable = false, nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime modified_at;

    public SaidaEntradaVeiculo() {
    }

    public SaidaEntradaVeiculo(Integer id, Veiculo veiculo, Integer veiculoId, LocalDateTime saida, LocalDateTime entrada, String justificativa, Float km_entrada, Float km_saida, Float km_diferenca, Status status, LocalDateTime created_at, LocalDateTime modified_at) {
        this.id = id;
        this.veiculo = veiculo;
        this.veiculoId = veiculoId;
        this.saida = saida;
        this.entrada = entrada;
        this.justificativa = justificativa;
        this.km_entrada = km_entrada;
        this.km_saida = km_saida;
        this.km_diferenca = km_diferenca;
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

    public Integer getVeiculoId() {
        return this.veiculoId;
    }

    public void setVeiculoId(Integer veiculoId) {
        this.veiculoId = veiculoId;
    }

    public LocalDateTime getSaida() {
        return this.saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public LocalDateTime getEntrada() {
        return this.entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public String getJustificativa() {
        return this.justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public Float getKm_entrada() {
        return this.km_entrada;
    }

    public void setKm_entrada(Float km_entrada) {
        this.km_entrada = km_entrada;
    }

    public Float getKm_saida() {
        return this.km_saida;
    }

    public void setKm_saida(Float km_saida) {
        this.km_saida = km_saida;
    }

    public Float getKm_diferenca() {
        return this.km_diferenca;
    }

    public void setKm_diferenca(Float km_diferenca) {
        this.km_diferenca = km_diferenca;
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