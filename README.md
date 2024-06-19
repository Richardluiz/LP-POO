# **Loja de Jogos PS4**

![MALIKK](https://github.com/Richardluiz/LP-POO/assets/80009434/0912e8c9-9cde-4943-991b-466488205def)




> **Aplicação Java com Interface Gráfica (Swing) e Banco de Dados SQLite.**

![Badge de Status](https://img.shields.io/badge/status-em%20desenvolvimento-brightgreen) ![Badge de Versão](https://img.shields.io/badge/vers%C3%A3o-1.0.0-blue)

## **Índice**

- [Sobre](#sobre)
- [Estrutura do Código](#estrutura-do-código)
- [Pré-requisitos](#pré-requisitos)
- [Instalação](#instalação)
- [Funcionamento](#funcionamento)
- [Próximos Passos](#próximos-passos)
- [Observações](#observações)

## **Sobre**

Este projeto implementa uma loja de jogos PS4 simples com interface gráfica usando Java Swing e banco de dados SQLite. A aplicação permite aos usuários navegar por uma vitrine de jogos, adicionar itens ao carrinho de compras, fazer login, cadastrar novos usuários e gerenciar seus dados.

## **Estrutura do Código**

O código é dividido em várias classes:

- **Home**: Classe principal que cria a tela inicial da loja, exibindo a vitrine de jogos.
- **Produto**: Classe que representa um jogo da loja, contendo informações como nome, preço, gênero e quantidade em estoque.
- **Login**: Classe que cria a tela de login. Permite que usuários existentes façam login e redireciona para a tela Home.
- **Cadastro**: Classe que cria a tela de cadastro. Permite que novos usuários se registrem com informações como nome, email, senha, CEP e CPF.
- **Carrinho**: Classe que cria a tela do carrinho de compras, exibindo os jogos adicionados pelo usuário.
- **TelaPagamento**: Classe (não implementada) que seria responsável pela tela de pagamento, mas ainda não está implementada neste projeto.
- **BDTelaLogin**: Classe (não implementada) que seria responsável por lidar com a conexão ao banco de dados e a verificação de credenciais.

## **Pré-requisitos**

- Java Development Kit (JDK) instalado.
- Driver JDBC SQLite: [SQLite JDBC Driver](https://www.sqlite.org/jdbc.html)
- Um IDE Java (como [Eclipse](https://www.eclipse.org/), [IntelliJ IDEA](https://www.jetbrains.com/idea/), [NetBeans](https://netbeans.apache.org/)).

## **Instalação**

### **Passos para a instalação**

1. **Baixe o driver JDBC SQLite**:
   Faça o download do driver JDBC SQLite e adicione o arquivo JAR ao classpath do seu projeto Java.

2. **Crie o banco de dados SQLite**:
   Crie um arquivo chamado `BD.db` na pasta `src/bd` do seu projeto.

3. **Crie a tabela `users`**:
   Execute o seguinte comando SQL no SQLite Database Browser (ou similar) para criar a tabela `users`:

    ```sql
    CREATE TABLE users (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        nome TEXT NOT NULL,
        email TEXT NOT NULL UNIQUE,
        senha TEXT NOT NULL,
        cep TEXT,
        cpf TEXT
    );
    ```

4. **Compile e execute o código**:
   Compile e execute a classe `Login` para iniciar a aplicação.

## **Funcionamento**

### **Tela de Login**

- Os usuários podem inserir seus dados de login (email e senha) e clicar em "Entrar".
- Se as credenciais estiverem corretas, a tela Home será exibida.
- Se as credenciais estiverem incorretas, uma mensagem de erro será exibida.

### **Tela de Cadastro**

- Novos usuários podem preencher os campos de cadastro (nome completo, email, senha, CEP, CPF) e clicar em "Cadastrar".
- Se os dados estiverem corretos, o usuário será cadastrado no banco de dados, e a tela de login será exibida.
- Se os dados estiverem incorretos, uma mensagem de erro será exibida.

### **Tela Home**

- A tela Home exibe uma vitrine de jogos, mostrando imagens, nomes e preços.
- Os usuários podem clicar nos jogos para ver mais detalhes.
- Os usuários podem clicar no ícone do carrinho ou no botão "Carrinho" para ver os jogos adicionados ao carrinho.
- Os usuários podem clicar no botão "Login" para acessar a tela de login.

### **Tela do Carrinho**

- A tela do carrinho exibe os jogos que o usuário adicionou.
- Os usuários podem remover jogos do carrinho.
- (Em desenvolvimento) A tela de pagamento ainda não está implementada.

## **Próximos Passos**

- Implementar a tela de pagamento.
- Adicionar mais jogos à vitrine.
- Implementar a busca de jogos.
- Melhorar a interface gráfica da aplicação.
- Implementar mais funcionalidades, como:
  - Histórico de compras
  - Avaliação de jogos
  - Wishlist

## **Observações**

- Este código é um exemplo básico e pode ser expandido para incluir mais funcionalidades.
- A segurança não é abordada neste código, e as credenciais de login não estão protegidas.
- Você precisará ajustar o código de acordo com as suas necessidades específicas.
