package com.app.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "tipo_manuntecao")
public class TipoManuntecao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descricao", nullable = true)
    private String descricao;

    @Column(name = "intervalo_manuntencao", nullable = true)
    private Integer intervaloManuntencao;

    @Column(name = "tipo_intervalo", nullable = true)
    private String tipo_intervalo;

    @Column(name = "created", insertable = false, updatable = false, nullable = true, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created;   

    @Column(name = "modified",  insertable = false, updatable = false, nullable = true, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime modified;

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
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}