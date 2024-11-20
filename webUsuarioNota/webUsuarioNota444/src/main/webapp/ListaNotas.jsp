<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Detalhes da Nota</title>
    <link rel="icon" href="imagens/lapis.png">
    <link rel="stylesheet" href="style.css">
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        h1 {
            text-align: center;
        }
    </style>
</head>
<body>
    <a href="selectNota.jsp" class="botao1">Voltar</a><br><br>
    <a href="LogoutServlet" class="botao1">Sair</a>
    <h1>Detalhes da Nota</h1>

    <!-- Formulário de Pesquisa -->
   <form action="ListarNota" method="GET">
        <label for="titulo">Pesquisar por título:</label>
        <input type="text" id="titulo" name="titulo" placeholder="Digite o título da nota" />
        <button type="submit" class="botao1">Pesquisar</button>
    </form>
    <br>
    <tr>
<td> <a href="nota.html" class="botao1" >Novo</a></td>
<td> <button onclick="editarNota()" class="botao1">Editar</button></td>
<td> <button onclick="apagarNota()" class="botao1">Apagar</button></td>

</tr>
<br>
    <!-- Verifica se a nota foi encontrada -->
    <c:if test="${not empty nota}">
        <table>
            <thead>
            <br>
                <tr>
                    <th>ID da nota</th>
                    <th>Título</th>
                    <th>Conteúdo</th>
                    <th>Data de Criação</th>
                    <th>ID do Usuário</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${nota.id}</td>
                    <td>${nota.titulo}</td>
                    <td>${nota.conteudo}</td>
                    <td>${nota.dataCriacao}</td>
                    <td>${nota.usuarioId}</td>
                </tr>
            </tbody>
        </table>
    </c:if>

    <!-- Mensagem caso a nota não tenha sido encontrada -->
    <c:if test="${empty nota}">
        <p>Nota não encontrada.</p>
    </c:if>

    <script src="scripts/EditarApagar.js"></script>
</body>
</html>
