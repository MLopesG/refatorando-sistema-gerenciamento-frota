package com.app.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "cadastro")
public class Cadastro implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    @NotNull(message = "Campo obrigatório.")
    private Cargo cargo;

    @NotNull
    @Size(min = 2, message = "Campo obrigatório.")
    @Column(name = "nome", nullable = true)
    private String nome;

    @NotNull(message = "Campo obrigatório.")
    private Integer codigo;

    @NotNull
    @Size(min = 2, message = "Campo obrigatório.")
    @Column(name = "cnh", nullable = true)
    private String cnh;

    @NotNull
    @Size(min = 2, message = "Campo obrigatório.")
    private String cpf;

    @NotNull(message = "Campo obrigatório.")
    @Column(name = "endereco", nullable = true)
    private String endereco;
    
    @Column(name = "cep", nullable = true)
    private String cep;

    @NotNull(message = "Campo obrigatório.")
    @Column(name = "estado", nullable = true)
    private String estado;

    @NotNull(message = "Campo obrigatório.")
    @Column(name = "cidade", nullable = true)
    private String cidade;

    @NotNull(message = "Campo obrigatório.")
    @Column(name = "numero", nullable = true)
    private Integer numero;

    @Column(name = "complemento", nullable = true)
    private String complemento;

    @Column(name = "administrador", nullable = true, columnDefinition="BOOLEAN DEFAULT true")
    private boolean administrador;

    @Column(name = "motorista", nullable = true, columnDefinition="BOOLEAN DEFAULT false")
    private boolean motorista;

    @Column(name = "ativo", nullable = true, columnDefinition="BOOLEAN DEFAULT false")
    private boolean ativo;

    @NotNull
    @Size(min = 2, message = "Campo obrigatório.")
    @Column(name = "senha", nullable = true)
    private String senha;

    @Column(name = "created_at", insertable = false, updatable = false, nullable = true, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created;  

    @Column(name = "modified_at",  insertable = false, updatable = false, nullable = true, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime modified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public boolean isMotorista() {
        return motorista;
    }

    public void setMotorista(boolean motorista) {
        this.motorista = motorista;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public boolean getAtivo() {
        return this.ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}