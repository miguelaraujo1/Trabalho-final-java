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

import br.com.trabalho.DTO.ProdutoDTO;
import br.com.trabalho.Repository.ProdutoRepository;
import br.com.trabalho.model.Categoria;
import br.com.trabalho.model.Produto;
import br.com.trabalho.service.ProdutoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@ApiOperation(value = "Listar todos os produtos", notes = "Lista produtos")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Retorna um produto"),
	        @ApiResponse(code = 401, message = "Não autorizado"),
	        @ApiResponse(code = 201, message = "Cria produto"),
	        @ApiResponse(code = 403, message = "Proibido acesso"),
	        @ApiResponse(code = 404, message = "Não encontrado"),
	        @ApiResponse(code = 500, message = "Erro no servidor")
	})
	@GetMapping
	public ResponseEntity<List<Produto>> obterTodos() {
		List<Produto> produtos = produtoService.obterTodos();
		return ResponseEntity.ok(produtos); 
	}

	@ApiOperation(value = "Buscar os produtos", notes = "Busca produtos")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Retorna um produto"),
	        @ApiResponse(code = 401, message = "Não autorizado"),
	        @ApiResponse(code = 201, message = "Cria produto"),
	        @ApiResponse(code = 403, message = "Proibido acesso"),
	        @ApiResponse(code = 404, message = "Não encontrado"),
	        @ApiResponse(code = 500, message = "Erro no servidor")
	})
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscar(@PathVariable Long id) {
		Produto produto = produtoService.buscar(id);
		if (produto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produto);
	}
	
	@ApiOperation(value = "Atualizar os produtos", notes = "Atualiza produtos")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Retorna um produto"),
	        @ApiResponse(code = 401, message = "Não autorizado"),
	        @ApiResponse(code = 201, message = "Cria produto"),
	        @ApiResponse(code = 403, message = "Proibido acesso"),
	        @ApiResponse(code = 404, message = "Não encontrado"),
	        @ApiResponse(code = 500, message = "Erro no servidor")
	})
	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@RequestBody Produto produto, @PathVariable Long id) {
		if (!produtoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		produto = produtoService.atualizar(produto, id);
		return ResponseEntity.ok(produto);
	}
	
	@ApiOperation(value = "Inserir os produtos", notes = "Insere produtos")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Retorna um produto"),
	        @ApiResponse(code = 401, message = "Não autorizado"),
	        @ApiResponse(code = 201, message = "Cria produto"),
	        @ApiResponse(code = 403, message = "Proibido acesso"),
	        @ApiResponse(code = 404, message = "Não encontrado"),
	        @ApiResponse(code = 500, message = "Erro no servidor")
	})
	@PostMapping
	public ResponseEntity<Produto> inserir(@Valid @RequestBody Produto produto) {
        Produto p = produtoService.inserir(produto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdProduto()).toUri();
        return ResponseEntity.created(uri).body(p);

    }
}
