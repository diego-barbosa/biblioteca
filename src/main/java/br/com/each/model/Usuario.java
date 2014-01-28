package br.com.each.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Usuario implements Serializable {

	private Long id;
	private Long cpf;
	private String nome;
	private String telefone;

	public Usuario() {
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if (telefone == null) {
			this.telefone = null;
		} else
			this.telefone = telefone;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {

		this.cpf = cpf;

	}

}