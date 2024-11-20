package control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.UsuarioDao;

import java.io.IOException;
import java.util.Map;


public class ListarNota extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDao usuarioDao;
	public void init() {
		
		usuarioDao = new UsuarioDao();
	}
       
  
    public ListarNota() {
        super();
       
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String titulo = request.getParameter("titulo");
        int userId = (int) session.getAttribute("userId");

        try {
            // Chama o método para obter a nota
            Map<String, Object> nota = usuarioDao.selectNotaByTitulo(userId, titulo);
            
            // Verifica se a nota foi encontrada e, se sim, adiciona à requisição
            if (nota != null) {
                request.setAttribute("nota", nota);
            } else {
                request.setAttribute("mensagem", "Nota não encontrada.");
            }

            // Redireciona para a JSP para exibir o conteúdo
            RequestDispatcher dispatcher = request.getRequestDispatcher("ListaNotas.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

		
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
