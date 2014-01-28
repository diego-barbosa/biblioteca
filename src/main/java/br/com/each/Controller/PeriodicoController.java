package br.com.each.Controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.each.dao.PeriodicoDAO;
import br.com.each.model.Periodico;

@Resource
public class PeriodicoController {

	private Result result;
	private PeriodicoDAO periodicoDAO;

	public PeriodicoController(Result result, PeriodicoDAO periodicoDAO) {
		this.result = result;
		this.periodicoDAO = periodicoDAO;
	}

	@Get("/periodicos/form")
	public void form() {
	}

	@Post("/periodico/salvar")
	public void save(Periodico periodico) {
		periodicoDAO.salva(periodico);
		result.forwardTo(IndexController.class).index();
	}


}