package br.com.each.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.caelum.vraptor.ioc.Component;
import br.com.each.ConnectionFactory.ConnectionFactory;
import br.com.each.model.Publicacao;

@Component
public class PublicacaoDAO {

	private Connection connection;

	private PreparedStatement pstm;

	public PublicacaoDAO() {
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// BUSCA POR ORDEM ALFABETICA NOME PUBLICACOES LIVROS DE MESMO (AUTOR)
	public List<Publicacao> buscaPoAutor() {
		List<Publicacao> livros = new ArrayList<>();
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement(("(select id_artigo as id_publicacao, autores, tema, titulo, titulo_original,0 as nro_edicao, local_publicacao, editora, ano_publicacao, 0 as nro_paginas  ,0 as cod_coletanea , '' as nome_instituicao, 0 as nro_monografia,'' as editores_livro, pag_ini, pag_final from ARTIGO_PERIODICO) UNION (select id_artigo as id_publicacao, autores, tema, titulo, titulo_original,0 as nro_edicao, local_publicacao, editora, ano_publicacao, 0 as nro_paginas , 0 as cod_coletanea, '' as nome_instituicao, 0 as nro_monografia,'' as editores_livro,  pag_ini, pag_final from ARTIGO_ANAIS_DE_CONFERENCIAS) UNION (select id_artigo as id_publicacao, autores, tema, titulo, titulo_original, nro_edicao , local_publicacao, editora, ano_publicacao, nro_paginas ,0 as cod_coletanea, '' as nome_instituicao, 0 as nro_monografia, editores_livro, 0 as pag_ini, 0 as pag_final from ARTIGO_LIVRO ) UNION (select id_livro as id_publicacao, autores, tema, titulo, titulo_original,nro_edicao, local_publicacao, editora, ano_publicacao, nro_paginas, cod_coletanea, '' as nome_instituicao, 0 as nro_monografia, '' as editores_livro , 0 as pag_ini, 0 as pag_final from LIVRO ) UNION (select id_monografias as id_publicacao, autores, tema, titulo, '' as titulo_original, 0 as nro_edicao, local_publicacao ,'' as editora , ano_publicacao ,0 as nro_paginas , 0 as cod_coletanea, nome_instituicao, nro_monografia, '' as editores_livro, 0 as pag_ini, 0 as pag_final from MONOGRAFIAS) order by autores ASC"));
			pstm.execute();

			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				Publicacao livro = new Publicacao();
				livro.setId(set.getLong("id_publicacao"));
				livro.setAutor(set.getString("autores"));
				livro.setTema(set.getString("tema"));
				livro.setTitulo(set.getString("titulo"));
				livro.setTituloOriginal(set.getString("titulo_original"));
				livro.setNroEdicao(set.getLong("nro_edicao"));
				livro.setLocalPublicacao(set.getString("local_publicacao"));
				livro.setEditora(set.getString("editora"));
				livro.setAnoPublicacao(set.getString("ano_publicacao"));
				livro.setNroPaginas(set.getLong("nro_paginas"));
				livro.setCodColetanea(set.getLong("cod_coletanea"));
				livro.setNomeInstituicao(set.getString("nome_instituicao"));
				livro.setNroMonografia(set.getLong("nro_monografia"));
				livro.setEditoresLivro(set.getString("editores_livro"));
				livro.setPagIni(set.getLong("pag_ini"));
				livro.setPagFim(set.getLong("pag_final"));
				livros.add(livro);
			}

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return livros;
	}

	// BUSCA POR ORDEM ALFABETICA TODOS PUBLICACOES DE MESMO (TEMA)
	public List<Publicacao> buscaPoTema() {
		List<Publicacao> livros = new ArrayList<>();
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("(select id_artigo as id_publicacao, autores, tema, titulo, titulo_original,0 as nro_edicao, local_publicacao, editora, ano_publicacao, 0 as nro_paginas  ,0 as cod_coletanea , '' as nome_instituicao, 0 as nro_monografia,'' as editores_livro, pag_ini, pag_final from ARTIGO_PERIODICO) UNION (select id_artigo as id_publicacao, autores, tema, titulo, titulo_original,0 as nro_edicao, local_publicacao, editora, ano_publicacao, 0 as nro_paginas , 0 as cod_coletanea, '' as nome_instituicao, 0 as nro_monografia,'' as editores_livro,  pag_ini, pag_final from ARTIGO_ANAIS_DE_CONFERENCIAS) UNION (select id_artigo as id_publicacao, autores, tema, titulo, titulo_original, nro_edicao , local_publicacao, editora, ano_publicacao, nro_paginas ,0 as cod_coletanea, '' as nome_instituicao, 0 as nro_monografia, editores_livro, 0 as pag_ini, 0 as pag_final from ARTIGO_LIVRO ) UNION (select id_livro as id_publicacao, autores, tema, titulo, titulo_original,nro_edicao, local_publicacao, editora, ano_publicacao, nro_paginas, cod_coletanea, '' as nome_instituicao, 0 as nro_monografia, '' as editores_livro , 0 as pag_ini, 0 as pag_final from LIVRO ) UNION (select id_monografias as id_publicacao, autores, tema, titulo, '' as titulo_original, 0 as nro_edicao, local_publicacao ,'' as editora , ano_publicacao ,0 as nro_paginas , 0 as cod_coletanea, nome_instituicao, nro_monografia, '' as editores_livro, 0 as pag_ini, 0 as pag_final from MONOGRAFIAS) order by tema ASC");
			pstm.execute();
			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				Publicacao livro = new Publicacao();
				livro.setId(set.getLong("id_publicacao"));
				livro.setAutor(set.getString("autores"));
				livro.setTema(set.getString("tema"));
				livro.setTitulo(set.getString("titulo"));
				livro.setTituloOriginal(set.getString("titulo_original"));
				livro.setNroEdicao(set.getLong("nro_edicao"));
				livro.setLocalPublicacao(set.getString("local_publicacao"));
				livro.setEditora(set.getString("editora"));
				livro.setAnoPublicacao(set.getString("ano_publicacao"));
				livro.setNroPaginas(set.getLong("nro_paginas"));
				livro.setCodColetanea(set.getLong("cod_coletanea"));
				livro.setNomeInstituicao(set.getString("nome_instituicao"));
				livro.setNroMonografia(set.getLong("nro_monografia"));
				livro.setEditoresLivro(set.getString("editores_livro"));
				livro.setPagIni(set.getLong("pag_ini"));
				livro.setPagFim(set.getLong("pag_final"));
				livros.add(livro);
			}

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return livros;
	}

	// BUSCA POR ORDEM ALFABETICA TODOS PUBLICACOES DE MESMO (TITULO)
	public List<Publicacao> buscaPoTitulo() {
		List<Publicacao> livros = new ArrayList<>();
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("(select id_artigo as id_publicacao, autores, tema, titulo, titulo_original,0 as nro_edicao, local_publicacao, editora, ano_publicacao, 0 as nro_paginas  ,0 as cod_coletanea , '' as nome_instituicao, 0 as nro_monografia,'' as editores_livro, pag_ini, pag_final from ARTIGO_PERIODICO) UNION (select id_artigo as id_publicacao, autores, tema, titulo, titulo_original,0 as nro_edicao, local_publicacao, editora, ano_publicacao, 0 as nro_paginas , 0 as cod_coletanea, '' as nome_instituicao, 0 as nro_monografia,'' as editores_livro,  pag_ini, pag_final from ARTIGO_ANAIS_DE_CONFERENCIAS) UNION (select id_artigo as id_publicacao, autores, tema, titulo, titulo_original, nro_edicao , local_publicacao, editora, ano_publicacao, nro_paginas ,0 as cod_coletanea, '' as nome_instituicao, 0 as nro_monografia, editores_livro, 0 as pag_ini, 0 as pag_final from ARTIGO_LIVRO ) UNION (select id_livro as id_publicacao, autores, tema, titulo, titulo_original,nro_edicao, local_publicacao, editora, ano_publicacao, nro_paginas, cod_coletanea, '' as nome_instituicao, 0 as nro_monografia, '' as editores_livro , 0 as pag_ini, 0 as pag_final from LIVRO ) UNION (select id_monografias as id_publicacao, autores, tema, titulo, '' as titulo_original, 0 as nro_edicao, local_publicacao ,'' as editora , ano_publicacao ,0 as nro_paginas , 0 as cod_coletanea, nome_instituicao, nro_monografia, '' as editores_livro, 0 as pag_ini, 0 as pag_final from MONOGRAFIAS) order by titulo ASC");
			pstm.execute();
			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				Publicacao livro = new Publicacao();
				livro.setId(set.getLong("id_publicacao"));
				livro.setAutor(set.getString("autores"));
				livro.setTema(set.getString("tema"));
				livro.setTitulo(set.getString("titulo"));
				livro.setTituloOriginal(set.getString("titulo_original"));
				livro.setNroEdicao(set.getLong("nro_edicao"));
				livro.setLocalPublicacao(set.getString("local_publicacao"));
				livro.setEditora(set.getString("editora"));
				livro.setAnoPublicacao(set.getString("ano_publicacao"));
				livro.setNroPaginas(set.getLong("nro_paginas"));
				livro.setCodColetanea(set.getLong("cod_coletanea"));
				livro.setNomeInstituicao(set.getString("nome_instituicao"));
				livro.setNroMonografia(set.getLong("nro_monografia"));
				livro.setEditoresLivro(set.getString("editores_livro"));
				livro.setPagIni(set.getLong("pag_ini"));
				livro.setPagFim(set.getLong("pag_final"));
				livros.add(livro);
			}
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return livros;
	}

	// BUSCA POR ORDEM CRONOLOGICA TODOS PUBLICACOES DE MESMO (AUTOR)
	public List<Publicacao> buscaPoAutorCronologica(String nome) {
		List<Publicacao> livros = new ArrayList<>();
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("(select id_artigo as id_publicacao, autores, tema, titulo, titulo_original,0 as nro_edicao, local_publicacao, editora, ano_publicacao, 0 as nro_paginas  ,0 as cod_coletanea , '' as nome_instituicao, 0 as nro_monografia,'' as editores_livro, pag_ini, pag_final from ARTIGO_PERIODICO where autores = ?) UNION (select id_artigo as id_publicacao, autores, tema, titulo, titulo_original,0 as nro_edicao, local_publicacao, editora, ano_publicacao, 0 as nro_paginas , 0 as cod_coletanea, '' as nome_instituicao, 0 as nro_monografia,'' as editores_livro,  pag_ini, pag_final from ARTIGO_ANAIS_DE_CONFERENCIAS where autores = ?) UNION (select id_artigo as id_publicacao, autores, tema, titulo, titulo_original, nro_edicao , local_publicacao, editora, ano_publicacao, nro_paginas ,0 as cod_coletanea, '' as nome_instituicao, 0 as nro_monografia, editores_livro, 0 as pag_ini, 0 as pag_final from ARTIGO_LIVRO where autores = ?) UNION (select id_livro as id_publicacao, autores, tema, titulo, titulo_original,nro_edicao, local_publicacao, editora, ano_publicacao, nro_paginas, cod_coletanea, '' as nome_instituicao, 0 as nro_monografia, '' as editores_livro , 0 as pag_ini, 0 as pag_final from LIVRO where autores = ?) UNION (select id_monografias as id_publicacao, autores, tema, titulo, '' as titulo_original, 0 as nro_edicao, local_publicacao ,'' as editora , ano_publicacao ,0 as nro_paginas , 0 as cod_coletanea, nome_instituicao, nro_monografia, '' as editores_livro, 0 as pag_ini, 0 as pag_final from MONOGRAFIAS where autores  = ?) order by ano_publicacao ASC");
			pstm.setString(1, nome);
			pstm.setString(2, nome);
			pstm.setString(3, nome);
			pstm.setString(4, nome);
			pstm.setString(5, nome);
			pstm.execute();
			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				Publicacao livro = new Publicacao();
				livro.setId(set.getLong("id_publicacao"));
				livro.setAutor(set.getString("autores"));
				livro.setTema(set.getString("tema"));
				livro.setTitulo(set.getString("titulo"));
				livro.setTituloOriginal(set.getString("titulo_original"));
				livro.setNroEdicao(set.getLong("nro_edicao"));
				livro.setLocalPublicacao(set.getString("local_publicacao"));
				livro.setEditora(set.getString("editora"));
				livro.setAnoPublicacao(set.getString("ano_publicacao"));
				livro.setNroPaginas(set.getLong("nro_paginas"));
				livro.setCodColetanea(set.getLong("cod_coletanea"));
				livro.setNomeInstituicao(set.getString("nome_instituicao"));
				livro.setNroMonografia(set.getLong("nro_monografia"));
				livro.setEditoresLivro(set.getString("editores_livro"));
				livro.setPagIni(set.getLong("pag_ini"));
				livro.setPagFim(set.getLong("pag_final"));
				livros.add(livro);
			}
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return livros;
	}

	// BUSCA POR ORDEM ALFABETICA TODOS PUBLICACOES DE MESMO (AUTOR) REFERENTE
	// AO MESMO (TEMA)
	public List<Publicacao> buscaPoTemaAutor(String tema) {
		List<Publicacao> livros = new ArrayList<>();
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("(select id_artigo as id_publicacao, autores, tema, titulo, titulo_original,0 as nro_edicao, local_publicacao, editora, ano_publicacao, 0 as nro_paginas  ,0 as cod_coletanea , '' as nome_instituicao, 0 as nro_monografia,'' as editores_livro, pag_ini, pag_final from ARTIGO_PERIODICO where tema = ?) UNION (select id_artigo as id_publicacao, autores, tema, titulo, titulo_original,0 as nro_edicao, local_publicacao, editora, ano_publicacao, 0 as nro_paginas , 0 as cod_coletanea, '' as nome_instituicao, 0 as nro_monografia,'' as editores_livro,  pag_ini, pag_final from ARTIGO_ANAIS_DE_CONFERENCIAS where tema = ?) UNION (select id_artigo as id_publicacao, autores, tema, titulo, titulo_original, nro_edicao , local_publicacao, editora, ano_publicacao, nro_paginas ,0 as cod_coletanea, '' as nome_instituicao, 0 as nro_monografia, editores_livro, 0 as pag_ini, 0 as pag_final from ARTIGO_LIVRO where tema = ?) UNION (select id_livro as id_publicacao, autores, tema, titulo, titulo_original,nro_edicao, local_publicacao, editora, ano_publicacao, nro_paginas, cod_coletanea, '' as nome_instituicao, 0 as nro_monografia, '' as editores_livro , 0 as pag_ini, 0 as pag_final from LIVRO where tema = ?) UNION (select id_monografias as id_publicacao, autores, tema, titulo, '' as titulo_original, 0 as nro_edicao, local_publicacao ,'' as editora , ano_publicacao ,0 as nro_paginas , 0 as cod_coletanea, nome_instituicao, nro_monografia, '' as editores_livro, 0 as pag_ini, 0 as pag_final from MONOGRAFIAS where autores  = ?) order by autores ASC");
			pstm.setString(1, tema);
			pstm.setString(2, tema);
			pstm.setString(3, tema);
			pstm.setString(4, tema);
			pstm.setString(5, tema);
			pstm.execute();
			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				Publicacao livro = new Publicacao();
				livro.setId(set.getLong("id_publicacao"));
				livro.setAutor(set.getString("autores"));
				livro.setTema(set.getString("tema"));
				livro.setTitulo(set.getString("titulo"));
				livro.setTituloOriginal(set.getString("titulo_original"));
				livro.setNroEdicao(set.getLong("nro_edicao"));
				livro.setLocalPublicacao(set.getString("local_publicacao"));
				livro.setEditora(set.getString("editora"));
				livro.setAnoPublicacao(set.getString("ano_publicacao"));
				livro.setNroPaginas(set.getLong("nro_paginas"));
				livro.setCodColetanea(set.getLong("cod_coletanea"));
				livro.setNomeInstituicao(set.getString("nome_instituicao"));
				livro.setNroMonografia(set.getLong("nro_monografia"));
				livro.setEditoresLivro(set.getString("editores_livro"));
				livro.setPagIni(set.getLong("pag_ini"));
				livro.setPagFim(set.getLong("pag_final"));
				livros.add(livro);
			}

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return livros;
	}

	// BUSCA POR ORDEM LOCALIZACAO DE UMA DETERMINADA PUBLICACAO
	public List<Publicacao> buscaPoLocalizacao(String titulo) {
		List<Publicacao> livros = new ArrayList<>();
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("(select local_publicacao from ARTIGO_PERIODICO where titulo = ?) UNION (select local_publicacao from ARTIGO_ANAIS_DE_CONFERENCIAS where titulo = ?) UNION (select local_publicacao from ARTIGO_LIVRO where titulo = ?) UNION (select local_publicacao from LIVRO where titulo = ?) UNION (select local_publicacao from MONOGRAFIAS where titulo = ?)");
			pstm.setString(1, titulo);
			pstm.setString(2, titulo);
			pstm.setString(3, titulo);
			pstm.setString(4, titulo);
			pstm.setString(5, titulo);
			pstm.execute();
			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				Publicacao livro = new Publicacao();
				livro.setLocalPublicacao(set.getString("local_publicacao"));
				livros.add(livro);
			}

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return livros;
	}

	// BUSCA POR ORDEM ANAIS
	public List<Publicacao> buscaPoAnais(int titulo) {
		List<Publicacao> livros = new ArrayList<>();
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement(" select * from ARTIGO_ANAIS_DE_CONFERENCIAS where id_artigo in (select id_artigo_anais_de_conferencias from COLETANEA_PUBLICACAO  where cod_coletanea = (select cod_coletanea from ANAIS_DE_CONFERENCIAS where id_anais_de_conferencias = ?)  )");
			pstm.setLong(1, titulo);
			pstm.execute();
			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				Publicacao livro = new Publicacao();
				livro.setId(set.getLong("id_artigo"));
				livro.setAutor(set.getString("autores"));
				livro.setTema(set.getString("tema"));
				livro.setTitulo(set.getString("titulo"));
				livro.setTituloOriginal(set.getString("titulo_original"));
				livro.setLocalPublicacao(set.getString("local_publicacao"));
				livro.setAnoPublicacao(set.getString("ano_publicacao"));
				livro.setPagIni(set.getLong("pag_ini"));
				livro.setPagFim(set.getLong("pag_final"));
				livros.add(livro);
			}

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return livros;
	}
	// BUSCA POR ORDEM PERIODICO
	public List<Publicacao> buscaPoPeriodico(String ini, String fim , int id) {
		List<Publicacao> livros = new ArrayList<>();
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement(" select * from ARTIGO_PERIODICO where ano_publicacao > ? and ano_publicacao < ? and id_artigo in(select id_artigo_periodico from COLETANEA_PUBLICACAO  where cod_coletanea =  (select cod_coletanea from PERIODICO where id_periodico = ?) ) order by ano_publicacao");
			pstm.setString(1, ini);
			pstm.setString(2, fim);
			pstm.setLong(3, id);
			pstm.execute();
			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				Publicacao livro = new Publicacao();
				livro.setId(set.getLong("id_artigo"));
				livro.setAutor(set.getString("autores"));
				livro.setTema(set.getString("tema"));
				livro.setTitulo(set.getString("titulo"));
				livro.setTituloOriginal(set.getString("titulo_original"));
				livro.setLocalPublicacao(set.getString("local_publicacao"));
				livro.setAnoPublicacao(set.getString("ano_publicacao"));
				livro.setPagIni(set.getLong("pag_ini"));
				livro.setPagFim(set.getLong("pag_final"));
				livros.add(livro);
			}

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return livros;
	}
}