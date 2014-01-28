package br.com.each.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Anais implements Serializable {

	private Long id;
	private String titulo;
	private String tema;
	private String localPublicacao;
	private String editora;
	private String anoPublicacao;
	private String flTerminou;
	private Long codColetanea;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anais other = (Anais) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getLocalPublicacao() {
		return localPublicacao;
	}

	public void setLocalPublicacao(String localPublicacao) {
		if (localPublicacao == null) {
			this.localPublicacao = null;
			}
		this.localPublicacao = localPublicacao;
	}

	public String getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(String anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Long getCodColetanea() {
		return codColetanea;
	}

	public void setCodColetanea(Long codColetanea) {
		this.codColetanea = codColetanea;
	}

	public String getFlTerminou() {
		return flTerminou;
	}

	public void setFlTerminou(String flTerminou) {
		this.flTerminou = flTerminou;
	}

}