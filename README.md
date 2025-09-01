# Task Manager ✅

Um projeto backend em **Spring Boot** para gerenciar tarefas, permitindo criar, listar, atualizar e deletar tarefas com **persistência em banco de dados MySQL**.

## Status do Projeto
🚧 Em andamento — atualmente funcionando apenas o backend.  
💡 Futuramente pretendo desenvolver um **frontend** para integrar com a aplicação.


## Tecnologias utilizadas 🛠
- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Postman (para testes)

## Funcionalidades 💡
- **Criar tarefa** (`POST /tarefas`)
- **Listar todas as tarefas** (`GET /tarefas`)
- **Buscar tarefa por id** (`GET /tarefas/{id}`)
- **Atualizar tarefa** (`PUT /tarefas/{id}`)
- **Deletar tarefa** (`DELETE /tarefas/{id}`)

Cada tarefa possui os campos:

| Campo        | Tipo       | Observações                   |
|--------------|------------|-------------------------------|
| id           | Long       | Auto-increment                |
| nome         | String     | Obrigatório, até 60 caracteres |
| dataEntrega  | LocalDate  | Obrigatório, formato `yyyy-MM-dd` |
| responsavel  | String     | Obrigatório, até 60 caracteres |

## Configuração do projeto ⚙
1. Clone o repositório:
```bash
git clone https://github.com/mehlsampaio/taskmanager.git
````
2. Configure o banco de dados no **application.properties**:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```
3. Rode a aplicação:
```bash
mvn spring-boot:run
```

## Testes com Postman ✔
- A coleção do Postman está disponível em `/postman/taskmanager-collection.json`.
- Para usar:
  - Abra o Postman
  - Clique em **Import**
  - Selecione o arquivo da pasta `/postman`
  - Rode as requisições de teste 🚀

### Cadastrar Tarefas 
- Método: POST
- URL: http://localhost:8080/tarefas
- Header: Content-Type: application/json
- Body (raw → JSON):
```bash
{
  "nome": "Estudar Spring Boot",
  "responsavel": "Mehl",
  "dataEntrega": "2025-08-28"
}
```

### Listar Tarefas
- Método: GET
- URL: `http://localhost:8080/tarefas`

### Buscar Tarefas por ID
- Método: GET
- URL: `http://localhost:8080/tarefas/{id}`

### Atualizar Tarefas
- Método: PUT
- URL: `http://localhost:8080/tarefas/{id}`
- Header: Content-Type: application/json
- Body (raw → JSON):
```bash
{
  "nome": "Estudar Spring Boot - Atualizado",
  "responsavel": "Mehl",
  "dataEntrega": "2025-08-28"
}
```
### Excluir Tarefas
- Método: DELETE
- URL: `http://localhost:8080/tarefas/{id}`







