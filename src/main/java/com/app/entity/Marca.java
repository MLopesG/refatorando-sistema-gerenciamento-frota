package com.app.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "marcas")
public class Marca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "site", nullable = false, unique = true)
	private String site;

	@Column(name = "created", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime created;

	@Column(name = "modified", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime modified;

	public LocalDateTime getCreated() {
		return this.created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getModified() {
		return this.modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSite() {
		return this.site;
	}

	public void setSite(String site) {
		this.site = site;
	}
}