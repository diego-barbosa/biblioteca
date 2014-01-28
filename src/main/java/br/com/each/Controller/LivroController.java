package br.com.each.Controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.each.dao.LivroDAO;
import br.com.each.model.Livro;

@Resource
public class LivroController {

	private Result result;
	private LivroDAO livroDAO;

	public LivroController(Result result, LivroDAO livroDAO) {
		this.result = result;
		this.livroDAO = livroDAO;
	}

	@Get("/livros/form")
	public void form() {
	}

	@Post("/livros/salvar")
	public void save(Livro livro) {
		livroDAO.salva(livro);
		result.forwardTo(IndexController.class).index();
	}


}