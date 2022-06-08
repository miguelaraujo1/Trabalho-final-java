package br.com.trabalho.DTO;

import br.com.trabalho.model.Endereco;

public class EnderecoDTO {
	
	private String cep;
	private String bairro;
	private String uf;
	private Long cidade;
	
	public EnderecoDTO(String cep, String bairro, String uf, Long cidade) {
		super();
		this.cep = cep;
		this.bairro = bairro;
		this.uf = uf;
		this.cidade = cidade;
	}

	public EnderecoDTO(Endereco endereco) {
		
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Long getCidade() {
		return cidade;
	}

	public void setCidade(Long cidade) {
		this.cidade = cidade;
	}

	
	
	
}

