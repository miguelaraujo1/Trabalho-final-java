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

import br.com.trabalho.Repository.PedidoRepository;
import br.com.trabalho.model.Pedido;
import br.com.trabalho.model.PedidoItem;
import br.com.trabalho.service.PedidoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private PedidoRepository pedidoRepository;

	@ApiOperation(value = "Listar todos os pedidos", notes = "Lista pedidos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um pedido"),
			@ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 201, message = "Cria pedido"),
			@ApiResponse(code = 403, message = "Proibido acesso"), @ApiResponse(code = 404, message = "Não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	@GetMapping
	public ResponseEntity<List<Pedido>> obterTodos() {
		List<Pedido> pedidos = pedidoService.obterTodos();

		return ResponseEntity.ok(pedidos);
	}

	@ApiOperation(value = "Buscar todos os pedidos", notes = "Busca pedidos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um pedido"),
			@ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 201, message = "Cria pedido"),
			@ApiResponse(code = 403, message = "Proibido acesso"), @ApiResponse(code = 404, message = "Não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	@GetMapping("/{pedido}")
	public ResponseEntity<Pedido> buscar(@PathVariable Long id) {
		Pedido pedido = pedidoService.buscar(id);
		if (pedido == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pedido);
	}

	@ApiOperation(value = "Inserir todos os pedidos", notes = "Insere pedidos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um pedido"),
			@ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 201, message = "Cria pedido"),
			@ApiResponse(code = 403, message = "Proibido acesso"), @ApiResponse(code = 404, message = "Não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	@PostMapping
	public ResponseEntity<Pedido> inserir(@Valid @RequestBody Pedido pedido) {
        Pedido pd = pedidoService.inserir(pedido);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pd.getIdPedido()).toUri();
        return ResponseEntity.created(uri).body(pd);
    }
	

	@ApiOperation(value = "Atualizar todos os pedidos", notes = "Atualiza pedidos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um pedido"),
			@ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 201, message = "Cria pedido"),
			@ApiResponse(code = 403, message = "Proibido acesso"), @ApiResponse(code = 404, message = "Não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	@PutMapping("/{id}")
	public ResponseEntity<Pedido> atualizar(@RequestBody Pedido pedido, @PathVariable Long id) {
		if (!pedidoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		pedido = pedidoService.atualizar(pedido, id);
		return ResponseEntity.ok(pedido);
	}

}
