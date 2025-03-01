# System Monitor APIs 

Este projeto consiste em um scritp para fazer um monitoramento simples de três domínios.

- [YouTube](https://youtube.com)
- [Google](https://google.com)
- [HTTPBin](https://httpbin.org/get)

Basicamente o objetivo aqui é aprender como funciona a classe `HttpClient` do Java para utilizá-la
em um próximo projeto, que talvez seja a versão 2.0 deste ou um novo projeto com Spring onde o usuário
poderá via `curl` ou `Postman` 

- Adicionar URLs
- Remover URLs
- Atualizar URLs
- Definir tempos personalizados de timeout
- Definir o status code esperado para a API ou domínio.

## Requisitos para executar o script

Lembre-se que para executar o script é necessário ter a `JDK - Java Development Kit` e também o `Docker` para rodar o banco PostgreSQL.

## Estrutura do banco

Passo a passo 

1. Crie um database com o comando:
```
CREATE DATABASE monitoramento;
```

2. Acesse o database.
```declarative
\c monitoramento;
```

3. Crie uma tabela com o comando:
```
CREATE TABLE monitoramento_apis (
    id SERIAL NOT NULL,
    url VARCHAR(50) NOT NULL,
    status_code INTEGER NOT NULL
);
```

## Como executar o scritp

1. Clone o repositório na sua máquina:

```
git clone https://github.com/paulo-fabiano/java-monitor_apis.git
```

2. Acesse o repositório

```
cd java-monitor_apis
```

2. Compile o script

```
javac Main.java
```

3. Execute o script

```
java -cp ".:postgresql-42.7.3.jar" Main
```

Com esses passos já é possível executar o script.

## Dúvidas ou Sugestões?

Entre em contato comigo via:

- [Linkedin](https://www.linkedin.com/in/paulo-fabiano)
- [Email](mailto:pfabianof@gmail.com)
