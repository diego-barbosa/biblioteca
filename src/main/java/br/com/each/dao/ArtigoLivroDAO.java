package br.com.each.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.caelum.vraptor.ioc.Component;
import br.com.each.ConnectionFactory.ConnectionFactory;
import br.com.each.model.ArtigoLivro;

@Component
public class ArtigoLivroDAO {

	private Connection connection;

	private PreparedStatement pstm;

	public ArtigoLivroDAO() {
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void salva(ArtigoLivro ArtigoLivro) {
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("insert into artigo_livro (autores,tema,titulo,titulo_original,editores_livro,nro_edicao,local_publicacao,editora,ano_publicacao,nro_paginas) values (?,?,?,?,?,?,?,?,?,?)");
			pstm.setString(1, ArtigoLivro.getAutor());
			pstm.setString(2, ArtigoLivro.getTema());
			pstm.setString(3, ArtigoLivro.getTitulo());
			pstm.setString(4, ArtigoLivro.getTituloOriginal());
			pstm.setString(5, ArtigoLivro.getEditoresLivro());
			pstm.setLong(6, ArtigoLivro.getNroEdicao());
			pstm.setString(7, ArtigoLivro.getLocalPublicacao());
			pstm.setString(8, ArtigoLivro.getEditora());
			pstm.setString(9, ArtigoLivro.getAnoPublicacao());
			pstm.setLong(10, ArtigoLivro.getNroPaginas());
			pstm.executeUpdate();
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// BUSCA POR CODIGO TODAS COLETANEAS DE MESMO (AUTOR,TEMA,TITULO,ETC....)
	public List<ArtigoLivro> buscaPoAutor(String titulo) {
		List<ArtigoLivro> LivroDeArtigos = new ArrayList<>();
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("select * from artigo_livro where autores = ?");
			pstm.setString(1, titulo);
			pstm.execute();

			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				ArtigoLivro LivroDeArtigo = new ArtigoLivro();
				LivroDeArtigo.setId(set.getLong("cod_LivroDeArtigo"));
				LivroDeArtigo.setNroEdicao(set.getLong("id_artigo_periodico"));
				LivroDeArtigo.setNroPaginas(set
						.getLong("id_artigo_anais_de_conferencias"));
				LivroDeArtigos.add(LivroDeArtigo);
			}
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return LivroDeArtigos;
	}
	/*
	 * // RETORNAR TODU public List<ArtigoLivro>
	 * lista() { List<ArtigoLivro> LivroDeArtigos = new ArrayList<>(); try {
	 * this.connection = ConnectionFactory.getConnection(); pstm =
	 * this.connection.prepareStatement("select * from coletanea");
	 * pstm.execute();
	 * 
	 * ResultSet set = pstm.executeQuery(); while (set.next()) { LivrosDeArtigo
	 * LivroDeArtigo = new LivrosDeArtigo();
	 * LivroDeArtigo.setId(set.getLong("cod_LivroDeArtigo")); LivroDeArtigo
	 * .setNroEdicao(set.getLong("id_artigo_periodico"));
	 * LivroDeArtigo.setNroPaginas(set
	 * .getLong("id_artigo_anais_de_conferencias"));
	 * LivroDeArtigos.add(LivroDeArtigo); }
	 * 
	 * pstm.close(); connection.close(); } catch (SQLException e) {
	 * e.printStackTrace(); }
	 */
	/*
	 * return LivroDeArtigos; }
	 * 
	 * 
	 * REMOVE
	 * 
	 * 
	 * public void remove(String nome) {
	 * 
	 * try { this.connection = ConnectionFactory.getConnection(); pstm =
	 * this.connection
	 * .prepareStatement("delete from usuario where cod_usuario = ?");
	 * pstm.setString(1, nome); pstm.executeUpdate(); pstm.close();
	 * connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 */
}