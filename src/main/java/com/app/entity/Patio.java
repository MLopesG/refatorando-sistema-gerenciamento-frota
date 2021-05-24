package com.app.entity;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "patio")
public class Patio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    @NotNull(message = "Campo obrigatório.")
    private Veiculo veiculo;

    @NotNull(message = "Campo obrigatório.")
    @Column(name = "justificativa", nullable = true)
    private String justificativa;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_at", insertable = false, updatable = false, nullable = true, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created_at;          

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
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

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public LocalDateTime getCreated() {
        return created_at;
    }

    public void setCreated(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getModified() {
        return modified_at;
    }

    public void setModified(LocalDateTime modified_at) {
        this.modified_at = modified_at;
    }
}