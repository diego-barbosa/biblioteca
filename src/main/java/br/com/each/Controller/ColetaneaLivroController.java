package br.com.each.Controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.each.dao.ColetaneaLivroDAO;
import br.com.each.model.ColetaneaLivro;

@Resource
public class ColetaneaLivroController {

	private Result result;
	private ColetaneaLivroDAO coletaneaLivroDAO;

	public ColetaneaLivroController(Result result, ColetaneaLivroDAO coletaneaLivroDAO) {
		this.result = result;
		this.coletaneaLivroDAO = coletaneaLivroDAO;
	}

	@Get("/coletaneaLivro/form")
	public void form() {
	}

	@Post("/coletaneaLivro/salvar")
	public void save(ColetaneaLivro ColetaneaLivroDAO) {
		coletaneaLivroDAO.salva(ColetaneaLivroDAO);
		result.forwardTo(IndexController.class).index();
	}


}