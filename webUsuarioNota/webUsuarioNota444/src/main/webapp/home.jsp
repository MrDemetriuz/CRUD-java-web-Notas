<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bem-vindo</title>
    <link rel="icon" href="imagens/lapis.png">
 <link rel="icon" href="login_icon.png"> <!-- Ícone opcional -->
    <link rel="stylesheet" href="style.css"> <!-- Arquivo CSS customizado -->
    <!-- Incluindo o Bootstrap -->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <style>
        .navbar-brand {
            font-size: 1.5rem;
            color: #007bff !important;
        }
        .welcome-message {
            margin-top: 50px;
        }
        h1 {
      text-align: center;
    }
    </style>
</head>
<body>

    <!-- Navbar -->
    
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="botao1" href="LogoutServlet">
            <i class="botao1"></i>Sair</a>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
              
            </ul>
        </div>
    </nav>
                    <!-- Mensagens de boas-vindas -->
  <br><h1 class="mb-4">Login bem-sucedido!</h1>
     <div class="container welcome-message">
        <div class="row justify-content-center">
            <div class="col-md-6 text-center">
                <br>
                <!-- Exibe o nome do usuário da sessão -->
                <%
                    // Recupera o nome do usuário e o ID da sessão
                    String nome = (String) session.getAttribute("username");
                    Integer userId = (Integer) session.getAttribute("userId");

                    // Exibe as informações de boas-vindas
                    if (nome != null && userId != null) {
                %>
                    <h4 class="mb-4">Bem-vindo, <%= nome %>!</h4>
                    <p><strong>ID do usuário:</strong> <%= userId %></p>
                <%
                    } else {
                %>
                    <p>Usuário não encontrado na sessão.</p>
                <%
                    }
                %>
                
				<img src="imagens/logoNota.png" alt="Logo"><br>
                <a class="botao1" href="selectNota.jsp">Continuar</a>
                
            </div>
        </div>
    </div>
</body>
</html>
