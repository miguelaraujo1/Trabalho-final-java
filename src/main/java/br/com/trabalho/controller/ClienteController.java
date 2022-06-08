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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.trabalho.Repository.ClienteRepository;
import br.com.trabalho.model.Cliente;
import br.com.trabalho.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ClienteRepository clienteRepository;

	@ApiOperation(value = "Lista todos os clientes", notes = "Lista clientes")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um cliente"),
							@ApiResponse(code = 401, message = "Não autorizado"), 
							@ApiResponse(code = 201, message = "Cria cliente"),
							@ApiResponse(code = 403, message = "Proibido acesso"), 
							@ApiResponse(code = 404, message = "Não encontrado"),
							@ApiResponse(code = 500, message = "Erro no servidor") })
	@GetMapping
	public ResponseEntity<List<Cliente>> obterTodos() {
		List<Cliente> clientes = clienteService.obterTodos();

		return ResponseEntity.ok(clientes);
	}

	@ApiOperation(value = "Lista um cliente", notes = "Lista um cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um cliente"),
							@ApiResponse(code = 401, message = "Não autorizado"), 
							@ApiResponse(code = 201, message = "Cria cliente"),
							@ApiResponse(code = 403, message = "Proibido acesso"), 
							@ApiResponse(code = 404, message = "Não encontrado"),
							@ApiResponse(code = 500, message = "Erro no servidor") })
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
		Cliente clientes = clienteService.buscar(id);
		if (clientes == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(clientes);
	}

	@ApiOperation(value = "Inserir clientes", notes = "Insere clientes")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um cliente"),
			@ApiResponse(code = 401, message = "Não autorizado"), 
			@ApiResponse(code = 201, message = "Cria cliente"),
			@ApiResponse(code = 403, message = "Proibido acesso"), 
			@ApiResponse(code = 404, message = "Não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	
	@PostMapping
	public ResponseEntity<Cliente> inserir(@Valid @RequestBody Cliente cliente) {
        Cliente cl = clienteService.inserir(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cl.getIdCliente()).toUri();
        return ResponseEntity.created(uri).body(cl);
//        return new ResponseEntity<>(cl, HttpStatus.CREATED); **
    }

	@ApiOperation(value = "Atualizar os clientes", notes = "Atualiza clientes")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um cliente"),
			@ApiResponse(code = 401, message = "Não autorizado"), 
			@ApiResponse(code = 201, message = "Cria cliente"),
			@ApiResponse(code = 403, message = "Proibido acesso"), 
			@ApiResponse(code = 404, message = "Não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@Valid @RequestBody Cliente cliente, Long id) {
		if (!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		Cliente clientes = clienteService.atualizar(cliente, id);
		return ResponseEntity.ok(clientes);
	}
}
