package br.com.trabalho.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;

	@Column(name = "nome_produto", nullable = false, length = 100)
	private String nomeProduto;

	@Column(name = "descricao_produto", nullable = false, length = 300)
	private String descricaoProduto;

	@Column
	private LocalDate dtFabricacao;

	@Column
	private Double vlUnitario;

	@Column
	private Double vlCusto;

	@Column
	private Integer qtEstoque;

	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public LocalDate getDtFabricacao() {
		return dtFabricacao;
	}

	public void setDtFabricacao(LocalDate dtFabricacao) {
		this.dtFabricacao = dtFabricacao;
	}

	public Double getVlUnitario() {
		return vlUnitario;
	}

	public void setVlUnitario(Double vlUnitario) {
		this.vlUnitario = vlUnitario;
	}

	public Double getVlCusto() {
		return vlCusto;
	}

	public void setVlCusto(Double vlCusto) {
		this.vlCusto = vlCusto;
	}

	public Integer getQtEstoque() {
		return qtEstoque;
	}

	public void setQtEstoque(Integer qtEstoque) {
		this.qtEstoque = qtEstoque;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	

}