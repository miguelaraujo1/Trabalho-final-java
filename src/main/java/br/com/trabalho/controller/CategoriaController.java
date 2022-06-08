package br.com.trabalho.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.trabalho.Repository.CategoriaRepository;
import br.com.trabalho.model.Categoria;
import br.com.trabalho.service.CategoriaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private CategoriaRepository categoriaRepository;

	@ApiOperation(value = "listar todas as categorias", notes = "Listar categorias")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "listar todas as categorias"),
							@ApiResponse(code = 401, message = "Não autorizado"),
							@ApiResponse(code = 201, message = "Cria as categorias"),
							@ApiResponse(code = 403, message = "Proibido acesso"), 
							@ApiResponse(code = 404, message = "Não encontrado"),
							@ApiResponse(code = 500, message = "Erro no servidor") })
	@GetMapping
	public ResponseEntity<List<Categoria>> obterTodos() {
		List<Categoria> categorias = categoriaService.obterTodos();

		return ResponseEntity.ok(categorias);
	}

	@ApiOperation(value = "Busca uma categoria", notes = "Busca categoria")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna uma categoria"),
							@ApiResponse(code = 401, message = "Não autorizado"), 
							@ApiResponse(code = 201, message = "Cria categoria"),
							@ApiResponse(code = 403, message = "Proibido acesso"), 
							@ApiResponse(code = 404, message = "Não encontrado"),
							@ApiResponse(code = 500, message = "Erro no servidor") })
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> buscar(@PathVariable Long id) {
		Categoria categorias = categoriaService.buscar(id);
		if (categorias == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(categorias);
	}

	@ApiOperation(value = "Inserir uma categoria", notes = "Inserir categoria")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna uma categoria"),
							@ApiResponse(code = 401, message = "Não autorizado"), 
							@ApiResponse(code = 201, message = "Cria categoria"),
							@ApiResponse(code = 403, message = "Proibido acesso"), 
							@ApiResponse(code = 404, message = "Não encontrado"),
							@ApiResponse(code = 500, message = "Erro no servidor") })

	
	@PostMapping
	public ResponseEntity<Categoria> inserir(@Valid @RequestBody Categoria categoria) {
        Categoria c = categoriaService.inserir(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(c.getId()).toUri();
        return ResponseEntity.created(uri).body(c);

    }

	@ApiOperation(value = "Atualizar uma categoria", notes = "Atualiza categoria")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna uma categoria"),
							@ApiResponse(code = 401, message = "Não autorizado"), 
							@ApiResponse(code = 201, message = "Cria categoria"),
							@ApiResponse(code = 403, message = "Proibido acesso"), 
							@ApiResponse(code = 404, message = "Não encontrado"),
							@ApiResponse(code = 500, message = "Erro no servidor") })
	@PutMapping("/{id}")
	public ResponseEntity<Categoria> atualizar(@Valid @RequestBody Categoria categoria, @PathVariable Long id) {
		if (!categoriaRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		Categoria categorias = categoriaService.atualizar(categoria, id);
		return ResponseEntity.ok(categorias);
	}

}
