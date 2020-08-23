package com.app.entity;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "manuntencoes")
public class Manuntencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "cadastro_id")
    private Cadastro cadastro;

    @ManyToOne
    @JoinColumn(name = "tipo_manuntencao_id")
    private TipoManuntecao tipoManuntencao;

    @Column(name = "tipo", nullable = true)
    private String tipo;

    @Column(name = "proxima_manuntencao", nullable = true)
    private String proximaManuntencao;

    @Column(name = "observacao", nullable = true)
    private String observacao;

    @Column(name = "quilometragem", nullable = true)
    private DecimalFormat quilometragem;

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

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public TipoManuntecao getTipoManuntencao() {
        return tipoManuntencao;
    }

    public void setTipoManuntencao(TipoManuntecao tipoManuntencao) {
        this.tipoManuntencao = tipoManuntencao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getProximaManuntencao() {
        return proximaManuntencao;
    }

    public void setProximaManuntencao(String proximaManuntencao) {
        this.proximaManuntencao = proximaManuntencao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public DecimalFormat getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(DecimalFormat quilometragem) {
        this.quilometragem = quilometragem;
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

    public Cadastro getCadastro() {
        return cadastro;
    }

    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }
}