package br.com.each.Controller;


import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.each.dao.ColetaneaAnaisDAO;
import br.com.each.model.ColetaneaAnais;

@Resource
public class ColetaneaAnaisController {

	private Result result;
	private ColetaneaAnaisDAO coletaneaAnaisDAO;

	public ColetaneaAnaisController(Result result, ColetaneaAnaisDAO coletaneaAnaisDAO) {
		this.result = result;
		this.coletaneaAnaisDAO = coletaneaAnaisDAO;
	}

	@Get("/coletaneaAnais/form")
	public void form() {
	}

	@Post("/coletaneaAnais/salvar")
	public void save(ColetaneaAnais ColetaneaPeriodicoDAO) {
		coletaneaAnaisDAO.salva(ColetaneaPeriodicoDAO);
		result.forwardTo(IndexController.class).index();
	}


}