package com.app.entity;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="retiradas_produto")
public class RetiradaProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="produto_id")
	@NotNull(message = "Campo obrigatório.")
    private Produto produto; 

    @ManyToOne
    @JoinColumn(name="veiculo_id")
	@NotNull(message = "Campo obrigatório.")
    private Veiculo veiculo;

    @Column(name = "quantidade", nullable = true)
	@NotNull(message = "Campo obrigatório.")
    private Integer quantidade;

    @Column(name = "total", nullable = true)
	@NotNull(message = "Campo obrigatório.")
    private Float total;

    @Column(name="observacao", nullable = true)
	@NotNull(message = "Campo obrigatório.")
	private String observacao;
	
	@Column(name="status", nullable = true)
	@NotNull(message = "Campo obrigatório.")
    private String status;

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

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

	public Produto getEstoque() {
		return produto;
	}

	public void setEstoque(Produto produto) {
		this.produto = produto;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
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

	public String isStatus() {
		return this.status;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}