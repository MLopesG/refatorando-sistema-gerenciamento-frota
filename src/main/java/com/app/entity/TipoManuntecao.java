package com.app.entity;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tipo_manuntecao")
public class TipoManuntecao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descricao", nullable = true)
    @NotNull(message = "Campo obrigatório.")
    private String descricao;

    @Column(name = "intervalo_manuntencao", nullable = true)
    @NotNull(message = "Campo obrigatório.")
    private Integer intervaloManuntencao;

    @Column(name = "tipo_intervalo", nullable = true)
    @NotNull(message = "Campo obrigatório.")
    private String tipo_intervalo;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIntervaloManuntencao() {
        return intervaloManuntencao;
    }

    public void setIntervaloManuntencao(Integer intervaloManuntencao) {
        this.intervaloManuntencao = intervaloManuntencao;
    }

    public String getTipo_intervalo() {
        return tipo_intervalo;
    }

    public void setTipo_intervalo(String tipo_intervalo) {
        this.tipo_intervalo = tipo_intervalo;
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