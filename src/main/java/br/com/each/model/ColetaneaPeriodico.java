package br.com.each.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ColetaneaPeriodico implements Serializable {

	private Long id;
	private String nomeColetanea;
	private String idPublicacoes;
	
	public ColetaneaPeriodico() {

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
		ColetaneaPeriodico other = (ColetaneaPeriodico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getNomeColetanea() {
		return nomeColetanea;
	}

	public void setNomeColetanea(String nomeColetanea) {
		this.nomeColetanea = nomeColetanea;
	}

	public String getIdPublicacoes() {
		return idPublicacoes;
	}

	public void setIdPublicacoes(String idPublicacoes) {
		this.idPublicacoes = idPublicacoes;
	}


}