package com.app.entity;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name="estoque")
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="produto_id")
    private Produto produto;

    @Column(name = "total", nullable = false)
    private DecimalFormat total;

    @Column(name = "quantidade", nullable = false)
    private DecimalFormat quantidade;

    @Column(name = "created", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime created;               
	                 
    @Column(name = "modified", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime modified;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public DecimalFormat getTotal() {
		return total;
	}

	public void setTotal(DecimalFormat total) {
		this.total = total;
	}

	public DecimalFormat getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(DecimalFormat quantidade) {
		this.quantidade = quantidade;
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