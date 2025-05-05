# Formulário Java com SQLite + Spark + AJAX

Este projeto é uma aplicação web simples escrita em **Java**, usando o framework **Spark** e banco de dados **SQLite**, com interface moderna baseada em **HTML + JavaScript (AJAX)**.

---

## 🚀 Funcionalidades

- 📝 Cadastro de contatos (nome, email, WhatsApp)
- 📃 Listagem com atualização dinâmica
- ✏️ Edição e ❌ exclusão em linha
- 🔍 Filtro por nome
- ✅ Toasts de confirmação após cada ação

---

## 🧰 Tecnologias

- Java 21 (Amazon Corretto)
- Spark Java 2.9.4
- SQLite JDBC 3.42.0.0
- Gson 2.10.1
- HTML5 + CSS3 + JavaScript (fetch/AJAX)
- Maven + Maven Shade Plugin

---

## 🖥️ Como executar localmente

### 1. Clone ou extraia o projeto

Se for um `.zip`, descompacte e abra a pasta do projeto:

```bash
cd form-java-sqlite/form-java
```

### 2. Compile e gere o `.jar`

```bash
mvn clean package
```

> Isso cria o arquivo:  
> `target/form-java-1.0-SNAPSHOT.jar` (empacotado com dependências via Maven Shade Plugin)

### 3. Execute o projeto

```bash
java -jar target/form-java-1.0-SNAPSHOT.jar
```

### 4. Acesse no navegador

Abra: [http://localhost:4567](http://localhost:4567)

---

## 📄 Interface Web

- Formulário para cadastro
- Tabela com lista de contatos
- Edição e exclusão em linha
- Busca por nome em tempo real
- Toasts com mensagens de sucesso

---

## 🗃️ Banco de Dados SQLite

O projeto usa `dados.db` como banco local.

### Comandos no terminal:

```bash
sqlite3 dados.db
```

E no prompt do SQLite:

```sql
.tables
.schema contatos
SELECT * FROM contatos;
.exit
```

---

## 📁 Estrutura de pastas

```
form-java/
├── pom.xml
├── dados.db
├── src/
│   └── main/
│       ├── java/com/exemplo/App.java
│       └── resources/public/index.html
```

---

## ✅ Pré-requisitos

- Java 21 (Amazon Corretto recomendado)
- Maven 3.6+
- Navegador moderno (Chrome, Firefox, Edge)

---

## 💡 Próximas melhorias (sugestões)

- Login/autenticação
- Exportar lista para CSV/Excel
- Deploy em nuvem (Render, Railway, Heroku)
- Conversão para app mobile (ex: Capacitor + WebView)

---

## 📄 Licença

Uso livre para estudos, aprendizado e experimentações.  
Contribuições são bem-vindas! 🙌

---

Desenvolvido com 💻 e ☕ em Java.
