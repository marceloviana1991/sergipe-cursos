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
| POST | cadastrarAluno |application/json | application/json | |
| GET | listarAlunos | |  application/json | |
| GET | detalharAluno  | | application/json | ```{id}``` |
| DELETE | excluirAluno |  | | ```{id}```  |
| PUT | atualizarAluno | application/json | application/json | ```{id}```  |


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
    "id": Long,
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
| POST | cadastrarCurso |application/json | application/json | |
| GET | listarCursos | |  application/json | |
| GET | detalharCurso  | | application/json | ```{id}``` |
| DELETE | excluirCurso |  | | ```{id}```  |
| PUT | atualizarCurso | application/json | application/json | ```{id}```  |


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
    "id": Long,
    "nome": "String",
    "descricao": "String",
    "vagas": Integer
}
```
