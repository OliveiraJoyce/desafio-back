package com.act.desafioback.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.act.desafioback.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	/**
	 * Metodo utilizado para pesquisar nome da tabela Usuario
	 * 
	 * @param nome
	 * @return Lista de Usuario
	 * @author Joyce Oliveira.
	 */
	 public List<Pessoa> findAllByNomeContainingIgnoreCase (String nome);
	 
	/**
	 * Metodo utilizado para selecionar apenas um Usuario pelo cpf
	 * 
	 * @param cpf
	 * @return Optional com Usuario 
	 * @author Joyce Oliveira.
	 */

	public Optional<Pessoa> findByCpf (String cpf); 
}
