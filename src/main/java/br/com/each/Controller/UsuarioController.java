package br.com.each.Controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.each.dao.UsuarioDAO;
import br.com.each.model.Usuario;

@Resource
public class UsuarioController {

	private Result result;
	private UsuarioDAO usuarioDAO;

	public UsuarioController(Result result, UsuarioDAO usuarioDAO) {
		this.result = result;
		this.usuarioDAO = usuarioDAO;
	}

	@Get("/usuarios/form")
	public void form() {
	}

	@Get("/usuarios/usu")
	public void usuario() {
	}

	@Post("/usuarios/salvar")
	public void save(Usuario usuario) {
		usuarioDAO.salva(usuario);
		result.forwardTo(IndexController.class).index();
	}

	@Get("/usuarios/findbyname")
	public void perfil(String usuarios) {
		List<Usuario> usuario = usuarioDAO.buscaPoNome(usuarios);
		result.include("usuario", usuario);
		result.forwardTo(IndexController.class).index();
	}

}