# Client CRUD API

API REST para cadastro e gerenciamento de clientes, desenvolvida com Spring Boot, Spring Data JPA e banco H2 em memoria.

## Tecnologias

- Java 17
- Spring Boot 3.5.9
- Spring Web
- Spring Data JPA
- H2 Database
- Maven
- Bean Validation

## Funcionalidades

- Listar clientes com paginacao
- Buscar cliente por ID
- Cadastrar cliente
- Atualizar cliente
- Remover cliente
- Validar dados de entrada
- Tratar erros de recurso nao encontrado, erro de banco e validacao

## Como executar

Clone o repositorio e acesse a pasta do projeto:

```bash
git clone <url-do-repositorio>
cd client-crud-api
```

Execute a aplicacao com o Maven Wrapper:

```bash
./mvnw spring-boot:run
```

No Windows:

```bash
.\mvnw.cmd spring-boot:run
```

A API ficara disponivel em:

```text
http://localhost:8080
```

## Perfil e banco de dados

O projeto usa o perfil `test` por padrao, configurado em `src/main/resources/application.properties`.

Nesse perfil, a aplicacao utiliza banco H2 em memoria:

```text
jdbc:h2:mem:testdb
```

Console do H2:

```text
http://localhost:8080/h2-console
```

Credenciais:

```text
JDBC URL: jdbc:h2:mem:testdb
User: sa
Password:
```

Os dados iniciais sao carregados pelo arquivo `src/main/resources/import.sql`.

## Endpoints

| Metodo | Endpoint | Descricao |
| --- | --- | --- |
| GET | `/clients` | Lista clientes com paginacao |
| GET | `/clients/{id}` | Busca um cliente por ID |
| POST | `/clients` | Cria um novo cliente |
| PUT | `/clients/{id}` | Atualiza um cliente existente |
| DELETE | `/clients/{id}` | Remove um cliente |

## Exemplos de requisicao

### Listar clientes

```bash
curl "http://localhost:8080/clients?page=0&size=10&sort=name"
```

### Buscar cliente por ID

```bash
curl "http://localhost:8080/clients/1"
```

### Criar cliente

```bash
curl -X POST "http://localhost:8080/clients" \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Mariana Souza",
    "cpf": "12345678999",
    "income": 4500.0,
    "birthDate": "1995-03-20",
    "children": 1
  }'
```

### Atualizar cliente

```bash
curl -X PUT "http://localhost:8080/clients/1" \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Maria Silva Atualizada",
    "cpf": "12345678901",
    "income": 5200.0,
    "birthDate": "1990-05-12",
    "children": 2
  }'
```

### Remover cliente

```bash
curl -X DELETE "http://localhost:8080/clients/1"
```

## Modelo de cliente

```json
{
  "id": 1,
  "name": "Maria Silva",
  "cpf": "12345678901",
  "income": 3500.0,
  "birthDate": "1990-05-12",
  "children": 2
}
```

## Validacoes

- `name`: obrigatorio
- `cpf`: obrigatorio
- `birthDate`: nao pode ser uma data futura

Quando a validacao falha, a API retorna status `422 Unprocessable Entity`.

## Testes

Para executar os testes:

```bash
./mvnw test
```

No Windows:

```bash
.\mvnw.cmd test
```
