package br.com.each.Controller;


import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.each.dao.ArtigoAnaisDAO;
import br.com.each.model.ArtigoAnais;

@Resource
public class ArtigoAnaisController {

	private Result result;
	private ArtigoAnaisDAO ArtigoAnaisDAO;

	public ArtigoAnaisController(Result result,
			ArtigoAnaisDAO ArtigoAnaisDAO) {
		this.result = result;
		this.ArtigoAnaisDAO = ArtigoAnaisDAO;
	}

	@Get("/artigoAnais/form")
	public void form() {
	}

	@Post("/artigoAnais/salvar")
	public void save(ArtigoAnais artigoAnais) {
		ArtigoAnaisDAO.salva(artigoAnais);
		result.forwardTo(IndexController.class).index();
	}


}