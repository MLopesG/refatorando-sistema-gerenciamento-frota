package com.app.entity;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "retiradas_produto")
public class RetiradaProduto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "produto_id", insertable = false, updatable = false)
	private Produto produto;

	@Column(name = "produto_id", nullable = true)
	@NotNull(message = "Campo obrigatório.")
	private Integer produtoId;

	@ManyToOne
	@JoinColumn(name = "veiculo_id", insertable = false, updatable = false)
	private Veiculo veiculo;

	@Column(name = "veiculo_id", nullable = true)
	@NotNull(message = "Campo obrigatório.")
	private Integer veiculoId;

	@Column(name = "quantidade", nullable = true)
	@NotNull(message = "Campo obrigatório.")
	private Integer quantidade;

	@Column(name = "total", nullable = true)
	@NotNull(message = "Campo obrigatório.")
	private Float total;

	@Column(name = "observacao", nullable = true)
	@NotNull(message = "Campo obrigatório.")
	private String observacao;

	@Column(name = "status", nullable = true)
	@NotNull(message = "Campo obrigatório.")
	private String status;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "created_at", insertable = false, updatable = false, nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime created_at;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "modified_at", insertable = false, updatable = false, nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime modified_at;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getProdutoId() {
		return this.produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

	public Veiculo getVeiculo() {
		return this.veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Integer getVeiculoId() {
		return this.veiculoId;
	}

	public void setVeiculoId(Integer veiculoId) {
		this.veiculoId = veiculoId;
	}

	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Float getTotal() {
		return this.total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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