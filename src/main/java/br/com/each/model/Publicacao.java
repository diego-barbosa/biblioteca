package br.com.each.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Publicacao implements Serializable {

	private Long id;
	private String autor;
	private String tema;
	private String titulo;
	private String tituloOriginal;
	private Long nroEdicao;
	private String localPublicacao;
	private String editora;
	private String anoPublicacao;
	private Long nroPaginas;
	private Long codColetanea;
	private String nomeInstituicao;
	private Long nroMonografia;
	private String editoresLivro;
	private Long pagIni;
	private Long pagFim;

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
		this.tituloOriginal = tituloOriginal;
	}

	public Long getNroEdicao() {
		return nroEdicao;
	}

	public void setNroEdicao(Long nroEdicao) {
		this.nroEdicao = nroEdicao;
	}

	public String getLocalPublicacao() {
		return localPublicacao;
	}

	public void setLocalPublicacao(String localPublicacao) {
		this.localPublicacao = localPublicacao;
	}

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
		Publicacao other = (Publicacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getNroPaginas() {
		return nroPaginas;
	}

	public void setNroPaginas(Long nroPaginas) {
		this.nroPaginas = nroPaginas;
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

	public String getNomeInstituicao() {
		return nomeInstituicao;
	}

	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}

	public Long getNroMonografia() {
		return nroMonografia;
	}

	public void setNroMonografia(Long nroMonografia) {
		this.nroMonografia = nroMonografia;
	}

	public String getEditoresLivro() {
		return editoresLivro;
	}

	public void setEditoresLivro(String editoresLivro) {
		this.editoresLivro = editoresLivro;
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