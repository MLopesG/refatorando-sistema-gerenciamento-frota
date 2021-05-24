package com.app.entity;

import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    @Column(name = "created_at", insertable = false, updatable = false, nullable = true, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created;             

    @Column(name = "modified_at", insertable = false, updatable = false, nullable = true, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime modified;

    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(final String placa) {
        this.placa = placa;
    }

    public Integer getAno() {
        return this.ano;
    }

    public void setAno(final Integer ano) {
        this.ano = ano;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(final String categoria) {
        this.categoria = categoria;
    }

    public String getCombustivel() {
        return this.combustivel;
    }

    public void setCombustivel(final String combustivel) {
        this.combustivel = combustivel;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(final String modelo) {
        this.modelo = modelo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    public String getSetor() {
        return this.setor;
    }

    public void setSetor(final String setor) {
        this.setor = setor;
    }

    public Boolean isDisponivel() {
        return this.disponivel;
    }

    public Boolean getDisponivel() {
        return this.disponivel;
    }

    public void setDisponivel(final Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Boolean isIndisponivel() {
        return this.indisponivel;
    }

    public Boolean getIndisponivel() {
        return this.indisponivel;
    }

    public void setIndisponivel(final Boolean indisponivel) {
        this.indisponivel = indisponivel;
    }

    public Boolean isManuntencao() {
        return this.manuntencao;
    }

    public Boolean getManuntencao() {
        return this.manuntencao;
    }

    public void setManuntencao(final Boolean manuntencao) {
        this.manuntencao = manuntencao;
    }

    public LocalDateTime getCreated() {
        return this.created;
    }

    public void setCreated(final LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return this.modified;
    }

    public void setModified(final LocalDateTime modified) {
        this.modified = modified;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(final Marca marca) {
        this.marca = marca;
    }
}