package br.com.each.Controller;


import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.each.dao.MonografiaDAO;
import br.com.each.model.Monografia;


@Resource
public class MonografiaController {

	private Result result;
	private MonografiaDAO MonografiaDAO;

	public MonografiaController(Result result, MonografiaDAO MonografiaDAO) {
		this.result = result;
		this.MonografiaDAO = MonografiaDAO;
	}

	@Get("/monografia/form")
	public void form() {
	}

	@Post("/monografia/salvar")
	public void save(Monografia monografia) {
		MonografiaDAO.salva(monografia);
		result.forwardTo(IndexController.class).index();
	}

}