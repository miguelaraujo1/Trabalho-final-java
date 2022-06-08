package br.com.trabalho.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.trabalho.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	Optional<Endereco> findByCep(String cep);
}
