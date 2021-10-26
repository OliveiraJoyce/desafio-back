package com.act.desafioback.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.act.desafioback.model.Pessoa;
import com.act.desafioback.repository.PessoaRepository;

@Service
public class PessoaService {

	private @Autowired PessoaRepository repository;

	/**
	 * Método utilizado para cadastrar um usuario no banco de dados, o mesmo é
	 * responsavel por retornar vazio caso Usuario exista.
	 * 
	 * @param novaPessoa do tipo Pessoa
	 * @return Pessoa Criado quando não existir no banco.
	 * @author Joyce Oliveira.
	 */
	public Optional<Object> cadastrarPessoa(Pessoa novaPessoa) {
		Optional<Pessoa> pessoa = repository.findByCpf(novaPessoa.getCpf());
		if (pessoa.isPresent()) {
			return Optional.empty();
		} else {
			return Optional.ofNullable(repository.save(novaPessoa)); 
		}
		
	}
}
