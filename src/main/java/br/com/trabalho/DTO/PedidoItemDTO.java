package br.com.trabalho.DTO;

import java.math.BigDecimal;

import br.com.trabalho.model.Pedido;
import br.com.trabalho.model.PedidoItem;
import br.com.trabalho.model.Produto;

public class PedidoItemDTO {

	
	private Produto produto;
	private Pedido pedido;
	private BigDecimal vlTotalPedido;
	private Double vlVenda;
	
	public PedidoItemDTO(Double vlVenda, Produto produto, Pedido pedido, BigDecimal vlTotalPedido) {
		super();
		this.vlVenda = vlVenda;
		this.produto = produto;
		this.pedido = pedido;
		this.vlTotalPedido = vlTotalPedido;
	}

	public PedidoItemDTO(PedidoItem pedidoItem) {
		super();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public BigDecimal getVlTotalPedido() {
		return vlTotalPedido;
	}

	public void setVlTotalPedido(BigDecimal vlTotalPedido) {
		this.vlTotalPedido = vlTotalPedido;
	}

	public Double getVlVenda() {
		return vlVenda;
	}

	public void setVlVenda(Double vlVenda) {
		this.vlVenda = vlVenda;
	}
	
	
}
