<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="model.UsuarioDao" %> <!-- Ajuste o pacote conforme sua estrutura -->
<%@ page session="true" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Lista de Notas</title>
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
      <a href="home.jsp" class="botao1">Voltar</a><br><br>
    <a href="LogoutServlet" class="botao1">Sair</a>
<h1>Lista de Notas</h1>
<!-- Botoes para criar, editar e apagar  notas -->
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
<h1> </h1>
      
<%
    // Criar uma instância do DAO e buscar as notas
    UsuarioDao notaDAO = new UsuarioDao();
    Integer userId = (Integer) session.getAttribute("userId");
    List<Map<String, Object>> listaNotas = notaDAO.selectAllNota(userId);

    if (listaNotas.isEmpty()) {
%>
        <p>Não há notas disponíveis.</p>
<%
    } else {
%>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Título</th>
                    <th>Conteúdo</th>
                    <th>Data de Criação</th>
                    <th>ID do Usuário</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    // Iterar sobre a lista de Mapas
                    for (Map<String, Object> notaMap : listaNotas) {
                        int id = (Integer) notaMap.get("id");
                        String titulo = (String) notaMap.get("titulo");
                        String conteudo = (String) notaMap.get("conteudo");
                        String dataCriacao = (String) notaMap.get("dataCriacao");
                        int usuarioId = (Integer) notaMap.get("usuarioId");
                %>
                    <tr>
                        <td><%= id %></td>
                        <td><%= titulo %></td>
                        <td><%= conteudo %></td>
                        <td><%= dataCriacao %></td>
                        <td><%= usuarioId %></td>                    
                    </tr>
                <% 
                    } 
                %>
            </tbody>
        </table>
<%
    }
%>

  <script src="scripts/EditarApagar.js"></script>

</body>
</html>
        
       
  


