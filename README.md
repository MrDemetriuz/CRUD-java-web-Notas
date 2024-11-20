# CRUD-java-web-Notas
Este é um sistema Java Web que implementa uma aplicação CRUD (Criar, Ler, Atualizar, Deletar) com suporte a perfis de usuários e um sistema de notas associadas a esses usuários. A aplicação foi desenvolvida para rodar em um servidor Apache Tomcat 10.1 e utiliza o MySQL como banco de dados.


Funcionalidades:

- Cadastro de usuários: Permite a criação de usuários com diferentes perfis.

- CRUD de Notas: Permite que os usuários cadastrados criem, editem, visualizem e excluam notas vinculadas aos seus perfis.

- Banco de dados: Utiliza o MySQL para persistência de dados, com tabelas para usuários e notas.


Tecnologias utilizadas:

- Java 17: Linguagem de programação.

- Apache Tomcat 10.1: Servidor web para deploy da aplicação.

- JSP (JavaServer Pages) e HTML: Para a criação das interfaces web.

- Servlets: Para a lógica de controle da aplicação.

- MySQL: Banco de dados utilizado para persistência dos dados.

- JDBC: Conexão com o banco de dados MySQL.


Pré-requisitos:

- Java 17 ou superior instalado.

- Tomcat 10.1 ou superior configurado.

- MySQL configurado e rodando (arquivo script sql pode ser achado dentro da pasta do repositório).

- IDE de sua escolha (por exemplo, Eclipse, IntelliJ, NetBeans).


Instruções de instalação:

- Baixar e configurar o Tomcat 10.1

Baixe o Apache Tomcat 10.1 do site oficial https://tomcat.apache.org/download-10.cgi.
Extraia o conteúdo para o diretório de sua escolha e configure o Tomcat no seu IDE.

- Configuração do MySQL

Certifique-se de que o MySQL está instalado e rodando no seu sistema.
Execute o script SQL para criar as tabelas necessárias (arquivo script sql pode ser achado dentro da pasta do repositório).

você terá que mudar o username e senha do banco nos arquivos: "UsuarioDao.java e VerificarLogin.java".


Como utilizar:

- Cadastro de usuário

Acesse a página de cadastro e registre um novo usuário, logo em seguida faça seu login.

- Gerenciar notas

Usuários podem criar, editar e excluir suas próprias notas.
