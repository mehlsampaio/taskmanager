<h1 align="center">taskmanager📋</h1>
<p align="center">
<img alt="Static Badge" src="https://img.shields.io/badge/Java-21-orange">
<img alt="Static Badge" src="https://img.shields.io/badge/Spring_Boot-green">
<img alt="Static Badge" src="https://img.shields.io/badge/Spring_JPA-green">
<img alt="Static Badge" src="https://img.shields.io/badge/MySQL-blue">
<img alt="Static Badge" src="https://img.shields.io/badge/Bruno-black">
</p>

<p align="center">API REST de gerenciamento de tarefas com persistência em banco de dados.</p> 

<h2 align="center">Funcionalidades</h2>
<p align="center">
• Criar Tarefa<br>
• Buscar Tarefas por Id<br>
• Atualizar Tarefa<br>
• Deletar Tarefa 
</p>

<h1></h1>

<div align="center">

| Campo        | Tipo       | Observações                       |
|--------------|------------|-----------------------------------|
| id           | Long       | Auto-increment                    |
| nome         | String     | Obrigatório, até 60 caracteres    |
| dataEntrega  | LocalDate  | Obrigatório, formato `yyyy-MM-dd` |
| responsavel  | String     | Obrigatório, até 60 caracteres    |
| prioridade   | Enum       | Obrigatório, `[ALTA, MEDIA, BAIXA]` |
| statusTarefa | Enum       | Obrigatório, `[NOVO, EM_ANDAMENTO, CONCLUIDA, CANCELADA, ATRASADA]`|
</div>

<h2 align="center">Como Executar</h2>
<p>
1. Clone o repositório: <br>
<pre><code>git clone https://github.com/mehlsampaio/taskmanager.git</code></pre>
</p>

<p>
2. Configure o banco de dados no <strong>application.properties</strong>: <br>
<pre><code>spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha</code></pre>
</p>

<p>
3. Rode a aplicação:
<pre><code>mvn spring-boot:run
</code></pre>
</p>

<h2 align="center">Testes com Bruno</h2>
<p align="center"><strong>A coleção de testes do Bruno está disponível em <code>/bruno</code></strong>
</p> 

### Como executar os testes
1. Baixe e instale o Bruno em: https://www.usebruno.com/
2. Abra o aplicativo Bruno
3. Clique em: `` Open Collection ``
4. Selecione a pasta do projeto `` /bruno ``
5. O Bruno irá carregar automaticamente todas as requisições da API.


> Para rodar as requisições de teste dos endpoints, acesse: **/bruno/taskmanager-endpoints**.
### Cadastrar Tarefa
- Método: `POST`
- URL: `http://localhost:8080/tarefas`
- Body (JSON):
```json
{
  "nome": "Estudar Spring Boot",
  "dataEntrega": "2026-06-03",
  "responsavel": "Mehl",
  "prioridade": "MEDIA",
  "statusTarefa": "EM_ANDAMENTO"
}
```

### Buscar Tarefa por ID
- Método: `GET`
- URL: `http://localhost:8080/tarefas?id={id}`
- Query Parameter:

| Name | Value        |
|------|--------------|
| `id` | `1` (exemplo)|

### Atualizar Tarefa
>Este endpoint permite atualização parcial de dados. Campos não informados na requisição não serão modificados.
- Método: `PUT`
- URL: `http://localhost:8080/tarefas?id={id}`
- Query Parameter:

| Name | Value        |
|------|--------------|
| `id` | `1` (exemplo)|
- Body (JSON):
```json
{
  "nome": "Estudar Spring Boot - Atualizado",
  "prioridade": "ALTA"
}
```

### Deletar Tarefa
- Método: `DELETE`
- URL: `http://localhost:8080/tarefas?id={id}`
- Query Parameter:

| Name | Value        |
|------|--------------|
| `id` | `1` (exemplo)|

<h2 align="center">Exemplo de Response</h2>
> Você pode rodar as requisições de teste de exceções em **/bruno/taskmanager-exceptions**.

### ❌ 404 : Recurso não encontrado
> Ocorre quando uma tarefa solicitada não é encontrada. Afeta métodos **GET**, **PUT** e **DELETE**.
```json
{ 
  "erro":"Tarefa não encontrada.",
  "mensagem":"Recurso não encontrado",
  "status":404,
  "timestamp":"2026-06-04T15:46:41.643564938"
}
```

### ❌ 400: Erro de validação do campo
> Ocorre quando algum campo está nulo, vazio, excede o limite de caracteres ou quando a data de entrega é inválida (passada). Afeta Métodos **POST**, **PUT** e **GET**.
```json
{"mensagem":"Erro de validação do campo",
  "erros":[{"mensagem":"O campo nome deve conter no máximo 60 caracteres.", 
    "campo":"nome"}],
  "status":400,
  "timestamp":"2026-06-04T15:44:46.20525495"}
```
```json
{"mensagem":"Erro de validação do campo",
  "erros":[{"mensagem":"A data de entrega não pode ser no passado.",
    "campo":"dataEntrega"}],
  "status":400,
  "timestamp":"2026-06-04T15:39:28.397174806"}
```
```json
{"mensagem":"Erro de validação do campo",
  "erros":[{"mensagem":"O campo responsavel é obrigatório.",
    "campo":"responsavel"}],
  "status":400,
  "timestamp":"2026-06-04T15:34:44.397899168"}
```
### ✅ 201 Created
> Ocorre quando uma requisição **POST** foi bem sucedida.
```json
{
  "id": 4,
  "nome": "Assistir aulas do curso de C#",
  "dataEntrega": "2026-07-03",
  "responsavel": "Joana",
  "prioridade": "ALTA",
  "statusTarefa": "EM_ANDAMENTO"
}
```

### ✅ 204 No Content
> Ocorre quando uma requisição **DELETE** foi bem sucedida.

### ✅ 200 OK
> Requisições **PUT** e **GET** bem sucedidas.
```json
{
  "id": 3,
  "nome": "Realizar testes com Bruno",
  "dataEntrega": "2026-06-04",
  "responsavel": "Mehl",
  "prioridade": "ALTA",
  "statusTarefa": "CANCELADA"
}
```

