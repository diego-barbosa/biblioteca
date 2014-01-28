package br.com.each.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.caelum.vraptor.ioc.Component;
import br.com.each.ConnectionFactory.ConnectionFactory;
import br.com.each.model.Periodico;

@Component
public class PeriodicoDAO {

	private Connection connection;

	private PreparedStatement pstm;

	public PeriodicoDAO() {
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void salva(Periodico periodico) {
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("insert into periodico (titulo,tema,local_publicacao,editora,ano_publicacao,fl_terminou,cod_coletanea) values (?,?,?,?,?,?,?)");
			pstm.setString(1, periodico.getTitulo());
			pstm.setString(2, periodico.getTema());
			pstm.setString(3, periodico.getLocalPublicacao());
			pstm.setString(4, periodico.getEditora());
			pstm.setString(5, periodico.getAnoPublicacao());
			pstm.setString(6, periodico.getFlTerminou());
			pstm.setLong(7, periodico.getCodColetanea());
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
	public List<Periodico> buscaPoNome(String nome) {
		List<Periodico> periodicos = new ArrayList<>();
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("select * from livro  where autores = ?");
			pstm.setString(1, nome);
			pstm.execute();

			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				Periodico livro = new Periodico();
				livro.setId(set.getLong("id_livro"));
				periodicos.add(livro);
			}

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return periodicos;
	}

}