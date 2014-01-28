package br.com.each.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.caelum.vraptor.ioc.Component;
import br.com.each.ConnectionFactory.ConnectionFactory;
import br.com.each.model.ArtigoAnais;

@Component
public class ArtigoAnaisDAO {

	private Connection connection;

	private PreparedStatement pstm;

	public ArtigoAnaisDAO() {
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void salva(ArtigoAnais ArtigoAnais) {
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("insert into artigo_anais_de_conferencias (autores,tema,titulo,titulo_original,volume,local_publicacao,editora,ano_publicacao,pag_ini,pag_final) values (?,?,?,?,?,?,?,?,?,?)");
			pstm.setString(1, ArtigoAnais.getAutor());
			pstm.setString(2, ArtigoAnais.getTema());
			pstm.setString(3, ArtigoAnais.getTitulo());
			pstm.setString(4, ArtigoAnais.getTituloOriginal());
			pstm.setLong(5, ArtigoAnais.getNroVolume());
			pstm.setString(6, ArtigoAnais.getLocalPublicacao());
			pstm.setString(7, ArtigoAnais.getEditora());
			pstm.setString(8, ArtigoAnais.getAnoPublicacao());
			pstm.setLong(9, ArtigoAnais.getPagIni());
			pstm.setLong(10, ArtigoAnais.getPagFim());
			pstm.executeUpdate();
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}