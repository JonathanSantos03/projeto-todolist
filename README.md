# To-Do List API

## Descrição
Este projeto é uma API de lista de tarefas desenvolvida em **Java** utilizando **Spring Boot**. A API permite o cadastro de usuários, autenticação, criação e manipulação de tarefas, garantindo que apenas o próprio usuário possa modificar suas tarefas.

## Tecnologias Utilizadas
- **Java**
- **Spring Boot**
- **Spring Security** (autenticação e controle de acesso)
- **Banco H2** (banco em memória para testes)
- **BCrypt** (criptografia de senhas)
- **Maven** (gerenciamento de dependências)
- **API Dog** (para integração externa)
- **Docker** (deploy)

## Estrutura do Projeto
```
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com.jonathansantos.todolist
│   │   │   │   ├── errors (tratamento de exceções)
│   │   │   │   ├── filter (autenticação e segurança)
│   │   │   │   ├── task (funcionalidades de tarefas)
│   │   │   │   ├── user (cadastro e autenticação de usuários)
│   │   │   │   ├── utils (funções auxiliares)
│   │   │   │   ├── TodoListApplication.java (classe principal)
│   ├── resources
│   ├── test (testes unitários)
│
├── pom.xml (dependências Maven)
├── Dockerfile (configuração para deploy com Docker)
└── README.md (este arquivo)
```

## Como Rodar o Projeto

### 1. Clonar o Repositório
```sh
git clone https://github.com/seu-usuario/todolist.git
cd todolist
```

### 2. Construir o Projeto
```sh
mvn clean install
```

### 3. Rodar a API
```sh
mvn spring-boot:run
```
A API estará disponível em `http://localhost:8080`

### 4. Rodar a API Externamente
Além do ambiente local, você pode testar a API em serviços externos:

- **API Dog** (exemplo usado no projeto): `https://projeto-todolist-cvtj.onrender.com/tasks/`
- **Postman Mock Server** (para simulação de endpoints)
- **NGROK** (exposição do ambiente local para testes externos)
- **Heroku / Render** (deploy gratuito)

## Endpoints

### Autenticação
- `POST /users/register` - Cadastro de usuários
- `POST /users/login` - Login de usuários

### Tarefas
- `POST /tasks` - Criar uma nova tarefa
- `GET /tasks` - Listar tarefas do usuário logado
- `PUT /tasks/{id}` - Atualizar uma tarefa (somente o dono pode modificar)
- `DELETE /tasks/{id}` - Deletar uma tarefa (somente o dono pode deletar)

## Segurança e Autenticação
A API utiliza **Basic Authentication** e criptografia de senha com **BCrypt**.
Cada requisição protegida exige um cabeçalho `Authorization` com credenciais codificadas em Base64.

## Deploy com Docker
Para rodar via Docker:
```sh
docker build -t todolist .
docker run -p 8080:8080 todolist
```

## Autor
**Jonathan Santos**  
[LinkedIn](https://www.linkedin.com/in/jonathan-santos-130634287/) | [GitHub](https://github.com/JonathanSantos03)



