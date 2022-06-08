package br.com.trabalho.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.trabalho.model.Cliente;
import br.com.trabalho.model.Pedido;
import br.com.trabalho.model.PedidoItem;

public class PedidoDTO {

	private Long idPedido;
	private Cliente cliente;
	private LocalDate dtPedido;
	private List<PedidoItem> itens = new ArrayList<>();
	private BigDecimal vlTotal;
	

	public PedidoDTO(Long idPedido, Cliente cliente, LocalDate dtPedido, List<PedidoItem> itens, BigDecimal vlTotal) {
		super();
		this.idPedido = idPedido;
		this.cliente = cliente;
		this.dtPedido = dtPedido;
		this.itens = itens;
		this.vlTotal = vlTotal;
		
	}

	public PedidoDTO(Pedido pedido) {
		super();
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getDtPedido() {
		return dtPedido;
	}

	public void setDtPedido(LocalDate dtPedido) {
		this.dtPedido = dtPedido;
	}

	public List<PedidoItem> getItens() {
		return itens;
	}

	public void setItens(List<PedidoItem> itens) {
		this.itens = itens;
	}

	public BigDecimal getVlTotal() {
		return vlTotal;
	}

	public void setVlTotal(BigDecimal vlTotal) {
		this.vlTotal = vlTotal;
	}

}
