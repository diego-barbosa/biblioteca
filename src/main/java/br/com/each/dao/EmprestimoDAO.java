package br.com.each.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.caelum.vraptor.ioc.Component;
import br.com.each.ConnectionFactory.ConnectionFactory;
import br.com.each.model.Emprestimo;
import br.com.each.model.Usuario;

@Component
public class EmprestimoDAO {

	private Connection connection;

	private PreparedStatement pstm;

	public EmprestimoDAO() {
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void salva(Emprestimo usuario) {
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("insert into emprestimo (cpf,id_publicacao ,tipo_publicacao) values ( ?,?,? )");
			pstm.setLong(1, usuario.getCpf());
			pstm.setLong(2, usuario.getId_publicacao());
			pstm.setLong(3, usuario.getTipo_publicacao());
			pstm.executeUpdate();
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public List<Usuario> buscaPoNome(int id_publicacao, int tipo_publicacao) {
			List<Usuario> usuarios= new ArrayList<>();
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("select nome from USUARIO where cpf = (select cpf from EMPRESTIMO where id_publicacao = ? and tipo_publicacao = ?)");
			pstm.setInt(1, id_publicacao);
			pstm.setInt(2, tipo_publicacao);
			pstm.execute();

			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				Usuario usuari1 = new Usuario();
				usuari1.setNome(set.getString("nome"));
				usuarios.add(usuari1);
			}
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarios;
	}
	


}