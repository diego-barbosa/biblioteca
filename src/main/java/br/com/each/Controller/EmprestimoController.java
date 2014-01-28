package br.com.each.Controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.each.dao.EmprestimoDAO;
import br.com.each.model.Emprestimo;
import br.com.each.model.Usuario;

@Resource
public class EmprestimoController {

	private Result result;
	private EmprestimoDAO emprestimoDAO;

	public EmprestimoController(Result result, EmprestimoDAO emprestimoDAO) {
		this.result = result;
		this.emprestimoDAO = emprestimoDAO;
	}

	@Get("/emprestimo/form")
	public void form() {
	}

	@Get("/emprestimo/emp")
	public void emprestimo() {
	}

	@Post("/emprestimo/salvar")
	public void save(Emprestimo usuario) {
		emprestimoDAO.salva(usuario);
		result.forwardTo(IndexController.class).index();
	}

	@Get("/emprestimo/findbyname")
	public void perfil(int usuarios, int tipo_publicacao) {
		List<Usuario> usuario = emprestimoDAO.buscaPoNome(usuarios,
				tipo_publicacao);
		result.include("usuario", usuario);
		}

}