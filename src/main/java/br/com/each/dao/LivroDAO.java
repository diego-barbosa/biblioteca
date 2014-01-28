package br.com.each.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.caelum.vraptor.ioc.Component;
import br.com.each.ConnectionFactory.ConnectionFactory;
import br.com.each.model.Livro;

@Component
public class LivroDAO {

	private Connection connection;

	private PreparedStatement pstm;

	public LivroDAO() {
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void salva(Livro livro) {
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("insert into livro (titulo, editora, autores,titulo_original,nro_edicao,local_publicacao,nro_paginas,ano_publicacao,cod_coletanea) values (?,?,?,?,?,?,?,?,?)");
			pstm.setString(1, livro.getTitulo());
			pstm.setString(2, livro.getEditora());
			pstm.setString(3, livro.getAutor());
			pstm.setString(4, livro.getTituloOriginal());
			pstm.setLong(5, livro.getNroEdicao());
			pstm.setString(6, livro.getLocalPublicacao());
			pstm.setLong(7, livro.getNroPaginas());
			pstm.setString(8, livro.getAnoPublicacao());
			pstm.setLong(9, livro.getCodColetanea());
			pstm.executeUpdate();
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

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
	public List<Livro> buscaPoNome(String nome) {
		List<Livro> livros = new ArrayList<>();
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("(select id_artigo as id_publicacao, autores, tema, titulo, titulo_original,'' as nro_edicao, local_publicacao, editora, ano_publicacao,'' as nro_paginas  ,'' as cod_coletanea , '' as nome_instituicao, '' as nro_monografia,'' as editores_livro, '' as pag_ini, pag_final from ARTIGO_PERIODICO where autores = '?')UNION(select id_artigo as id_publicacao, autores, tema, titulo, titulo_original,'' as nro_edicao, local_publicacao, editora, ano_publicacao,'' as nro_paginas , '' as cod_coletanea, '' as nome_instituicao, '' as nro_monografia,'' as editores_livro,  pag_ini, pag_final from ARTIGO_ANAIS_DE_CONFERENCIAS  where autores = '?)UNION (select id_artigo as id_publicacao, autores, tema, titulo, titulo_original,nro_edicao , local_publicacao, editora, ano_publicacao, nro_paginas ,'' as cod_coletanea, '' as nome_instituicao, '' as nro_monografia, editores_livro, '' as pag_ini, '' as pag_final from ARTIGO_LIVRO  where autores = '?') UNION (select id_livro as id_publicacao, autores, tema, titulo, titulo_original,nro_edicao, local_publicacao, editora, ano_publicacao, nro_paginas, cod_coletanea, '' as nome_instituicao, '' as nro_monografia, '' as pag_ini, '' as pag_final from LIVRO  where autores = '?') UNION (select id_monografias as id_publicacao, autores, tema, titulo, '' as titulo_original, '' as nro_edicao, local_publicacao ,'' as editora , ano_publicacao ,'' as nro_paginas , '' as cod_coletanea, nome_instituicao, nro_monografia, '' as pag_ini, '' as pag_final from MONOGRAFIAS where autores = '?') order by ano_publicacao");
			pstm.setString(1, nome);
			pstm.execute();

			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				Livro livro = new Livro();
				livro.setId(set.getLong("id_livro"));
				livro.setTitulo(set.getString("titulo"));
				livro.setAutor(set.getString("autores"));
				livro.setEditora(set.getString("editora"));
				livro.setTituloOriginal(set.getString("titulo_original"));
				livro.setNroEdicao(set.getLong("nro_edicao"));
				livro.setLocalPublicacao(set.getString("local_publicacao"));
				livro.setNroPaginas(set.getLong("nro_paginas"));
				livro.setAnoPublicacao(set.getString("ano_publicacao"));
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