# 📋 Check-list do Projeto – Sistema de Login e Cadastro

## 🔧 Preparação
- [X] Criar repositório no GitHub (público).
- [X] Configurar ambiente do **Java Quarkus** (backend).
- [X] Configurar ambiente do **Angular** (frontend).
- [X] Definir estrutura de pastas (frontend/backend).
- [X] Criar `README.md` inicial com objetivo e instruções básicas.

---

## 🎨 Frontend (Angular)
- [X] Criar **módulo de autenticação** (login, cadastro, recuperação).
- [X] Tela de **Login**:
  - [X] Campos: e-mail + senha.
  - [X] Validações básicas.
  - [X] Chamada à API de autenticação.
- [X] Tela de **Cadastro**:
  - [] Campo com **Bottom Sheet** (informações adicionais).
  - [] Campo **livre** (sem restrições).
  - [X] Campo **CEP** com autocomplete de endereço (API ViaCEP).
  - [X] Campo de **senha** com requisitos de segurança (mín. caracteres, maiúscula, minúscula, número, etc.).
  - [X] Botão de confirmar cadastro.
- [X] Tela de **Boas-vindas** (exibir: `"SUCESSO! VOCÊ ESTÁ LOGADO"`).
- [] Tela de **Recuperação de senha** (opcional):
  - [] Formulário para inserir e-mail.
  - [] Mensagem de confirmação de envio.
- [X] Estilização básica (UI limpa e intuitiva).

---

## ⚙️ Backend (Java Quarkus)
- [X] Criar projeto base Quarkus.
- [X] Configurar conexão com banco de dados (PostgreSQL ou H2 para testes).
- [X] Criar entidades:
  - [X] Usuário (id, nome, e-mail, senha, dados adicionais).
- [X] Criar repositórios e serviços.
- [X] Implementar **endpoints REST**:
  - [X] `POST /auth/login` – autenticação.
  - [X] `POST /user/register` – cadastro.
  - [X] `GET /user/me` – buscar usuário.
  - [] `POST /auth/recover` – envio de e-mail recuperação (opcional).
- [X] Configurar **segurança** (criptografia de senhas com BCrypt).
- [X] Testes básicos dos endpoints.

---

## 🔗 Integração Frontend + Backend
- [] Configurar variáveis de ambiente (URL da API).
- [X] Implementar serviços Angular para consumir a API Quarkus.
- [X] Testar fluxo completo:
  1. Cadastro → Banco de Dados.
  2. Login → Autenticação.
  3. Redirecionamento para tela de boas-vindas.
  4. Recuperação de senha → envio de e-mail.

---

## 📦 Entregáveis
- [X] Código hospedado em **repositório público do GitHub**.
- [X] Arquivo `README.md` com:
  - [X] Como rodar backend.
  - [X] Como rodar frontend.
  - [X] Dependências necessárias.
  - [X] Passos para testar a aplicação.

---

## ✅ Critérios de Atenção
- [X] Funcionalidade completa conforme requisitos.
- [X] Boas práticas de código (organização e clareza).
- [X] Integração bem feita (Angular ↔ Quarkus).
- [X] Usabilidade (UX simples e intuitiva).
- [X] Segurança aplicada (senhas criptografadas).
- [X] Entrega dentro do prazo.
