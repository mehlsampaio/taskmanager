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

| Campo        | Tipo       | Observações                        |
|--------------|------------|------------------------------------|
| id           | Long       | Auto-increment                     |
| nome         | String     | Obrigatório, até 60 caracteres     |
| dataEntrega  | LocalDate  | Obrigatório, formato `yyyy-MM-dd`  |
| responsavel  | String     | Obrigatório, até 60 caracteres     |

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


### Cadastrar Tarefa
- Método: `POST`
- URL: `http://localhost:8080/tarefas`
- Body (JSON):
```json
{
  "nome": "Estudar Spring Boot",
  "responsavel": "Mehl",
  "dataEntrega": "2025-08-28"
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
  "responsavel": "Mehl",
  "dataEntrega": "2025-08-28"
}
```

### Deletar Tarefa
- Método: `DELETE`
- URL: `http://localhost:8080/tarefas?id={id}`
- Query Parameter:

| Name | Value        |
|------|--------------|
| `id` | `1` (exemplo)|
