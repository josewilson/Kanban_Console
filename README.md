# 🗂️ Kanban Console Backend

Aplicação **Kanban de linha de comando (CLI)** robusta para gerenciamento de quadros e cartões, construída em **Java 17** com **Spring Boot**.  
O projeto demonstra domínio em **arquitetura em camadas**, **persistência com Spring Data JPA**, **migração de banco de dados com Liquibase** e **interface interativa no terminal**.

---

## 📋 Índice
- [💻 Sobre o Projeto](#-sobre-o-projeto)
- [✨ Funcionalidades](#-funcionalidades)
- [🛠 Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [🏛 Arquitetura](#-arquitetura)
- [🚀 Como Executar](#-como-executar)
  - [Pré-requisitos](#pré-requisitos)
  - [Passos de Instalação](#-passos-de-instalação)
- [📈 Melhorias Futuras](#-melhorias-futuras)
- [👨‍💻 Autor](#-autor)
- [📄 Licença](#-licença)

---

## 💻 Sobre o Projeto
Este projeto implementa um **quadro Kanban funcional no console**, com suporte para múltiplos quadros (ex: *A Fazer*, *Em Andamento*, *Concluído*) e movimentação de cartões entre eles.  

Diferenciais:
- Arquitetura em camadas para melhor manutenibilidade.  
- Persistência em memória com **H2 Database**.  
- Migração de banco de dados versionada com **Liquibase**.  
- Menu interativo amigável no terminal.  

---

## ✨ Funcionalidades
- 📊 **Visualizar quadros e cartões** diretamente no terminal.  
- 📝 **Criar novos cartões** em qualquer quadro.  
- 🔄 **Mover cartões** entre colunas (*To Do*, *Doing*, *Done*).  
- 🖥 **Interface interativa** baseada em menu no console.  
- 💾 **Persistência temporária** em H2 (dados armazenados durante a execução).  

---

## 🛠 Tecnologias Utilizadas
- ☕ **Java 17**  
- 🚀 **Spring Boot**  
- 🗄 **Spring Data JPA**  
- 🐘 **H2 Database (in-memory)**  
- 🔧 **Liquibase**  
- ⚙️ **Gradle**  
- 📝 **Lombok**  

---

## 🏛 Arquitetura
A aplicação segue **arquitetura em camadas**, garantindo desacoplamento e boas práticas:  

- **UI (CommandLineRunner)** → interação com o usuário via console.  
- **Service Layer** → regras de negócio (CommandService e QueryService).  
- **Repository** → abstração da persistência com Spring Data JPA.  
- **Model/Entity** → mapeamento das entidades com JPA.  
- **DTOs** → transferência de dados entre camadas.  

---

## 🚀 Como Executar

### Pré-requisitos
- **Java 17+**  
- **Git**  
- **Gradle**  

### Passos de Instalação
```bash
# Clone o repositório
git clone https://github.com/josewilson/Kanban_Console_Backend.git

# Acesse o diretório
cd Kanban_Console_Backend

# Compile e rode
./gradlew bootRun 



###📌 No Windows, execute antes:
chcp 65001
para garantir a exibição correta de acentuação.

