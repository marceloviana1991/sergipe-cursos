# Sergipe-Cursos

O projeto Sergipe-Cursos consiste no desenvolvimento de uma API Rest que se baseia nos conceitos de Clean Architecture.

![CleanArchitecture](CleanArchitecture.jpg)


### Idealização do Sistema

O sistema idealizado para a implementação do projeto consiste basicamente em um sistema de matriculas com entidades aluno e curso que possuem relacionamento de matrícula.


### Proposta do Repositório

A proposta do repositório é disponibilizar o código fonte do projeto e compartilhar as lógicas programação utilizadas na implementação do sistema.


# Documentação da API

API Rest responsável pelo gerenciamento de sistema de matriculas em escola de cursos.


### Informações Gerais

- Registra dados pessoais do aluno
- Registra informações do curso
- Cria relacionamento (N:N) de matrícula entre aluno e curso 


## Alunos

Recurso responsável pelo registro de dados pessoais dos alunos


### URL base para chamadas

```
http://localhost:8080/alunos
```


### Endpoints

| Método | Nome do endpoint |Body Request | Body Response | Path Variable
|-----------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------| -----------------------------------------------------------------------------------------------------------------|
| POST | cadastrar |application/json | application/json | |
| GET | listar | |  application/json | |
| PUT | atualizarDados | application/json |  | |


### Body Content
```
Resquest
{
    "cpf": "String (ddd.ddd.ddd-dd)",
    "nome": "String",
    "nascimento": "String (YYYY-MM-DD)",
    "email": "String (máscara padrão de email)"
}
```
```
Response
{
    "cpf": "String (ddd.ddd.ddd-dd)",
    "nome": "String",
    "nascimento": "String (YYYY-MM-DD)",
    "email": "String (máscara padrão de email)"
}
```


## Cursos

Recurso responsável pelo registro de dados dos cursos ofertados


### URL base para chamadas

```
http://localhost:8080/cursos
```


### Endpoints

| Método | Nome do endpoint |Body Request | Body Response | Path Variable
|-----------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------| -----------------------------------------------------------------------------------------------------------------|
| POST | cadastrar |application/json | application/json | |
| GET | listarAtivos | |  application/json | |
| PUT | atualizarDados | application/json |  | |
| PUT | desativar | | | ```{turma}```  |


### Body Content
```
Resquest
{
    "nome": "String",
    "descricao": "String",
    "vagas": Integer
}
```
```
Response
{
    "turma": "String",
    "nome": "String",
    "descricao": "String",
    "vagas": Integer
}
```

## Matricula

Recurso responsável pelo registro de relacionamento de matricula entre os recursos de curso e aluno


### URL base para chamadas

```
http://localhost:8080/matriculas
```


### Endpoints

| Método | Nome do endpoint |Body Request | Body Response | Path Variable
|-----------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------| -----------------------------------------------------------------------------------------------------------------|
| POST | cadastrar |application/json | application/json | |
| GET | listar | |  application/json | |



### Body Content

```
Resquest
{
    "cpfAluno": "String",
    "turmaCurso": "String"
}
```
```
Response
{
    "cpfAluno": "String",
    "turmaCurso": "String"
}
```


# Guia de Início Rápido

*Requerimentos do projeto Sergipe Cursos*

- Java versão 21
- SGBD Postgresql (versão compatível com Spring Boot 3.4.0)
- Maven (versão compatível com Spring Boot 3.4.0)


*Variáveis de ambiente para configuração de conexão com SGBD*

- DB_HOST
- DB_DOOR
- USER_NAME_DB
- PASSWORD_DB





