package br.com.each.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.caelum.vraptor.ioc.Component;
import br.com.each.ConnectionFactory.ConnectionFactory;
import br.com.each.model.Anais;

@Component
public class AnaisDAO {

	private Connection connection;

	private PreparedStatement pstm;

	public AnaisDAO() {
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void salva(Anais anais) {
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("insert into anais_de_conferencias (titulo,tema,local_publicacao,editora,ano_publicacao,fl_terminou,cod_coletanea) values (?,?,?,?,?,?,?)");
			pstm.setString(1, anais.getTitulo());
			pstm.setString(2, anais.getTema());
			pstm.setString(3, anais.getLocalPublicacao());
			pstm.setString(4, anais.getEditora());
			pstm.setString(5, anais.getAnoPublicacao());
			pstm.setString(6, anais.getFlTerminou());
			pstm.setLong(7, anais.getCodColetanea());
			pstm.executeUpdate();
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}