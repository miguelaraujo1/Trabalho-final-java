package br.com.trabalho.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.trabalho.model.Cliente;
import br.com.trabalho.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	Optional<Produto> findByIdProduto(Long idProduto);
}