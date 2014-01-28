package br.com.each.Controller;


import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.each.dao.AnaisDAO;
import br.com.each.model.Anais;


@Resource
public class AnaisController {

	private Result result;
	private AnaisDAO anaisDAO;

	public AnaisController(Result result, AnaisDAO anaisDAO) {
		this.result = result;
		this.anaisDAO = anaisDAO;
	}

	@Get("/anais/form")
	public void form() {
	}

	@Post("/anais/salvar")
	public void save(Anais anais) {
		anaisDAO.salva(anais);
		result.forwardTo(IndexController.class).index();
	}


}