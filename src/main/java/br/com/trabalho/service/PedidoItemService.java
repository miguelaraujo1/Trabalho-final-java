package br.com.trabalho.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trabalho.Repository.PedidoItemRepository;
import br.com.trabalho.model.Categoria;
import br.com.trabalho.model.Pedido;
import br.com.trabalho.model.PedidoItem;
import br.com.trabalho.model.Produto;

@Service
public class PedidoItemService {
	@Autowired
	private PedidoItemRepository pedidoItemRepository;
	
	public List<PedidoItem> obterTodos(){
		return pedidoItemRepository.findAll();
	}
	
	public PedidoItem buscar(Long id) { 
		Optional<PedidoItem> tipo = pedidoItemRepository.findById(id);
		return tipo.get();
	}
	
	 public PedidoItem inserir(PedidoItem pedidoItem) { 
		  PedidoItem novoPedidoItem = new PedidoItem();
		  novoPedidoItem.setPedido(pedidoItem.getPedido());
		  novoPedidoItem.setProduto(pedidoItem.getProduto());
		  novoPedidoItem.setQtCompraProduto(pedidoItem.getQtCompraProduto());
		  novoPedidoItem.setVlVenda(pedidoItem.getVlVenda());
		  return pedidoItem;
	    }
	  
	  public PedidoItem atualizar(PedidoItem pedidoItem, Long id) {
			if (!pedidoItemRepository.existsById(id)) {
				return null; 
			} 
			pedidoItem.setIdPedidoItem(id);
			return pedidoItemRepository.save(pedidoItem); 
			
		} 

}
