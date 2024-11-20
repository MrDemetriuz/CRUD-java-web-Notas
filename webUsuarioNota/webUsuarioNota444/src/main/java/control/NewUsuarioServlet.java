package control;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;

import java.io.IOException;

import model.UsuarioDao;


public class NewUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDao usuarioDao;
	public void init() {
		
		usuarioDao = new UsuarioDao();
	}
       
   
    public NewUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Usuario usuario = new Usuario(user,email,password);
		
		try {
			
			usuarioDao.inserirUsuario(usuario);
		}catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("login.jsp");
		
		
		
	}

}
