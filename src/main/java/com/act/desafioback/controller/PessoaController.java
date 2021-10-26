package com.act.desafioback.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.act.desafioback.model.Pessoa;
import com.act.desafioback.repository.PessoaRepository;
import com.act.desafioback.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaRepository repository;
	
	@Autowired
	private PessoaService service;

	@GetMapping
	public ResponseEntity<List<Pessoa>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Object> cadastrarPessoa(@Valid @RequestBody Pessoa novaPessoa) {
		Optional<Object> objetoCadastrado = service.cadastrarPessoa(novaPessoa);

		if (objetoCadastrado.isPresent()) {
			return ResponseEntity.status(201).body(objetoCadastrado.get());
		} else {
			return ResponseEntity.status(400).build();
		}
		

	}

	
	
	
	
}
