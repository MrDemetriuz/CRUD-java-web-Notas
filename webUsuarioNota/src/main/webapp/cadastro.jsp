<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cadastro</title>
    <link rel="icon" href="imagens/lapis.png"> <!-- Ícone opcional -->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="style.css"> <!-- Arquivo CSS customizado -->
</head>

<body class="d-flex justify-content-center align-items-center min-vh-100 bg-light">

    <div class="container">
        <h1 class="text-center mt-5">Faça o Seu Cadastro</h1><br><br>

        <!-- Formulário de cadastro -->
        <form action="VerificarLogin" method="post" class="mt-4 p-4 border rounded shadow-sm bg-white">
            <div class="form-group">
                <label for="user">Usuário:</label>
                <input type="text" id="user" name="user" class="form-control" placeholder="Escolha seu nome de usuário" required>
            </div>
            <div class="form-group mt-3">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" class="form-control" placeholder="Digite seu email" required>
            </div>
            <div class="form-group mt-3">
                <label for="password">Senha:</label>
                <input type="password" id="password" name="password" class="form-control" placeholder="Escolha sua senha" required>
            </div>

            <!-- Botão de cadastro -->
            <button type="submit" class="btn btn-primary btn-block mt-4">Cadastrar</button>
        </form>

        <div class="text-center mt-3">
            <a href="login.jsp" class="text-muted">Já tem uma conta? Faça login</a>
        </div>
    </div>

    <script src="scripts/validador.js"></script>
</body>

</html>
