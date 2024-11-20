package model;

public class Nota {
	
	private int ID;
	private String titulo;
	private String conteudo;
	private String dataCriacao;
	private int usuarioId;

	public Nota(String titulo, String conteudo, String dataCriacao, int usuarioId) {
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.dataCriacao = dataCriacao;
		this.setUsuarioId(usuarioId);
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	

}
