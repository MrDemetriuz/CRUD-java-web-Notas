package control;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

/**
 * Servlet para verificar o login do usuário.
 */
@WebServlet("/verificarLogin")
public class VerificarLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Método para obter a conexão com o banco de dados
    private Connection getConnection() throws SQLException {
        try {
            // Carrega o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            String jdbc_URL = "jdbc:mysql://localhost:3306/usuarioNota";
            String jdbcUsername = "root";
            String jdbcPassword = "root12345";
            return DriverManager.getConnection(jdbc_URL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            // Lança uma exceção caso não consiga conectar
            throw new SQLException("Erro ao conectar ao banco de dados", e);
        }
    }

    // Método chamado para processar a requisição POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");    // Email fornecido pelo usuário
        String senha = request.getParameter("password");  // Senha fornecida pelo usuário

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Tenta realizar a verificação do login
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT id, nome, senha FROM usuarios WHERE email = ? LIMIT 1")) {

            stmt.setString(1, email);  // Prepara a consulta com o email fornecido
            try (ResultSet rs = stmt.executeQuery()) {
                // Verifica se o usuário foi encontrado no banco
                if (rs.next()) {
                    // Recupera a senha armazenada no banco de dados
                    String senhaBanco = rs.getString("senha");

                    // Verifica se as senhas coincidem
                    if (senhaBanco.equals(senha)) {
                        // Login bem-sucedido: armazena o ID e nome do usuário na sessão
                        HttpSession session = request.getSession();
                        session.setAttribute("userId", rs.getInt("id"));  // Armazenando o ID
                        session.setAttribute("username", rs.getString("nome"));  // Armazenando o nome

                        // Redireciona para a página principal (ou dashboard)
                        response.sendRedirect("home.jsp");//

                    } else {
                        // Se a senha for incorreta
                        out.println("<h3>Senha incorreta. Tente novamente.</h3>");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
                        dispatcher.include(request, response);  // Retorna para a página de login
                    }
                } else {
                    // Se o usuário não for encontrado, redireciona para a página de cadastro
                    out.println("<h3>Usuário não encontrado. Por favor, cadastre-se.</h3>");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/NewUsuarioServlet");
                    dispatcher.forward(request, response);  // Redireciona para o servlet de cadastro
                }
            }

        } catch (SQLException e) {
            // Caso haja algum erro ao consultar o banco de dados
            out.println("<h3>Erro ao acessar o banco de dados: " + e.getMessage() + "</h3>");
        }
    }
}
