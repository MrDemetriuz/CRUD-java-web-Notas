package control;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Inicia a sessão ou recupera a sessão existente
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            // Invalida a sessão
            session.invalidate();
        }
        
        // Redireciona para a página inicial (ou qualquer outra)
        response.sendRedirect("index.html");
    }
}
