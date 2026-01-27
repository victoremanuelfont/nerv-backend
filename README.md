# Nerv Store Backend 

API RESTful em desenvolvimento para o gerenciamento de um e-commerce (Nerv Store). O projeto foca nas melhores práticas de desenvolvimento backend com Java e Spring Boot, implementando um fluxo completo de CRUD, validações de dados e tratamento centralizado de exceções.

## 🛠 Tecnologias & Ferramentas

* **Java 17+**
* **Spring Boot 3**
* **Spring Data JPA** (Hibernate)
* **H2 Database** (Banco em memória para desenvolvimento/testes rápidos)
* **Maven** (Gerenciamento de dependências)
* **Postman** (Testes de API)

## 🏛 Arquitetura e Padrões de Projeto

O projeto foi estruturado seguindo uma arquitetura em camadas para garantir a separação de responsabilidades (SoC) e facilitar a manutenção:

* **Controller Layer:** Gerencia as requisições HTTP e utiliza `ResponseEntity` para maior controle sobre os status codes e contratos de resposta.
* **Service Layer:** Encapsula a lógica de negócios, garantindo que o controlador não acesse o banco de dados diretamente.
* **Repository Layer:** Abstração de acesso a dados usando a interface `JpaRepository`.
* **DTO Pattern:** Uso de *Data Transfer Objects* para desacoplar as entidades de domínio da camada de apresentação (API), aumentando a segurança e flexibilidade dos dados trafegados.

## ✨ Funcionalidades Destacadas

### 1. Modelagem de Domínio Complexa
Implementação de um modelo relacional robusto utilizando ORM (Object-Relational Mapping):
* Relacionamentos **Many-to-Many** com atributos extras (Entidade Associativa `OrderItem`).
* Uso de **Chaves Primárias Compostas** (`@EmbeddedId` / `OrderItemPK`) para integridade referencial correta.
* Mapeamento de Enums para status de pedidos (`OrderStatus`).

### 2. Consultas e Paginação
* Implementação de consultas otimizadas com **JPQL** (Java Persistence Query Language) para buscas personalizadas (ex: busca de produtos por nome).
* Suporte a **Paginação** (`Pageable`) no endpoint `findAll`, permitindo escalabilidade no retorno de grandes listas de dados.

### 3. Tratamento de Exceções e Resiliência
Sistema centralizado de tratamento de erros (`@ControllerAdvice` / Handler) para evitar que stack traces vazem para o cliente:
* **ResourceNotFoundException:** Disparada quando um recurso (como ID de produto) não é encontrado.
* **DatabaseException:** Tratamento de violações de integridade no banco de dados.
* Padronização das respostas de erro (JSON com timestamp, status e mensagem amigável).

### 4. Validação de Dados (Bean Validation)
Garantia de integridade dos dados na entrada da API:
* Uso de anotações como `@NotBlank`, `@Size`, `@Positive` nos DTOs.
* Customização das mensagens de erro para o frontend, retornando lista de campos inválidos de forma estruturada.

## 📚 Endpoints Principais

| Método | Endpoint           | Descrição                                      |
| :----- | :----------------- | :--------------------------------------------- |
| GET    | `/products`        | Lista todos os produtos (suporta paginação).   |
| GET    | `/products/{id}`   | Busca um produto específico por ID.            |
| POST   | `/products`        | Cria um novo produto (Requer validação).       |
| PUT    | `/products/{id}`   | Atualiza dados de um produto existente.        |
| DELETE | `/products/{id}`   | Remove um produto (com verificação de integridade). |

---
*Desenvolvido como parte do portfólio de estudos em Engenharia de Software e Backend Development.*
