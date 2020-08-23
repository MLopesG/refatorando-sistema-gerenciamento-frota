package com.app.entity;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name="retiradas_produtos")
public class RetiradaProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="estoque_id")
    private Estoque estoque; 

    @ManyToOne
    @JoinColumn(name="veiculo_id")
    private Veiculo veiculo;

    @Column(name = "quantidade", nullable = true)
    private String quantidade;

    @Column(name = "total", nullable = true)
    private DecimalFormat total;

    @Column(name="observacao", nullable = true)
    private String observacao;

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

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public DecimalFormat getTotal() {
		return total;
	}

	public void setTotal(DecimalFormat total) {
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
}