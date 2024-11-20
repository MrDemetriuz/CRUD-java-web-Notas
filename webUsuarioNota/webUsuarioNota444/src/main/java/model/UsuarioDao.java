package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import model.Usuario;
import model.Nota;

@WebServlet("/usuarioD")
public class UsuarioDao {
	private String jdbc_URL = "jdbc:mysql://localhost:3306/usuarioNota";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root12345";
	
	private static final String INSERT_USUARIO_SQL = "insert into usuarios(nome, email, senha) values ( ?, ?, ?)";
	private static final String INSERT_NOTA_SQL = "insert into notas(titulo, dataCriacao, usuarioId, conteudo) values ( ?, ?, ?, ?)";
	private static final String UPDATE_USUARIO_SQL = "update usuarios set nome = ?, email = ?, senha = ? where id = ?";
	private static final String SELECT_ALL_NOTA = "select * from notas where usuarioId = ?";
	private static final String SELECT_ONE_NOTA = "select * from notas where usuarioId = ? and titulo like ?";
	private static final String SELECT_ONE_NOTA_BY_ID = "select * from notas WHERE usuarioId = ? AND id = ?";
	private static final String UPDATE_NOTA = "update notas set titulo = ?, dataCriacao  = ?, conteudo = ? where id = ?";
	private static final String DELETE_NOTA = "delete from notas where id = ?";

	public UsuarioDao() {
		// TODO Auto-generated constructor stub
	}
	
	protected Connection getConnection(){
			
			Connection connection = null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(jdbc_URL,jdbcUsername,jdbcPassword);
			} catch(SQLException | ClassNotFoundException e) {
				e.printStackTrace();
				 
			}
			return connection;
		}
	public void inserirUsuario(Usuario usuario)throws SQLException{
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USUARIO_SQL);) {
				preparedStatement.setString(1, usuario.getNome());
				preparedStatement.setString(2, usuario.getEmail());
				preparedStatement.setString(3, usuario.getSenha());
				preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void inserirNota(Nota nota, HttpServletRequest request)throws SQLException{
		HttpSession session = request.getSession();
	    Integer userId = (Integer) session.getAttribute("userId");
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NOTA_SQL);) {
				preparedStatement.setString(1, nota.getTitulo());
				preparedStatement.setString(2, nota.getConteudo());
				preparedStatement.setInt(3, userId);
				preparedStatement.setString(4, nota.getDataCriacao());
				preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Map<String, Object> selectNotaByTitulo(int userId, String titulo) {
	    Map<String, Object> nota = null;  // Inicializa como null caso não encontre nada
	    
	    // SQL para buscar notas com base no título
	    try (Connection conn = this.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(SELECT_ONE_NOTA)) {
	        
	        // Configurar parâmetros da consulta
	        stmt.setInt(1, userId);
	        stmt.setString(2, titulo); 
	        
	        try (ResultSet rs = stmt.executeQuery()) {
	            // Verifica se encontrou pelo menos uma nota
	            if (rs.next()) {
	                // Preenche o mapa com os dados da nota
	                nota = new HashMap<>();
	                nota.put("id", rs.getInt("id"));
	                nota.put("titulo", rs.getString("titulo"));
	                nota.put("conteudo", rs.getString("conteudo"));
	                nota.put("dataCriacao", rs.getString("dataCriacao"));
	                nota.put("usuarioId", rs.getInt("usuarioId"));
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return nota;  // Retorna o mapa ou null se não encontrar nada
	}
	
	public Map<String, Object> selectNotaById(int userId, int notaId) {
	    Map<String, Object> nota = null;
	    
	    try (Connection conn = this.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(SELECT_ONE_NOTA_BY_ID)) {
	        
	        // Configura os parâmetros da consulta
	        stmt.setInt(1, userId);  // id do usuário
	        stmt.setInt(2, notaId);   // id da nota
	        
	        try (ResultSet rs = stmt.executeQuery()) {
	            // Verifica se encontrou a nota
	            if (rs.next()) {
	                // Preenche o mapa com os dados da nota
	                nota = new HashMap<>();
	                nota.put("id", rs.getInt("id"));
	                nota.put("titulo", rs.getString("titulo"));
	                nota.put("conteudo", rs.getString("conteudo"));
	                nota.put("dataCriacao", rs.getString("dataCriacao"));
	                nota.put("usuarioId", rs.getInt("usuarioId"));
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return nota;  // Retorna o mapa ou null se não encontrar
	}



	
	public List<Map<String, Object>> selectAllNota(int sessionUsuarioId) {
	    List<Map<String, Object>> resultList = new ArrayList<>();
	    
	    try (Connection connection = getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NOTA)) {
	        preparedStatement.setInt(1, sessionUsuarioId);
	        ResultSet rs = preparedStatement.executeQuery();
	        
	        while (rs.next()) {
	            // Criar um Map para armazenar os dados
	            Map<String, Object> objMap = new HashMap<>();
	            objMap.put("id", rs.getInt("id"));
	            objMap.put("titulo", rs.getString("titulo"));
	            objMap.put("conteudo", rs.getString("conteudo"));
	            objMap.put("usuarioId", rs.getInt("usuarioId"));
	            objMap.put("dataCriacao", rs.getString("dataCriacao"));
	            
	            // Adicionar o Map na lista
	            resultList.add(objMap);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return resultList;
	}

	 
	 public boolean updateNota(String titulo, String conteudo, String data, int notaId) throws SQLException {
		 boolean linhaUpdate;
		 try (Connection conection = getConnection();
		PreparedStatement preparedStatement = conection.prepareStatement(UPDATE_NOTA)){
			preparedStatement.setString(1, titulo);
			preparedStatement.setString(2, conteudo);
			preparedStatement.setString(3, data);
			preparedStatement.setInt(4, notaId);
			linhaUpdate = preparedStatement.executeUpdate()>0;
			
		}
		return linhaUpdate;
		 
	 }
	 
	 public boolean deleteNota(int notaId) throws SQLException {
	        boolean rowDeleted;
	        try (Connection connection = getConnection();
	             PreparedStatement statement = connection.prepareStatement(DELETE_NOTA)) {
	            statement.setInt(1, notaId);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }
	
	
	public boolean updateUsuario(Usuario usuario) throws SQLException {
			
			boolean linhaUpdate;
			try (Connection conection = getConnection();
			PreparedStatement preparedStatement = conection.prepareStatement(UPDATE_USUARIO_SQL)){
				preparedStatement.setString(1, usuario.getNome());
				preparedStatement.setString(2, usuario.getEmail());
				preparedStatement.setString(3, usuario.getSenha());
				preparedStatement.setInt(4, usuario.getID());
				linhaUpdate = preparedStatement.executeUpdate()>0;
				
			}
			return linhaUpdate;
		}
	

}
