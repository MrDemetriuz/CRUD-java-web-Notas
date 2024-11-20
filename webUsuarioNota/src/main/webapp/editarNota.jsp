<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.Map" %>
<%@ page import="model.UsuarioDao" %> <!-- Ajuste o pacote conforme sua estrutura -->
<%@ page session="true" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>editar registro</title>
    <link rel="icon" href="imagens/lapis.png">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a href="ListaNotas.jsp" class="botao1"> Voltar </a>
    </nav>

<% 
    // Criar uma instância do DAO e buscar a nota para edição
    UsuarioDao notaDAO = new UsuarioDao();
    Integer userId = (Integer) session.getAttribute("userId");
    String editNum = request.getParameter("editNum");  // 'editNum' é o ID da nota a ser editada
    
    if (editNum != null && !editNum.isEmpty()) {
        // Busca a nota específica pelo ID da nota (editNum)
        Map<String, Object> notaMap = notaDAO.selectNotaById(userId, Integer.parseInt(editNum));
        
        if (notaMap != null && !notaMap.isEmpty()) {
            String titulo = (String) notaMap.get("titulo");
            String conteudo = (String) notaMap.get("conteudo");
            String dataCriacao = (String) notaMap.get("dataCriacao");
            Integer id = (Integer) notaMap.get("id");
%>

<h1>Editar Nota</h1>

<!-- Formulário de edição com dados da nota -->
<form action="UpdateNotaServlet" method="POST">
    <table>
        <tr>
            <!-- Preenchendo o valor do campo "titulo" com o título da nota -->
            <td><input type="text" name="titulo" value="<%= titulo %>" class="Caixa1" required></td>
            <!-- Preenchendo o valor do campo "data" com a data de criação -->
            <td><input type="date" name="data" value="<%= dataCriacao %>" class="Caixa1" required></td>
        </tr>
        <tr>
            <!-- Preenchendo o conteúdo da nota no textarea -->
            <td><textarea name="conteudo" rows="15" cols="150" class="Caixa1" required><%= conteudo %></textarea></td>
        </tr>
    </table>
    <!-- Envia o ID da nota como um campo oculto -->
    <input type="hidden" name="editNum" value="<%= id %>" />
    <input type="submit" value="Salvar" class="botao1">
</form>

<% 
        } else {
            out.println("<p>Nota não encontrada.</p>");
        }
    }
%>

</body>
</html>
