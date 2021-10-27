package com.act.desafioback.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/{id_pessoa}")
	public ResponseEntity<Object> buscarPorId(@PathVariable(value = "id_pessoa") Long id_pessoa) {

		Optional<Object> objetoBuscado = service.buscarId(id_pessoa);
		if (objetoBuscado.isPresent()) {
			return ResponseEntity.status(200).body(objetoBuscado.get());
		} else {
			return ResponseEntity.status(404).build();
			
		}
	}
	
	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<Object> buscarPorCpf(@PathVariable(value = "cpf") String cpf) {
		Optional<Object> objetoBuscado = service.buscarCpf(cpf);
		if (objetoBuscado.isPresent()) {
			return ResponseEntity.status(200).body(objetoBuscado.get());
		} else {
			return ResponseEntity.status(404).build();
			
		}
		
	}
	
	@GetMapping("/rg/{rg}")
	public ResponseEntity<Object> buscarPorRg(@PathVariable(value = "rg") String rg) {
		Optional<Object> objetoBuscado = service.buscarRg(rg);
		if (objetoBuscado.isPresent()) {
			return ResponseEntity.status(200).body(objetoBuscado.get());
		} else {
			return ResponseEntity.status(404).build();
			
		}
		
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
		
		@PutMapping("/editar")
		public ResponseEntity<Pessoa> put(@RequestBody Pessoa pessoa) {
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(pessoa));
		}
	

	
	
	
	
}
