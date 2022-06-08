package br.com.trabalho.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.trabalho.DTO.ClienteDTO;
import br.com.trabalho.Repository.ClienteRepository;
import br.com.trabalho.config.MailConfig;
import br.com.trabalho.exception.EmailException;
import br.com.trabalho.model.Cliente;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	MailConfig mailConfig;
	
	public List<Cliente> obterTodos(){
		return clienteRepository.findAll();
	}
	
	public Cliente buscar(Long id) { 
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	
	}
	
	public Cliente inserir(Cliente cliente) {
		if (clienteRepository.findByEmail(cliente.getEmail()) != null) {
			throw new EmailException("Este email já está cadastrado !");
		}

		
		cliente = clienteRepository.save(cliente);

		mailConfig.enviarEmail(cliente.getEmail(), "Confirmação de Cadastro de Usuário", cliente.toString());
		return cliente;  

	}  
	
	public Cliente atualizar(Cliente cliente, Long id) {
		if (!clienteRepository.existsById(id)) {
		return null;
		} 
		Cliente clientes= new Cliente();
		cliente.setIdCliente(id);
		cliente.setNome(clientes.getNome());
		cliente.setEmail(clientes.getEmail());
		cliente.setCpf(clientes.getCpf()); 
		cliente.setTelefone(clientes.getTelefone());
		cliente.setEndereco(clientes.getEndereco());
		cliente = clienteRepository.save(cliente);
		
		mailConfig.enviarEmail(cliente.getEmail(), "Confirmação de Cadastro de Usuário", cliente.toString());
		return cliente;
	}
}
