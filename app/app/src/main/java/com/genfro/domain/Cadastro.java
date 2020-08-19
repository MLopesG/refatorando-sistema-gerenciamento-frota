package com.genfro.domain;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "cadastros")
public class Cadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "codigo", nullable = false, unique = true)
    private Integer codigo;

    @Column(name = "cnh", nullable = false)
    private String cnh;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "foto_perfil", nullable = false)
    private String foto_perfil;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "numero", nullable = false)
    private Integer numero;

    @Column(name = "complemento", nullable = false)
    private String complemento;

    @Column(name = "administrador", nullable = false)
    private boolean administrador;

    @Column(name = "motorista", nullable = false)
    private boolean motorista;

    @Column(name = "senha", nullable = false, length = 20)
    private String senha;

    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @Column(name = "modified", nullable = false)
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

    public String getFoto_perfil() {
        return foto_perfil;
    }

    public void setFoto_perfil(String foto_perfil) {
        this.foto_perfil = foto_perfil;
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

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}