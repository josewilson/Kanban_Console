# 📌 Kanban Console 

[![Java](https://img.shields.io/badge/Java-17-blue?logo=java)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2-green?logo=springboot)](https://spring.io/projects/spring-boot)
[![H2 Database](https://img.shields.io/badge/H2-Database-blue?logo=h2database)](http://www.h2database.com/html/main.html)
[![Gradle](https://img.shields.io/badge/Gradle-7.6-blue?logo=gradle)](https://gradle.org/)
[![MIT License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)

Uma aplicação **CLI (Command Line Interface)** para gerenciamento de quadros Kanban, construída com **Java 17** e **Spring Boot**.  
Demonstra **arquitetura em camadas**, integração com banco de dados **H2** versionado via **Liquibase**, e uma interface interativa no terminal.

---

## 📋 Sobre o Projeto

Este projeto simula um **quadro Kanban** diretamente no terminal, com funcionalidades como:

- Criação de quadros: `A Fazer`, `Em Andamento`, `Concluído`.  
- Criação e movimentação de cartões entre quadros.  
- Persistência de dados em memória (H2) com versionamento via Liquibase.

O objetivo é demonstrar **boas práticas de back-end**, incluindo:

- Arquitetura organizada: UI, Service, Repository, Model, DTO  
- Persistência com **Spring Data JPA + H2**  
- Versionamento de banco com **Liquibase**  
- Build automatizado com **Gradle**

---

## ✨ Funcionalidades

- 📋 Visualização completa de **quadros e cartões**  
- ➕ Criação de **cards** em qualquer quadro  
- 🔄 Movimentação de **cards** entre quadros  
- 🖥️ Interface interativa via menu no console  
- 💾 Persistência em memória (H2) com versionamento via Liquibase

---

## 🛠️ Tecnologias

- ☕ Java 17  
- 🚀 Spring Boot 3.2  
- 🗄️ Spring Data JPA  
- 🛢️ H2 Database  
- 🔄 Liquibase  
- 📦 Gradle 7.6  
- 🧰 Lombok  

---

## 🏛️ Arquitetura em Camadas

- **UI (Interface do Usuário)**
  - Interação via console (**CommandLineRunner**)

- **Service**
  - Regras de negócio
  - **QueryService** → consultas
  - **CommandService** → ações

- **Repository**
  - Abstração de dados com Spring Data JPA

- **Model**
  - Entidades persistidas no banco

- **DTO**
  - Transferência segura de dados entre camadas



---

## 🚀 Como Executar

### Pré-requisitos

- JDK 17+ → [Download](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)  
- Git → [Instalação](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

### Clonar e Compilar

```bash
git clone https://github.com/josewilson/Kanban_Console_Backend.git
cd Kanban_Console_Backend
./gradlew build
```

### Executar
```bash
./gradlew bootRun
```


### 📌 Nota (Windows): antes de rodar, execute:
```bash
chcp 65001 
```


## 🎮 Como Utilizar

Digite 1 → Lista todos os quadros e cartões

Digite 2 → Cria um novo cartão

Digite 3 → Move cartões entre quadros

## 🖼️ Demonstração da Interface

## 📊 Exemplo de Dados (Tabela)

#### Boards

| ID | Nome         |
| -- | ------------ |
| 1  | A Fazer      |
| 2  | Em Andamento |
| 3  | Concluído    |

##### Cards

| ID | Título          | Board        | Descrição          |
| -- | --------------- | ------------ | ------------------ |
| 1  | Criar README    | A Fazer      | Escrever README.md |
| 2  | Implementar CLI | Em Andamento | Menu interativo    |
| 3  | Testar App      | Concluído    | Testes unitários   |

## 📊 Visualizar Dados no Banco (H2 Console)

### Ative no application.properties:
```bash
spring.h2.console.enabled=true
```
### Rode a aplicação:
```bash
./gradlew bootRun
```
### Acesse no navegador:

👉 http://localhost:8080/h2-console

### JDBC URL:
```bash
jdbc:h2:mem:kanbandb
```
### Exemplo de consultas SQL:
```bash
SELECT * FROM BOARD;
SELECT * FROM CARD;
```

## 👨‍💻 Autor

José Wilson – Desenvolvedor Backend Júnior

-📌 [LinkedIn](https://www.linkedin.com/in/jose-wilson-alves-de-souza/)
-📌 [GitHub](https://github.com/josewilson)

## 📄 Licença

Este projeto está sob a licença MIT e pode ser usado para estudos e práticas.
