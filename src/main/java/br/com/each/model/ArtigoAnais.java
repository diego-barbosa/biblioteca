package br.com.each.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ArtigoAnais implements Serializable {

	private Long id;
	private String autor;
	private String tema;
	private String titulo;
	private String tituloOriginal;
	private Long nroVolume;
	private String localPublicacao;
	private String editora;
	private String anoPublicacao;
	private Long pagIni;
	private Long pagFim;

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
		ArtigoAnais other = (ArtigoAnais) obj;
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

	public void setId(Long idLivrosDeArtigo) {
		this.id = idLivrosDeArtigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTituloOriginal() {
		return tituloOriginal;
	}

	public void setTituloOriginal(String tituloOriginal) {
		if (tituloOriginal == null) {
			this.tituloOriginal = null;
		}
		this.tituloOriginal = tituloOriginal;
	}
	public String getLocalPublicacao() {
		return localPublicacao;
	}

	public void setLocalPublicacao(String localPublicacao) {
		this.localPublicacao = localPublicacao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
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

	public Long getNroVolume() {
		return nroVolume;
	}

	public void setNroVolume(Long nroVolume) {
		this.nroVolume = nroVolume;
	}

	public Long getPagIni() {
		return pagIni;
	}

	public void setPagIni(Long pagIni) {
		this.pagIni = pagIni;
	}

	public Long getPagFim() {
		return pagFim;
	}

	public void setPagFim(Long pagFim) {
		this.pagFim = pagFim;
	}

}