# 🚀 UserPost API

Uma API REST desenvolvida com Spring Boot para gerenciamento de usuários e posts, utilizando MongoDB como banco de dados.

O projeto implementa operações CRUD, relacionamento entre entidades e consultas avançadas com múltiplos critérios, seguindo boas práticas de arquitetura em aplicações Java.

## 🛠 Tecnologias Utilizadas
- Java 17
- Spring Boot 3.5.13
- MongoDB
- Lombok
- Maven

## 📊 Funcionalidades
- CRUD de usuários
- CRUD de posts
- Relacionamento entre usuários e posts
- Comentários embutidos (modelagem NoSQL)
- Busca por título (case-insensitive)
- Busca avançada com múltiplos critérios (texto + intervalo de datas)

## Como Executar
1. Certifique-se de ter o Java 17+ e o MongoDB rodando localmente (mongodb://localhost:27017/workshop_mongo).
2. Clone o repositório.
3. Execute:
   ```bash
   ./mvnw clean compile
   ./mvnw spring-boot:run
   ```
4. Acesse: http://localhost:8080

## Endpoints Principais
### Usuários (`/users`)
- `GET /users` — Lista todos os usuários
- `GET /users/{id}` — Busca usuário por ID
- `POST /users` — Cria usuário
- `PUT /users/{id}` — Atualiza usuário
- `DELETE /users/{id}` — Remove usuário
- `GET /users/{id}/posts` — Lista posts do usuário

### Posts (`/posts`)
- `GET /posts/{id}` — Busca post por ID
- `GET /posts/titlesearch?text=...` — Busca posts por título
- `GET /posts/fullsearch?text=...&minDate=...&maxDate=...` — Pesquisa completa (título, corpo, comentários, datas)

## Tratamento de Erros
- 404 para recursos não encontrados
- 500 para erros inesperados
- Resposta de erro inclui timestamp, status, mensagem e caminho

## Arquitetura e Boas Práticas
- **Separação em camadas** (Controller, Service, Repository)
- **Uso de DTOs** para entrada e saída de dados
- **Mapeamento com classes Mapper**
- **Tratamento global de exceções**
- **Modelagem NoSQL** com documentos embutidos (comments)

## Exemplos de Uso
```bash
POST /users
{
  "name": "João Silva",
  "email": "joao@example.com"
}

GET /posts/titlesearch?text=viagem
GET /posts/fullsearch?text=viagem&minDate=2023-01-01&maxDate=2023-12-31
```

## Testes
Execute:
```bash
./mvnw test
```

## Licença
MIT
