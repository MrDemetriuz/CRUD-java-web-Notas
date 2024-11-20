package control;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import model.UsuarioDao;

@WebServlet("/DeleteNota")
public class DeleteNotaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDao usuarioDao;
	public void init() {
		
		usuarioDao = new UsuarioDao();
	}
       
  
    public DeleteNotaServlet() {
        super();
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String notaId = request.getParameter("delNum");
		int notaIdInt = Integer.parseInt(notaId);
		try {
			
			usuarioDao.deleteNota(notaIdInt);
		}catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("selectNota.jsp");
	}

}
