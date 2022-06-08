package br.com.trabalho.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.trabalho.DTO.EnderecoDTO;
import br.com.trabalho.Repository.EnderecoRepository;
import br.com.trabalho.model.Categoria;
import br.com.trabalho.model.Endereco;


@Service
public class EnderecoService {
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Endereco> obterTodos(){
		return enderecoRepository.findAll();
	}

	public Endereco buscar(String cep) { 
		Optional<Endereco> endereco = enderecoRepository.findByCep(cep);
		if (endereco.isPresent()) {
			return endereco.get();
		} else {
			RestTemplate rs = new RestTemplate();
			String url = "https://viacep.com.br/ws/" + cep + "/json/";
			Optional<Endereco> enderecoViaCep = Optional.ofNullable(rs.getForObject(url, Endereco.class));
			if (!enderecoViaCep.get().getCep().isEmpty()) {
				String cepSemTraco = enderecoViaCep.get().getCep().replaceAll("-", "");
				enderecoViaCep.get().setCep(cepSemTraco);
				return inserir(enderecoViaCep.get());
			} else {
				return null;
			}

		}
	}

	public Endereco inserir (Endereco endereco) {
    	Endereco novoEndereco = new Endereco();
        novoEndereco.setBairro(endereco.getBairro());
        novoEndereco.setCep(endereco.getCep());
        novoEndereco.setCidade(endereco.getCidade());
        novoEndereco.setUf(endereco.getUf());
        return enderecoRepository.save(endereco);

    }
}

