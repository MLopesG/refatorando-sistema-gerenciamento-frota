package com.app.entity;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "marca")
public class Marca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
		
	@NotNull(message = "Campo obrigatório.")
	@Column(name = "descricao", nullable = true)
	private String descricao;

	@Column(name = "site", nullable = true, unique = true)
	private String site;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "created_at", insertable = false, updatable = false, nullable = true, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime created_at;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "modified_at",  insertable = false, updatable = false, nullable = true, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime modified_at;

	public LocalDateTime getCreated() {
		return this.created_at;
	}

	public void setCreated(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getModified() {
		return this.modified_at;
	}

	public void setModified(LocalDateTime modified_at) {
		this.modified_at = modified_at;
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