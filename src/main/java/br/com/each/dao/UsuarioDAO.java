package br.com.each.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.caelum.vraptor.ioc.Component;
import br.com.each.ConnectionFactory.ConnectionFactory;
import br.com.each.model.Usuario;

@Component
public class UsuarioDAO {

	private Connection connection;

	private PreparedStatement pstm;

	public UsuarioDAO() {
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void salva(Usuario usuario) {
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("insert into usuario (nome,telefone,cpf) values (?,?,?)");
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getTelefone());
			pstm.setLong(3, usuario.getCpf());
			pstm.executeUpdate();
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public List<Usuario> buscaPoNome(String nome) {
			List<Usuario> usuarios= new ArrayList<>();
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("select * from usuario where nome = ?");
			pstm.setString(1, nome);
			pstm.execute();

			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				Usuario usuari1 = new Usuario();
				usuari1.setId(set.getLong("cpf"));
				usuari1.setNome(set.getString("nome"));
				usuari1.setTelefone(set.getString("telefone"));
				usuarios.add(usuari1);
			}
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarios;
	}
	

	public List<Usuario> lista() {
		List<Usuario> usuarios = new ArrayList<>();
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("select * from usuario");
			pstm.execute();

			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				Usuario usuario = new Usuario();
				usuario.setNome(set.getString("nome"));
				
				usuarios.add(usuario);
			}

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	public void remove(String nome) {

		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("delete from usuario where cod_usuario = ?");
			pstm.setString(1, nome);
			pstm.executeUpdate();
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}