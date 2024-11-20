package control;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import model.UsuarioDao;

/**
 * Servlet implementation class UpdateNotaServlet
 */
//@WebServlet("/UpdateNotaServlet")
public class UpdateNotaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDao usuarioDao;
	public void init() {
		
		usuarioDao = new UsuarioDao();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNotaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String titulo = request.getParameter("titulo");
        String data = request.getParameter("data");
        String conteudo = request.getParameter("conteudo");
        String notaId =  request.getParameter("editNum");
        int notaIdInt = Integer.parseInt(notaId);
        
        try {
			
			usuarioDao.updateNota(titulo, data, conteudo ,notaIdInt);
		}catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("selectNota.jsp");
		
		
	}

}
