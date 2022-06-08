package br.com.trabalho.service;

import java.math.BigDecimal;
import java.util.List;
import br.com.trabalho.model.PedidoItem;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.trabalho.Repository.PedidoRepository;
import br.com.trabalho.model.Categoria;
import br.com.trabalho.model.Pedido;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	public List<Pedido> obterTodos(){
		return pedidoRepository.findAll();
	}
	
	public Pedido buscar(Long id) { 
		Optional<Pedido> caixinhaPedido = pedidoRepository.findById(id);
		Pedido pedido = caixinhaPedido.get();
		
		var valorTotal = 0.0;
	  	for(PedidoItem item : pedido.getItens()){
	  	
	  		valorTotal += item.getVlVenda()*item.getQtCompraProduto();
	  	}
	  	pedido.setVlTotal(valorTotal);

		return pedido;
	}
	
	public Pedido inserir(Pedido pedido) { 
		  Pedido novoPedido= new Pedido();
		  novoPedido.setCliente(pedido.getCliente());
		  novoPedido.setDtPedido(pedido.getDtPedido());
		  novoPedido.setItens(pedido.getItens());
		  novoPedido.setVlTotal(pedido.getVlTotal());
		  return pedido;
	    }
	  
	  public Pedido atualizar(Pedido pedido, Long id) {
			if (!pedidoRepository.existsById(id)) {
				return null; 
			} 
			pedido.setIdPedido(id);
			return pedidoRepository.save(pedido);  
			
		} 

}

