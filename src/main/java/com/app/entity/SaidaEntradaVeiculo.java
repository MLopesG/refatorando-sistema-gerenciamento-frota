package com.app.entity;


import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="saida_entrada_veiculo")
public class SaidaEntradaVeiculo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    @NotNull(message = "Campo obrigatório.")
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "veiculo_substituto_id")
    @NotNull(message = "Campo obrigatório.")
    private Veiculo veiculoSub;
    
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

    public Veiculo getVeiculoSub() {
        return veiculoSub;
    }

    public void setVeiculoSub(Veiculo veiculoSub) {
        this.veiculoSub = veiculoSub;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public Float getKm_entrada() {
        return km_entrada;
    }

    public void setKm_entrada(Float km_entrada) {
        this.km_entrada = km_entrada;
    }

    public Float getKm_saida() {
        return km_saida;
    }

    public void setKm_saida(Float km_saida) {
        this.km_saida = km_saida;
    }

    public Float getKm_diferenca() {
        return km_diferenca;
    }

    public void setKm_diferenca(Float km_diferenca) {
        this.km_diferenca = km_diferenca;
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