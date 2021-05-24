package com.app.entity;


import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="produto")
public class Produto{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@NotNull(message = "Campo obrigatório.")
    @Column(name = "categoria", nullable = true)
	private String categoria;

	@NotNull(message = "Campo obrigatório.")
	@Column(name = "quantidade_restante", nullable = true)
	private Integer quantidadeRestante;
	
	@NotNull(message = "Campo obrigatório.")
	@Column(name = "descricao", nullable = true)
    private String descricao;
	
	@NotNull(message = "Campo obrigatório.")
    @Column(name = "valor", nullable = true)
    private Float valor;

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

	public Integer getQuantidadeRestante() {
		return this.quantidadeRestante;
	}

	public void setQuantidadeRestante(Integer quantidadeRestante) {
		this.quantidadeRestante = quantidadeRestante;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}