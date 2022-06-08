package br.com.trabalho.DTO;

import br.com.trabalho.model.Categoria;

public class CategoriaDTO {

	private Long id;
	private String nomeCategoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public CategoriaDTO(Long id, String nomeCategoria) {
		super();
		this.id = id;
		this.nomeCategoria = nomeCategoria;
	}
	public CategoriaDTO(Categoria categoria) {
		
	}
}
