package br.com.each.Controller;


import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.each.dao.ColetaneaPeriodicoDAO;
import br.com.each.model.ColetaneaPeriodico;

@Resource
public class ColetaneaPeriodicoController {

	private Result result;
	private ColetaneaPeriodicoDAO coletaneaPeriodicoDAO;

	public ColetaneaPeriodicoController(Result result, ColetaneaPeriodicoDAO coletaneaPeriodicoDAO) {
		this.result = result;
		this.coletaneaPeriodicoDAO = coletaneaPeriodicoDAO;
	}

	@Get("/coletaneaPeriodico/form")
	public void form() {
	}


	@Post("/coletaneaPeriodico/salvar")
	public void save(ColetaneaPeriodico ColetaneaPeriodicoDAO) {
		coletaneaPeriodicoDAO.salva(ColetaneaPeriodicoDAO);
		result.forwardTo(IndexController.class).index();
	}


}