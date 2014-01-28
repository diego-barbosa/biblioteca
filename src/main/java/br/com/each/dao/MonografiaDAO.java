package br.com.each.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.caelum.vraptor.ioc.Component;
import br.com.each.ConnectionFactory.ConnectionFactory;
import br.com.each.model.Monografia;

@Component
public class MonografiaDAO {

	private Connection connection;

	private PreparedStatement pstm;

	public MonografiaDAO() {
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void salva(Monografia monografia) {
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("insert into monografias (autores,tema,titulo,nome_instituicao,nro_monografia,local_publicacao,ano_publicacao) values (?,?,?,?,?,?,?)");
			pstm.setString(1, monografia.getAutores());
			pstm.setString(2, monografia.getTema());
			pstm.setString(3, monografia.getTitulo());
			pstm.setString(4, monografia.getNomeInstiruicao());
			pstm.setLong(5, monografia.getNroMonografia());
			pstm.setString(6, monografia.getLocalPublicacao());
			pstm.setString(7, monografia.getAnoPublicacao());
			pstm.executeUpdate();
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public void remove(Long id) { try { this.connection =
	 * ConnectionFactory.getConnection(); pstm = this.connection
	 * .prepareStatement("delete from livro where id_livro = ?");
	 * pstm.setLong(1, id); pstm.executeUpdate(); pstm.close();
	 * connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 */
	// RETORNAR TODOS OS LIVROS INSERIDOS
	/*
	 * public List<Livro> lista() { List<Livro> livros = new ArrayList<>(); try
	 * { this.connection = ConnectionFactory.getConnection(); pstm =
	 * this.connection.prepareStatement("select * from livro"); pstm.execute();
	 * 
	 * ResultSet set = pstm.executeQuery(); while (set.next()) { Livro livro =
	 * new Livro(); livro.setTitulo(set.getString("titulo"));
	 * livro.setEditora(set.getString("editora"));
	 * livro.setAutor(set.getString("autores"));
	 * livro.setTituloOriginal(set.getString("titulo_orignal"));
	 * livro.setNroEdicao(set.getLong("nro_edicao"));
	 * livro.setLocalPublicacao(set.getString("local_publicacao"));
	 * livro.setNroPaginas(set.getLong("nro_paginas"));
	 * livro.setAnoPublicacao(set.getString("ano_publicacao"));
	 * livros.add(livro); }
	 * 
	 * pstm.close(); connection.close(); } catch (SQLException e) {
	 * e.printStackTrace(); }
	 * 
	 * return livros; }
	 */

	// BUSCA POR NOME TODOS LIVROS DE MESMO (AUTOR)
	public List<Monografia> buscaPoNome(String nome) {
		List<Monografia> monografia = new ArrayList<>();
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("select * from monografia  where autores = ?");
			pstm.setString(1, nome);
			pstm.execute();

			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				Monografia livro = new Monografia();
				livro.setId(set.getLong("id_livro"));
				monografia.add(livro);
			}

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return monografia;
	}

}