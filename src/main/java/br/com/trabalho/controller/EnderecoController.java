package br.com.trabalho.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.trabalho.model.Categoria;
import br.com.trabalho.model.Endereco;
import br.com.trabalho.service.EnderecoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {
	@Autowired
	private EnderecoService enderecoService;

	@ApiOperation(value = "Lista todos os endereços", notes = "Lista endereços")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um endereço"),
			@ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 201, message = "Cria endereço"),
			@ApiResponse(code = 403, message = "Proibido acesso"), @ApiResponse(code = 404, message = "Não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	@GetMapping
	public ResponseEntity<List<Endereco>> obterTodos() {
		List<Endereco> enderecos = enderecoService.obterTodos();

		return ResponseEntity.ok(enderecos);
	}

	@ApiOperation(value = "Buscar endereços", notes = "Busca endereços")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um endereço"),
			@ApiResponse(code = 401, message = "Não autorizado"), @ApiResponse(code = 201, message = "Cria endereço"),
			@ApiResponse(code = 403, message = "Proibido acesso"), @ApiResponse(code = 404, message = "Não encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor") })
	@GetMapping("{cep}")
	public ResponseEntity<Endereco> buscar(@PathVariable String cep) {
		Endereco endereco = enderecoService.buscar(cep);
		if (endereco == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(endereco);
	}
	

	@PostMapping
	public ResponseEntity<Endereco> inserir(@Valid @RequestBody Endereco endereco) {
        Endereco ec = enderecoService.inserir(endereco);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ec.getId()).toUri();
        return ResponseEntity.created(uri).body(ec);

    }
}
