<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link rel="icon" href="login_icon.png"> <!-- Ícone opcional -->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="style.css"> <!-- Arquivo CSS customizado -->
</head>

<body class="d-flex justify-content-center align-items-center min-vh-100 bg-light">

    <div class="container">
        <h1 class="text-center mt-5">Faça o Seu Login</h1><br><br>

        <!-- Formulário de login -->
        <form action="VerificarLogin" method="post" class="mt-4 p-4 border rounded shadow-sm bg-white">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" class="form-control" placeholder="Digite seu email" required>
            </div>
            <div class="form-group mt-3">
                <label for="password">Senha:</label>
                <input type="password" id="password" name="password" class="form-control" placeholder="Digite sua senha" required>
            </div>
            <br><br>
<!-- Botão de login -->
            <button type="submit" class="botao1">Entrar</button>
            
                    </form>
            
        <div class="text-center mt-3">
        
            <a href="cadastro.jsp" class="text-muted">Cadastre-se</a>
        </div>
    </div>

    <script src="scripts/validador.js"></script>
</body>

</html>
