package com.act.desafioback.service;



import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.act.desafioback.model.Endereco;


@Service
public class EnderecoService {

	public Endereco pesquisarCep(String cep){
		String url = "https://viacep.com.br/ws/"+ cep +"/json/";
	    RestTemplate restTemplate = new RestTemplate();
	   Endereco cepResponse = restTemplate.getForObject(url, Endereco.class);
	    return cepResponse;
	}
	
}
