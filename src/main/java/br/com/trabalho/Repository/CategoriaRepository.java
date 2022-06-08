package br.com.trabalho.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.trabalho.model.Categoria;
import br.com.trabalho.model.Endereco;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	Optional<Categoria> findById(Long id);
	
}
