package br.com.trabalho.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.trabalho.DTO.ProdutoDTO;
import br.com.trabalho.Repository.ProdutoRepository;
import br.com.trabalho.model.Categoria;
import br.com.trabalho.model.Produto;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> obterTodos(){
		return produtoRepository.findAll();
	}
	
	public Produto buscar(Long id) { 
		Optional<Produto> tipo = produtoRepository.findById(id);
		return tipo.get();
	}
	
	  public Produto inserir(Produto produto) { 
	
		  produto = produtoRepository.save(produto);
		  return produto;
	    }
	  
	  
	
	 public Produto atualizar(Produto produto, Long id) {
			if (!produtoRepository.existsById(id)) {
				return null; 
			} 
			produto.setIdProduto(id);
			return produtoRepository.save(produto); 
			
		} 
	
}
