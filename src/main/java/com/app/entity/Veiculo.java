package com.app.entity;

import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "veiculo")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    @Column(name = "placa", nullable = true, unique = true)
    @NotNull(message = "Campo obrigatório.")
    private String placa;

    @Column(name = "ano", nullable = true)
    @NotNull(message = "Campo obrigatório.")
    private Integer ano;

    @Column(name = "categoria", nullable = true)
    @NotNull(message = "Campo obrigatório.")
    private String categoria;

    @Column(name = "combustivel", nullable = true)
    @NotNull(message = "Campo obrigatório.")
    private String combustivel;

    @Column(name = "modelo", nullable = true)
    @NotNull(message = "Campo obrigatório.")
    private String modelo;

    @Column(name = "descricao", nullable = true)
    @NotNull(message = "Campo obrigatório.")
    private String descricao;

    @Column(name = "setor", nullable = true)
    @NotNull(message = "Campo obrigatório.")
    private String setor;

    @Column(name = "disponivel", nullable = true, columnDefinition="BOOLEAN DEFAULT false")
    private Boolean disponivel;

    @Column(name = "indisponivel", nullable = true, columnDefinition="BOOLEAN DEFAULT false")
    private Boolean indisponivel;

    @Column(name = "manuntencao", nullable = true, columnDefinition="BOOLEAN DEFAULT false")
    private Boolean manuntencao;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    @Column(name = "created_at", insertable = false, updatable = false, nullable = true, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created_at;             

    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    @Column(name = "modified_at", insertable = false, updatable = false, nullable = true, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime modified_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Boolean getIndisponivel() {
        return indisponivel;
    }

    public void setIndisponivel(Boolean indisponivel) {
        this.indisponivel = indisponivel;
    }

    public Boolean getManuntencao() {
        return manuntencao;
    }

    public void setManuntencao(Boolean manuntencao) {
        this.manuntencao = manuntencao;
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