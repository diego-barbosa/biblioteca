package br.com.each.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Emprestimo implements Serializable {

	private Long id;
	private Long cpf;
	private Long id_publicacao;
	private Long tipo_publicacao;

	public Emprestimo() {
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		Emprestimo other = (Emprestimo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {

		this.cpf = cpf;

	}

	public Long getId_publicacao() {
		return id_publicacao;
	}

	public void setId_publicacao(Long id_publicacao) {
		this.id_publicacao = id_publicacao;
	}

	public Long getTipo_publicacao() {
		return tipo_publicacao;
	}

	public void setTipo_publicacao(Long tipo_publicacao) {
		this.tipo_publicacao = tipo_publicacao;
	}

}