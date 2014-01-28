package br.com.each.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Monografia implements Serializable {

	private Long id;
	private String autores;
	private String tema;
	private String titulo;
	private String nomeInstiruicao;
	private Long nroMonografia;
	private String localPublicacao;
	private String anoPublicacao;

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
		Monografia other = (Monografia) obj;
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

	public String getLocalPublicacao() {
		return localPublicacao;
	}

	public void setLocalPublicacao(String localPublicacao) {
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

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		if(autores!= null)
		{
		this.autores = autores;
		}else{
			this.autores = "";
		}
	}

	public String getNomeInstiruicao() {
		return nomeInstiruicao;
	}

	public void setNomeInstiruicao(String nomeInstiruicao) {
		this.nomeInstiruicao = nomeInstiruicao;
	}

	public Long getNroMonografia() {
		return nroMonografia;
	}

	public void setNroMonografia(Long nroMonografia) {
		this.nroMonografia = nroMonografia;
	}

}