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
    @JoinColumn(name = "marca_id",  insertable = false, updatable = false)
    private Marca marca;

    @Column(name = "marca_id", nullable = true, unique = true)
    @NotNull(message = "Campo obrigatório.")
    private Integer marcaId;

    @Column(name = "placa", nullable = true, unique = true)
    @NotNull(message = "Campo obrigatório.")
    private String placa;

    @Column(name = "qtd_lugares", nullable = true, unique = true)
    @NotNull(message = "Campo obrigatório.")
    private String qtdLugares;

    @Column(name = "ano", nullable = true)
    @NotNull(message = "Campo obrigatório.")
    private Integer ano;

    @Column(name = "categoria", nullable = true)
    @NotNull(message = "Campo obrigatório.")
    private CategoriaVeiculo categoria;

    @Column(name = "modelo", nullable = true)
    @NotNull(message = "Campo obrigatório.")
    private String modelo;

    @Column(name = "descricao", nullable = true)
    @NotNull(message = "Campo obrigatório.")
    private String descricao;

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
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Marca getMarca() {
        return this.marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Integer getMarcaId() {
        return this.marcaId;
    }

    public void setMarcaId(Integer marcaId) {
        this.marcaId = marcaId;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getQtdLugares() {
        return this.qtdLugares;
    }

    public void setQtdLugares(String qtdLugares) {
        this.qtdLugares = qtdLugares;
    }

    public Integer getAno() {
        return this.ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public CategoriaVeiculo getCategoria() {
        return this.categoria;
    }

    public void setCategoria(CategoriaVeiculo categoria) {
        this.categoria = categoria;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean isDisponivel() {
        return this.disponivel;
    }

    public Boolean getDisponivel() {
        return this.disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Boolean isIndisponivel() {
        return this.indisponivel;
    }

    public Boolean getIndisponivel() {
        return this.indisponivel;
    }

    public void setIndisponivel(Boolean indisponivel) {
        this.indisponivel = indisponivel;
    }

    public Boolean isManuntencao() {
        return this.manuntencao;
    }

    public Boolean getManuntencao() {
        return this.manuntencao;
    }

    public void setManuntencao(Boolean manuntencao) {
        this.manuntencao = manuntencao;
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