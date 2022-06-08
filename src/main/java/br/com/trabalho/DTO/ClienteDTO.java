package br.com.trabalho.DTO;

import java.util.HashSet;
import java.util.Set;

import br.com.trabalho.model.Cliente;
import br.com.trabalho.model.Endereco;

public class ClienteDTO {


	private String nome;
	private String telefone;
	private String email;
	private String cpf;
	private Endereco endereco;
	
	private Set<Cliente>cliente = new HashSet<>();

	public ClienteDTO(String nome, String telefone, String email, String cpf, Endereco endereco,
			Set<Cliente> cliente) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;
		this.endereco = endereco;
		this.cliente = cliente;

	}

	public ClienteDTO(Cliente cliente) {
		
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Set<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(Set<Cliente> cliente) {
		this.cliente = cliente;
	}

	
	
}
