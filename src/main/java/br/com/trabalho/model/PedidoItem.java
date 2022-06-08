package br.com.trabalho.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class PedidoItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedidoItem;

	@Column
	private Double qtCompraProduto;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "id_produto")
	private Produto produto;

	@Column
	private Double vlVenda;

	public Long getIdPedidoItem() {
		return idPedidoItem;
	}

	public void setIdPedidoItem(Long idPedidoItem) {
		this.idPedidoItem = idPedidoItem;
	}

	public Double getQtCompraProduto() {
		return qtCompraProduto;
	}

	public void setQtCompraProduto(Double qtCompraProduto) {
		this.qtCompraProduto = qtCompraProduto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double getVlVenda() {
		return vlVenda;
	}

	public void setVlVenda(Double vlVenda) {
		this.vlVenda = vlVenda;
	}

}
