package br.ma.slz.pedroazevedo.mateus.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;

import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name="produtos")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(name="codigo_de_barras", unique = true, nullable = false)
	private String codigoDeBarras;
	
	@DecimalMin(value = "0,00")
	@NumberFormat(pattern = "#.##0,00") // Formato Brasileiro
    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

	public Long getId() {
		return id;
	}

	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
