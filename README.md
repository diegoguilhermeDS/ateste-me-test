
<img alt="logo-ateste-me" src="web/public/logo.png">

This project was developed by Ateste Me to test my ability in front and back.

<p align="center">
  <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/diegoguilhermeDS/ateste-me-test?color=%2304D361">

  <img alt="Repository size" src="https://img.shields.io/github/repo-size/diegoguilhermeDS/ateste-me-test">

  <a href="https://github.com/diegoguilhermeDS/ateste-me-test/commits/master">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/diegoguilhermeDS/ateste-me-test">
  </a>
  
  <a href="https://github.com/diegoguilhermeDS/ateste-me-test/blob/main/LICENSE">
    <img alt="License" src="https://img.shields.io/badge/license-MIT-brightgreen">
  </a>
   
   <a href="https://github.com/diegoguilhermeDS/ateste-me-test/stargazers">
    <img alt="Stargazers" src="https://img.shields.io/github/stars/diegoguilhermeDS/ateste-me-test?style=social">
  </a>

  <a href="https://github.com/diegoguilhermeDS">
    <img alt="Feito pela Diego Guilherme" src="https://img.shields.io/badge/feito%20por-DiegoGuilherme-%237519C1">
  </a>
</p>


<h4 align="center"> 
    🚀 Ateste Me  <img alt="logo-ateste-me" src="web/public/favicon.png"> 🚀 
</h4>

<p align="center">
 <a href="#-sobre-o-projeto">Sobre</a> •
 <a href="#-funcionalidades">Funcionalidades</a> •
 <a href="#-como-executar-o-projeto">Como executar</a> • 
 <a href="#-tecnologias">Tecnologias</a> • 
 <a href="#-autor">Autor</a> • 
 <a href="#user-content--licença">Licença</a>
</p>

## 💻 Sobre o projeto
Este projeto consiste em uma aplicação web desenvolvida com Angular no front-end e Java Quarkus no back-end, com o objetivo de gerenciar o cadastro de usuários. A aplicação permite que o usuário se registre, faça login e visualize mensagens de confirmação de sucesso.

O projeto foi criado como parte de uma atividade de avaliação de habilidades de desenvolvimento full-stack, integração entre front-end e back-end, e boas práticas de armazenamento de código no GitHub.

## ⚙️ Funcionalidades
- Cadastro de Usuário: Formulário com campos para login, senha e informações adicionais.
- Login: Após autenticação bem-sucedida, exibe a mensagem: "SUCESSO! VOCÊ ESTÁ LOGADO".
- CEP com Preenchimento Automático: Ao digitar o CEP, o endereço é preenchido automaticamente.
- Requisitos de Senha: Senhas devem atender critérios mínimos de segurança (tamanho mínimo, letras maiúsculas e minúsculas, números, etc.).


## 🚀 Como executar o projeto
💡O Frontend precisam que o Backend esteja sendo executado para funcionar completamente.

#### 🧭 Rodando a aplicação

```bash

# Clone este repositório
$ git clone git@github.com:diegoguilhermeDS/ateste-me-test.git

# Acesse a pasta do projeto no seu terminal/cmd
$ cd ateste-me-test

# Instale as dependências do front-end:
$ cd web
$ npm install
$ ng serve

# Inicie o back-end:
cd backend
docker-compose up #Certifique-se de ter o Docker instalado.
./mvn quarkus:dev

# A aplicação será aberta na porta:4200 - acesse http://localhost:4200

```

## 🛠 Tecnologias

- Front-end: Angular
- Back-end: Java Quarkus
- Containerização: Docker / Docker Compose
- Controle de Versão: GitHub

> Veja os arquivos de dependencias  [package.json](https://github.com/diegoguilhermeDS/ateste-me-test/blob/main/web/package.json) / [pom.xml](https://github.com/diegoguilhermeDS/ateste-me-test/blob/main/server/pom.xml)

## 🦸 Autor

<a href="https://github.com/diegoguilhermeDS">
 <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/110187246?v=4" width="100px;" alt=""/>
 <br />
 <sub><b>Diego Guilherme</b></sub></a> <a href="https://github.com/diegoguilhermeDS" title="Github">🚀</a>
 <br />

[![Linkedin Badge](https://img.shields.io/badge/-Linkedin_Diego-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/diegoguilhermeds/)](https://www.linkedin.com/in/diegoguilhermeds/) 
[![Gmail Badge](https://img.shields.io/badge/-diegoguilherme752@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:diegoguilherme752@gmail.com)](mailto:diegoguilherme752@gmail.com)


Feito com ❤️ por Diego Guilherme
