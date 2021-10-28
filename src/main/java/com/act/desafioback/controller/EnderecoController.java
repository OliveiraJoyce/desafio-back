package com.act.desafioback.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import com.act.desafioback.model.Endereco;
import com.act.desafioback.repository.EnderecoRepository;
import com.act.desafioback.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoRepository repository;

	@Autowired
	private EnderecoService service;

	@GetMapping("/cep/buscar")
	public ResponseEntity<List<Endereco>> GetAll() {
		return ResponseEntity.ok(repository.findAll());

	}

	@GetMapping("/cep/buscar/{cep}")
	public ResponseEntity<Object> getCep(@PathVariable String cep) {
		Optional<Endereco> cepObject = repository.findByCep(cep);
		if (cepObject.isPresent()) {
			return ResponseEntity.status(200).body(cepObject.get());
		} else {
			return ResponseEntity.status(404).build();
		}
	}

	@PostMapping("/cep/cadastrar/{cep}")
	public ResponseEntity<Object> postCep(@PathVariable String cep) {
		try {
			Endereco cepResponse = service.pesquisarCep(cep);
			return ResponseEntity.status(201).body(this.repository.save(cepResponse));
		} catch (HttpClientErrorException httpClientErrorException) {
			return ResponseEntity.status(400).build();
		}

	}
	

}
