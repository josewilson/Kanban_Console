# Aplicação Kanban de Console

> Uma aplicação de linha de comando (CLI) robusta para gerenciamento de um quadro Kanban, construída com Java e o ecossistema Spring Boot.

Este projeto demonstra uma arquitetura de software em camadas, gerenciamento de banco de dados com Liquibase e uma interface de usuário interativa baseada em texto.


Aplicação Kanban de Console
Uma aplicação de linha de comando (CLI) robusta para gerenciamento de um quadro Kanban, construída com Java e o ecossistema Spring Boot.

Este projeto demonstra uma arquitetura de software em camadas, gerenciamento de banco de dados com Liquibase e uma interface de usuário interativa baseada em texto.


*(**Instrução:** Tire uma captura de tela do seu terminal rodando a aplicação, suba a imagem para o seu repositório GitHub e substitua esta linha pela URL da imagem)*

![Screenshot da Aplicação](URL_DA_SUA_IMAGEM_AQUI)

📋 Sobre o Projeto
Esta aplicação simula um quadro Kanban diretamente no seu terminal. Ela permite a criação de múltiplos quadros (ex: "A Fazer", "Em Andamento", "Concluído") e a criação e movimentação de cartões entre eles. Todos os dados são gerenciados por um banco de dados em memória (H2), cuja estrutura é criada e versionada pela ferramenta de migração Liquibase.

O foco do projeto é demonstrar uma arquitetura back-end sólida e desacoplada, mesmo em uma aplicação de console.

✨ Funcionalidades
Visualização Completa: Exibe todos os quadros e seus respectivos cartões em um formato de fácil leitura.

Criação de Cards: Permite adicionar novos cartões a qualquer quadro existente.

Movimentação de Cards: Funcionalidade para mover um cartão de um quadro para outro.

Interface Interativa: Um menu simples e navegável para interagir com o sistema.

Persistência de Dados: Utiliza um banco de dados em memória (H2) para persistir os dados durante a execução da aplicação.

🛠️ Tecnologias Utilizadas
Este projeto foi construído utilizando um stack de tecnologias moderno e robusto, padrão no mercado de desenvolvimento Java.

Java 17

Spring Boot: Framework principal para acelerar o desenvolvimento e a configuração.

Spring Data JPA: Para a camada de persistência de dados de forma simplificada.

Gradle: Ferramenta de automação de build.

H2 Database Engine: Banco de dados relacional em memória para desenvolvimento e testes.

Liquibase: Para gerenciamento e versionamento de migrações de banco de dados.

Lombok: Para reduzir a verbosidade do código Java (boilerplate).

🏛️ Arquitetura
O projeto segue uma arquitetura em camadas bem definida para garantir a separação de responsabilidades e a manutenibilidade do código:

UI (Interface do Usuário): Camada responsável pela interação com o usuário via console, implementada com um CommandLineRunner do Spring Boot.

Service (Serviço): Contém a lógica de negócio da aplicação. Utiliza um padrão semelhante ao CQRS (Command Query Responsibility Segregation) para separar serviços de consulta (QueryService) e de modificação (CommandService).

Repository (Repositório): Camada de acesso a dados, utilizando interfaces do Spring Data JPA para abstrair as operações de banco de dados.

Model (Modelo/Entidade): Classes que representam as entidades do banco de dados, anotadas com JPA.

DTO (Data Transfer Object): Objetos simples para transferir dados entre as camadas de forma segura e desacoplada.

🚀 Como Executar e Utilizar o Projeto
Siga os passos abaixo para compilar, executar e interagir com a aplicação em sua máquina local.

Pré-requisitos
Java Development Kit (JDK) 17 ou superior.

Git para clonar o repositório.

Passo 1: Obter e Construir o Projeto
Clone o repositório para sua máquina local:

Bash

git clone [https://github.com/josewilson/Kanban_Console_Backend](https://github.com/josewilson/Kanban_Console_Backend)
Navegue até o diretório raiz do projeto:

Bash

cd kanban-console
(Opcional) Construa o arquivo JAR executável:

Bash

./gradlew build
Passo 2: Executar a Aplicação
Você pode executar a aplicação de duas formas. Para interagir pelo console, o método bootRun é o mais direto.

Nota Importante para Usuários Windows: Para garantir a exibição correta de acentos, execute o seguinte comando no seu terminal (CMD) antes de rodar a aplicação: chcp 65001

Bash

# Execute este comando para iniciar a aplicação interativa
./gradlew bootRun
Após executar, o menu principal da aplicação aparecerá no seu terminal.

Passo 3: Interagindo e Visualizando os Dados na Aplicação
Uma vez que a aplicação esteja rodando, você pode usar os seguintes comandos no menu:

Para Visualizar os Dados:

Digite 1 e pressione Enter.

O console irá listar todos os quadros ("A Fazer", "Em Andamento", "Concluído") e os cartões que estiverem dentro de cada um.

Para Adicionar Novos Dados (Cards):

Digite 2 e pressione Enter.

Siga as instruções, fornecendo um título para o novo cartão e o ID do quadro onde ele deve ser criado.

Após a criação, você receberá uma mensagem de sucesso.

Para Verificar a Integração:

Após criar um ou mais cartões, use a opção 1 novamente. Você verá seus novos cartões listados sob os quadros corretos. Isso prova que os dados foram salvos e recuperados do banco de dados em memória.

(Avançado) Visualizando os Dados Diretamente no Banco (H2 Console)
Para inspecionar o banco de dados em tempo real e ver as tabelas e os dados diretamente, você pode habilitar o console web do H2.

Habilite o Console:

Adicione a dependência implementation 'org.springframework.boot:spring-boot-starter-web' ao seu arquivo build.gradle.

Adicione a linha spring.h2.console.enabled=true ao seu arquivo src/main/resources/application.properties.

Execute a Aplicação:

Rode ./gradlew bootRun. O servidor web será iniciado.

Acesse o Banco de Dados:

Abra seu navegador e vá para http://localhost:8080/h2-console.

Na tela de login, certifique-se de que o campo JDBC URL está com o valor jdbc:h2:mem:kanbandb e clique em Connect.

Consulte os Dados:

Dentro do console, você pode executar comandos SQL para ver o estado real dos seus dados. Por exemplo:

SQL

-- Para ver todos os quadros
SELECT * FROM BOARD;

-- Para ver todos os cartões
SELECT * FROM CARD;
Isso lhe dará uma visão completa da integração entre sua aplicação e o banco de dados.

📄 Licença
Este projeto está sob a licença MIT.
