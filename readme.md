# TodoSimple API

## Projeto Java Spring Boot

### Features

- [x] CRUD de clientes
- [x] CRUD de tarefas
- [x] Relacionamento entre clientes e tarefas
- [x] Arquitetura hexagonal e Orientada ao domínio (DDD)
- [x] Cripografia de senhas e Spring Security
- [x] Autenticação com JWT
- [ ] Conteinerização com Docker
- [ ] Testes unitários

### Requisitos

- Java 17
- Maven
- MySQL
- Docker

### Rodando o projeto

- clone o projeto: `git clone https://github.com/joaomanoel/TodoSimple.git`
- abra o projeto na IDE de sua preferência
- configure as variáveis de ambiente (DATABASE_USERNAME, DATABASE_PASSWORD) de acordo com o seu banco de dados
- execute o projeto: `mvn spring-boot:run`
- acesse as rotas a partir da url base: `http://localhost:8080/`

### Autenticação na API

- crie um usuário com uma requisição POST para o entpoint /customer

    payload: 
    ``` json
    	"username":"username",
	"email":"test@mail.com",
	"password":"strongPassword"  
    ```
- mande uma requisição POST para o endpoint /authenticate com suas credenciais.
 
    payload: 

    ``` json
    	"username":"username",
	"password":"strongPassword"  
    ```
  
- O retorno dessa chamada retornará um token JWT que será utilizado nos headers das requisições
- Para as próximas requisições adicione esse token no header de Authorization, com "Bearer" seguido pelo token:
`Authorization: Bearer eyJhbGciOiJSUzI1NiJ9...`
