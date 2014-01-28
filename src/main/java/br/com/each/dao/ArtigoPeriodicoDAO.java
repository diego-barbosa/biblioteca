package br.com.each.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.caelum.vraptor.ioc.Component;
import br.com.each.ConnectionFactory.ConnectionFactory;
import br.com.each.model.ArtigoPeriodico;

@Component
public class ArtigoPeriodicoDAO {

	private Connection connection;

	private PreparedStatement pstm;

	public ArtigoPeriodicoDAO() {
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void salva(ArtigoPeriodico artigoPeriodico) {
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("insert into artigo_periodico (autores,tema,titulo,titulo_original,nro_volume,local_publicacao,editora,ano_publicacao,pag_ini,pag_final) values (?,?,?,?,?,?,?,?,?,?)");
			pstm.setString(1, artigoPeriodico.getAutor());
			pstm.setString(2, artigoPeriodico.getTema());
			pstm.setString(3, artigoPeriodico.getTitulo());
			pstm.setString(4, artigoPeriodico.getTituloOriginal());
			pstm.setLong(5, artigoPeriodico.getNroVolume());
			pstm.setString(6, artigoPeriodico.getLocalPublicacao());
			pstm.setString(7, artigoPeriodico.getEditora());
			pstm.setString(8, artigoPeriodico.getAnoPublicacao());
			pstm.setLong(9, artigoPeriodico.getPagIni());
			pstm.setLong(10, artigoPeriodico.getPagFim());
			pstm.executeUpdate();
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// BUSCA POR CODIGO TODAS COLETANEAS DE MESMO (AUTOR,TEMA,TITULO,ETC....)
	public List<ArtigoPeriodico> buscaPoAutor(String titulo) {
		List<ArtigoPeriodico> ArtigoPeriodicos = new ArrayList<>();
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("select * from artigo_livro where autores = ?");
			pstm.setString(1, titulo);
			pstm.execute();

			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				ArtigoPeriodico ArtigoPeriodico = new ArtigoPeriodico();
				ArtigoPeriodico.setId(set.getLong("cod_LivroDeArtigo"));
				ArtigoPeriodicos.add(ArtigoPeriodico);
			}
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ArtigoPeriodicos;
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