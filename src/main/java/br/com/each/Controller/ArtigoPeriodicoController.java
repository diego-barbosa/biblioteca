package br.com.each.Controller;


import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.each.dao.ArtigoPeriodicoDAO;
import br.com.each.model.ArtigoPeriodico;

@Resource
public class ArtigoPeriodicoController {

	private Result result;
	private ArtigoPeriodicoDAO ArtigoPeriodicoDAO;

	public ArtigoPeriodicoController(Result result,
			ArtigoPeriodicoDAO ArtigoPeriodicoDAO) {
		this.result = result;
		this.ArtigoPeriodicoDAO = ArtigoPeriodicoDAO;
	}

	@Get("/artigoPeriodico/form")
	public void form() {
	}

	@Post("/artigoPeriodico/salvar")
	public void save(ArtigoPeriodico artigoPeriodico) {
		ArtigoPeriodicoDAO.salva(artigoPeriodico);
		result.forwardTo(IndexController.class).index();
	}


}