package br.com.trabalho.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.trabalho.model.Produto;

public class ProdutoDTO {
	
	
	private String nomeProduto;
	private String descricao;
	private LocalDate dtFabricacao;
	private BigDecimal vlProduto;
	private Integer qtEstoque;
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getDtFabricacao() {
		return dtFabricacao;
	}
	public void setDtFabricacao(LocalDate dtFabricacao) {
		this.dtFabricacao = dtFabricacao;
	}
	public BigDecimal getVlProduto() {
		return vlProduto;
	}
	public void setVlProduto(BigDecimal vlProduto) {
		this.vlProduto = vlProduto;
	}
	public Integer getQtEstoque() {
		return qtEstoque;
	}
	public void setQtEstoque(Integer qtEstoque) {
		this.qtEstoque = qtEstoque;
	}
	public ProdutoDTO(String nomeProduto, String descricao, LocalDate dtFabricacao, BigDecimal vlProduto,
			Integer qtEstoque) {
		super();
		this.nomeProduto = nomeProduto;
		this.descricao = descricao;
		this.dtFabricacao = dtFabricacao;
		this.vlProduto = vlProduto;
		this.qtEstoque = qtEstoque;
	}
	
	
	
}
