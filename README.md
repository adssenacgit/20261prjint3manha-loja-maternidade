# Projeto Backend Java 21 - Spring Boot + MySQL + Swagger

Backend REST criado para o banco `20261_prjint3_manha_isabelpaz`.

## Tecnologias

- Java 21
- Spring Boot 3.3.13
- Spring Web
- Spring Data JPA
- MySQL Connector/J
- Springdoc OpenAPI Swagger
- Maven

## Configuração do banco

O arquivo de configuração está em:

```text
src/main/resources/application.properties
```

Altere:

```properties
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
```

A URL já está apontando para:

```properties
jdbc:mysql://edumysql.acesso.rj.senac.br:3306/20261_prjint3_manha_isabelpaz
```

## Executar o projeto

```bash
mvn spring-boot:run
```

## Swagger

Depois de executar, acesse:

```text
http://localhost:8080/swagger-ui.html
```

## Regras de status

O projeto usa exclusão lógica:

- `1` = ativo
- `0` = inativo
- `-1` = apagado logicamente

Os endpoints `GET` não retornam registros com status `-1`.
O método `DELETE` não remove fisicamente do banco, apenas atualiza o status para `-1`.

## Endpoints criados

| Entidade | Endpoint |
|---|---|
| Usuário | `/api/usuarios` |
| Produto | `/api/produtos` |
| Endereço | `/api/enderecos` |
| Pedido | `/api/pedidos` |
| Pagamento | `/api/pagamentos` |
| ItemPedido | `/api/itens-pedido` |

Todos os controllers possuem:

```java
@CrossOrigin("*")
```

## Operações disponíveis em cada controller

```text
GET    /api/{recurso}
GET    /api/{recurso}/{id}
POST   /api/{recurso}
PUT    /api/{recurso}/{id}
DELETE /api/{recurso}/{id}
```

## Exemplos de JSON

### Criar usuário

```json
{
  "nome": "Maria Silva",
  "cpf": "12345678901",
  "email": "maria@email.com",
  "senha": "123456",
  "telefone": "21999999999",
  "endereco": "Rua Exemplo, 100",
  "dataNasc": "2000-05-10",
  "dataCadastro": "2026-07-02",
  "numeroCartao": "0000111122223333",
  "admin": 0,
  "status": 1
}
```

### Criar produto

```json
{
  "precoUnitario": 99.90,
  "nomeProduto": "Produto Teste",
  "descricao": "Descrição do produto",
  "estoque": 10,
  "categoria": "Categoria Teste",
  "imagem": "https://exemplo.com/imagem.png",
  "status": 1
}
```

### Criar endereço vinculado a usuário

```json
{
  "usuario": {
    "id": 1
  },
  "cep": "20000000",
  "logradouro": "Rua Teste",
  "numero": 10,
  "complemento": "Apto 101",
  "bairro": "Centro",
  "cidade": "Rio de Janeiro",
  "estado": "RJ",
  "status": 1
}
```

### Criar pedido vinculado a usuário

```json
{
  "usuario": {
    "id": 1
  },
  "data": "2026-07-02",
  "valorTotal": 199.80,
  "status": 1
}
```

### Criar pagamento vinculado a usuário e pedido

```json
{
  "usuario": {
    "id": 1
  },
  "pedido": {
    "id": 1
  },
  "tipo": "Cartão de crédito",
  "status": 1
}
```

### Criar item de pedido vinculado a produto

Observação: a tabela `itempedido` enviada não possui coluna `pedido_id`, então o item foi modelado apenas com vínculo para `produto`.

```json
{
  "produto": {
    "id": 1
  },
  "quantidade": 2,
  "valorUnitario": 99.90,
  "status": 1
}
```
