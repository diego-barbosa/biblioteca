package br.com.each.Controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.each.dao.ArtigoLivroDAO;
import br.com.each.model.ArtigoLivro;

@Resource
public class ArtigoLivroController {

	private Result result;
	private ArtigoLivroDAO artigoLivroDAO;

	public ArtigoLivroController(Result result, ArtigoLivroDAO artigoLivroDAO) {
		this.result = result;
		this.artigoLivroDAO = artigoLivroDAO;
	}

	@Get("/artigoLivro/form")
	public void form() {
	}

	@Post("/artigoLivro/salvar")
	public void save(ArtigoLivro artigoLivro) {
		artigoLivroDAO.salva(artigoLivro);
		result.forwardTo(IndexController.class).index();
	}

}