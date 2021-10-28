# Desafio-back Casdastro de Pessoas e Endereços 

Aplicação feita em Spring Boot 2.5.6 para realizar o cadastro de pessoas e em seguida como relacionando com seu endereço consultado através do CEP, 
utilizando uma API externa do endereço https://viacep.com.br/ws/01001000/json/ para realizar como consultas.


#
A aplicação consiste em: <br>
ENDEREÇO/CEP:
- Cadastrar CEP = POST;
- Buscar por CEP = GET;
- Buscar todos os Cep's = GET

PESSOA:
- Cadastrar Pessoa com Endereço = POST;
- Atualizar Cadastro de Pessoa = PUT;
- Buscar Pessoas = GET;
- Buscar por RG e CPF = GET;
- Buscar por id pessoa = GET


O projeto deverá estar com um ambiente de testes configurado acessando o banco de dados MySQL, deverá usar Maven como gerenciador de dependência e Java 17 como linguagem.


A entidade Pessoa possui Id, Nome, CPF, RG e Endereço.<br>
A entidade Endereço possui  Id, CEP, Logradouro, Bairro, Localidade e Uf.
#
TESTANDO A APLICAÇÃO POSTMAN:<br>
Nome do arquivo: "Desafio Backend.postman_collection"<br>
Clonando o repositório será possível importar o projeto no Spring Boot e importar o arquivo de testes no Postman.
Disponibilizo imagens para melhor visualização de como realizar os testes no link a seguir: https://drive.google.com/drive/folders/1CZ5B3zqds1acqnWxf2hloM5ytuPgdyPl?usp=sharing
#
SWAGGER:<br>
Documentação da API Rest com Swagger "Desafio ACT - Back-End.pdf"

