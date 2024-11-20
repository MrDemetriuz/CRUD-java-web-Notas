package control;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Nota;

import java.io.IOException;

import model.UsuarioDao;

@WebServlet("/CriarNota")
public class NewNotaServlet extends HttpServlet {
	


	private static final long serialVersionUID = 1L;
	private UsuarioDao usuarioDao;
	public void init() {
		
		usuarioDao = new UsuarioDao();
	}
       
   
    public NewNotaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String titulo = request.getParameter("titulo");
        String data = request.getParameter("data");
        String conteudo = request.getParameter("conteudo");
        int userId;
        userId = (int) session.getAttribute("userId");

		
		Nota nota = new Nota(titulo,data,conteudo, userId );
		
		try {
			
			usuarioDao.inserirNota(nota, request);
		}catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("selectNota.jsp");
		
		
		
	}

}
