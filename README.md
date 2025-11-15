# 📚 Sistema de Cadastro de Livros

Sistema de gerenciamento de acervo de livros desenvolvido com Spring Boot, implementando operações CRUD completas através de uma API REST.

## 📋 Sobre o Projeto

Este projeto foi desenvolvido para a disciplina de Desenvolvimento de Aplicações Corporativas. O sistema permite cadastrar, consultar, atualizar e remover livros do catálogo da Biblioteca Municipal.

### Funcionalidades

- ✅ Cadastrar novos livros
- ✅ Listar todos os livros
- ✅ Buscar livro por ID
- ✅ Buscar livro por ISBN
- ✅ Atualizar informações de livros
- ✅ Remover livros do catálogo

## 🛠️ Stack Tecnológica

- **Java 21**
- **Spring Boot 3.5.7**
- **Spring Data JPA**
- **H2 Database** (banco em memória)
- **JUnit 5** e **Mockito** (testes)
- **Gradle** (gerenciamento de dependências)

## 📦 Pré-requisitos

Antes de rodar os testes unitários, veja se já tem instalado:

- **Java 17 ou superior** (recomendado Java 21)
- **Gradle 8.x** (ou use o Gradle Wrapper incluído no projeto)

## 🚀 Instalação

1. **Clone o repositório** (ou baixe o projeto)

2. **O projeto já inclui o Gradle Wrapper**, então não é necessário instalar o Gradle separadamente.

## ▶️ Execução

A aplicação estará disponível em: **http://localhost:8080**

### Executar os testes

#### Windows:
```bash
.\gradlew.bat test
```

#### Linux/Mac:
```bash
./gradlew test
```

### Compilar o projeto

#### Windows:
```bash
.\gradlew.bat build
```

#### Linux/Mac:
```bash
./gradlew build
```

## 📡 Endpoints da API

A API está disponível na base URL: `http://localhost:8080/livros`

### 1. Cadastrar Livro
```http
POST /livros
Content-Type: application/json

{
  "title": "Dom Casmurro",
  "author": "Machado de Assis",
  "isbn": "978-85-359-0277-5",
  "publicationYear": 1899,
  "stockQuantity": 10
}
```

**Resposta:** `201 Created`

### 2. Listar Todos os Livros
```http
GET /livros
```

**Resposta:** `200 OK` - Lista de todos os livros

### 3. Buscar Livro por ID
```http
GET /livros/{id}
```

**Exemplo:** `GET /livros/1`

**Resposta:** `200 OK` - Dados do livro

### 4. Buscar Livro por ISBN
```http
GET /livros/isbn/{isbn}
```

**Exemplo:** `GET /livros/isbn/978-85-359-0277-5`

**Resposta:** `200 OK` - Dados do livro

### 5. Atualizar Livro
```http
PUT /livros/{id}
Content-Type: application/json

{
  "title": "Dom Casmurro - Edição Especial",
  "author": "Machado de Assis",
  "publicationYear": 1899,
  "stockQuantity": 15
}
```

**Resposta:** `200 OK` - Livro atualizado

**Nota:** O ISBN não pode ser alterado após a criação.

### 6. Remover Livro
```http
DELETE /livros/{id}
```

**Resposta:** `204 No Content`

## 🧪 Testando a API

### Usando cURL

#### Criar um livro:
```bash
curl -X POST http://localhost:8080/livros \
  -H "Content-Type: application/json" \
  -d "{\"title\":\"Dom Casmurro\",\"author\":\"Machado de Assis\",\"isbn\":\"978-85-359-0277-5\",\"publicationYear\":1899,\"stockQuantity\":10}"
```

#### Listar todos os livros:
```bash
curl http://localhost:8080/livros
```

#### Buscar por ID:
```bash
curl http://localhost:8080/livros/1
```

#### Buscar por ISBN:
```bash
curl http://localhost:8080/livros/isbn/978-85-359-0277-5
```

#### Atualizar livro:
```bash
curl -X PUT http://localhost:8080/livros/1 \
  -H "Content-Type: application/json" \
  -d "{\"title\":\"Dom Casmurro - Edição Especial\",\"author\":\"Machado de Assis\",\"publicationYear\":1899,\"stockQuantity\":15}"
```

#### Remover livro:
```bash
curl -X DELETE http://localhost:8080/livros/1
```

### Usando Postman ou Insomnia

Importe a coleção de endpoints ou crie manualmente as requisições conforme os exemplos acima.

## 🗄️ Banco de Dados H2

O projeto utiliza o banco de dados H2 em memória. Para acessar o console do H2:

1. Execute a aplicação
2. Acesse: **http://localhost:8080/h2-console**
3. Configure a conexão:
   - **JDBC URL:** `jdbc:h2:mem:livrosdb`
   - **User Name:** `sa`
   - **Password:** (deixe em branco)
   - Clique em **Connect**

## 🏗️ Arquitetura em Camadas

O projeto segue uma arquitetura em 4 camadas:

1. **Interface (API)**: `controllers/` - Endpoints REST
2. **Aplicação**: `application/` - Regras de controle e transações
3. **Domínio**: `domain/` - Modelo de negócio e interfaces de repositório
4. **Infraestrutura**: `infrastructure/` - Implementação de repositórios e acesso ao banco

## ✅ Validações Implementadas

- ✅ ISBN deve ser único (não permite cadastrar livro com ISBN duplicado)
- ✅ Validação de existência antes de remover livro
- ✅ Validação de existência antes de atualizar livro
- ✅ Tratamento de exceções personalizadas

## 🐛 Tratamento de Erros

A API retorna exceções apropriadas:

- **BookNotFoundException**: Quando um livro não é encontrado (ID ou ISBN)
- **BookAlreadyExistsException**: Quando tenta cadastrar um livro com ISBN já existente

## 📝 Notas Importantes

- O banco de dados H2 é em memória, então os dados são perdidos ao reiniciar a aplicação
- O ISBN não pode ser alterado após a criação do livro
- Todos os campos são obrigatórios (não permite valores nulos)

## 👨‍💻 Desenvolvido por

Rainan Jorge

---

**Projeto acadêmico** - Disciplina de Desenvolvimento de Aplicações Corporativas