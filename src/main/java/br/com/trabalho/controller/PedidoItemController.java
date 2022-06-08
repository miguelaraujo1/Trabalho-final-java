package br.com.trabalho.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.trabalho.DTO.PedidoItemDTO;
import br.com.trabalho.Repository.PedidoItemRepository;
import br.com.trabalho.model.Categoria;
import br.com.trabalho.model.Cliente;
import br.com.trabalho.model.PedidoItem;
import br.com.trabalho.service.PedidoItemService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/pedidoItens")
public class PedidoItemController {
	
	@Autowired
	private PedidoItemService pedidoItemService;
	@Autowired
	private PedidoItemRepository pedidoItemRepository;
	
	@ApiOperation(value = "Listar todos os pedidos itens", notes = "Lista pedidos item")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Retorna um pedido item"),
	        @ApiResponse(code = 401, message = "Não autorizado"),
	        @ApiResponse(code = 201, message = "Cria pedido item"),
	        @ApiResponse(code = 403, message = "Proibido acesso"),
	        @ApiResponse(code = 404, message = "Não encontrado"),
	        @ApiResponse(code = 500, message = "Erro no servidor")
	})
	@GetMapping
	public ResponseEntity<List<PedidoItem>> obterTodos() {
		List<PedidoItem> pedidoItens = pedidoItemService.obterTodos();
	
		return ResponseEntity.ok(pedidoItens); 
	}
	
	@ApiOperation(value = "Buscar por pedidos itens", notes = "Busca pedidos item")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Retorna um pedido item"),
	        @ApiResponse(code = 401, message = "Não autorizado"),
	        @ApiResponse(code = 201, message = "Cria pedido item"),
	        @ApiResponse(code = 403, message = "Proibido acesso"),
	        @ApiResponse(code = 404, message = "Não encontrado"),
	        @ApiResponse(code = 500, message = "Erro no servidor")
	})
	@GetMapping("/{pedidoItem}")
	public ResponseEntity<PedidoItem> buscar(@PathVariable Long id) {
		PedidoItem pedidoItem = pedidoItemService.buscar(id);
		if (pedidoItem == null) {
			return ResponseEntity.notFound().build(); 
		}
		return ResponseEntity.ok(pedidoItem);
	}
	
	@ApiOperation(value = "Inserir os pedidos itens", notes = "Insere pedidos item")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Retorna um pedido item"),
	        @ApiResponse(code = 401, message = "Não autorizado"),
	        @ApiResponse(code = 201, message = "Cria pedido item"),
	        @ApiResponse(code = 403, message = "Proibido acesso"),
	        @ApiResponse(code = 404, message = "Não encontrado"),
	        @ApiResponse(code = 500, message = "Erro no servidor")
	})
	@PostMapping
	public ResponseEntity<PedidoItem> inserir(@Valid @RequestBody PedidoItem pedidoItem) {
        PedidoItem pdi = pedidoItemService.inserir(pedidoItem);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pdi.getIdPedidoItem()).toUri();
        return ResponseEntity.created(uri).body(pdi);
    }
	
	@ApiOperation(value = "Atualizar os pedidos itens", notes = "Atualiza pedidos item")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Retorna um pedido item"),
	        @ApiResponse(code = 401, message = "Não autorizado"),
	        @ApiResponse(code = 201, message = "Cria pedido item"),
	        @ApiResponse(code = 403, message = "Proibido acesso"),
	        @ApiResponse(code = 404, message = "Não encontrado"),
	        @ApiResponse(code = 500, message = "Erro no servidor")
	})
	@PutMapping ("/{id}")
	public ResponseEntity<PedidoItem> atualizar(@RequestBody PedidoItem pedidoItem, @PathVariable Long id) {
		if (!pedidoItemRepository.existsById(id)) {
			return ResponseEntity.notFound().build(); 
		} 
		pedidoItem = pedidoItemService.atualizar(pedidoItem, id);
		return ResponseEntity.ok(pedidoItem);    
	}
	
}
