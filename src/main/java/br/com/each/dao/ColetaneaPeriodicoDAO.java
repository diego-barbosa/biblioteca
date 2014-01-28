package br.com.each.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.caelum.vraptor.ioc.Component;
import br.com.each.ConnectionFactory.ConnectionFactory;
import br.com.each.model.ColetaneaPeriodico;
import br.com.each.model.Periodico;

@Component
public class ColetaneaPeriodicoDAO {

	private Connection connection;

	private PreparedStatement pstm;

	public ColetaneaPeriodicoDAO() {
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void salva(ColetaneaPeriodico coletaneaPeriodico) {
		try {
			this.connection = ConnectionFactory.getConnection();

			pstm = this.connection
					.prepareStatement("insert into coletanea (nome_coletanea) values (?)");
			pstm.setString(1, coletaneaPeriodico.getNomeColetanea());
			pstm.executeUpdate();
			pstm.close();

			int id_coletade = 0;

			pstm = this.connection
					.prepareStatement("select cod_coletanea from coletanea order BY cod_coletanea DESC LIMIT 1");
			ResultSet set = pstm.executeQuery();
			while (set.next()) {

				id_coletade = set.getInt("cod_coletanea");

				String[] teste = coletaneaPeriodico.getIdPublicacoes().split(
						",");
				for (int i = 0; i < teste.length; i++) {

					pstm = this.connection
							.prepareStatement("insert into coletanea_publicacao (id_artigo_periodico,cod_coletanea) values (?,?)");
					pstm.setInt(1, Integer.parseInt(teste[i]));
					pstm.setInt(2, id_coletade);
					pstm.executeUpdate();
					pstm.close();
				}

				connection.close();
			}
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