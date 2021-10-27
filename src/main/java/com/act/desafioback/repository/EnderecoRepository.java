package com.act.desafioback.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.act.desafioback.model.Endereco;



@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	public Optional<Endereco> findByCep (String cep); 
}
