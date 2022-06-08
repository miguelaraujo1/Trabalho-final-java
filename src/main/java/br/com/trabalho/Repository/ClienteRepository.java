package br.com.trabalho.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.trabalho.DTO.ClienteDTO;
import br.com.trabalho.model.Cliente;
import br.com.trabalho.model.Endereco;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Object findByEmail(String email);
}
