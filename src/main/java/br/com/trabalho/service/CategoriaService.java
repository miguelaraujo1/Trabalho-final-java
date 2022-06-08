package br.com.trabalho.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trabalho.Repository.CategoriaRepository;
import br.com.trabalho.model.Categoria;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> obterTodos(){
		return categoriaRepository.findAll();
	}
	
	public Categoria buscar(Long id) { 
		Optional<Categoria> tipo = categoriaRepository.findById(id);
		return tipo.get();
	}
	
	  
	    public Categoria inserir(Categoria categoria) {
	    	Categoria novaCategoria = new Categoria();
            novaCategoria.setNomeCategoria(categoria.getNomeCategoria());
            return categoriaRepository.save(categoria);
    
	    }
	
	    
	    public Categoria atualizar(Categoria categoria, Long id) {
			if (!categoriaRepository.existsById(id)) {
				return null; 
			} 
			categoria.setId(id);
			return categoriaRepository.save(categoria); 
			
		} 
	

}
