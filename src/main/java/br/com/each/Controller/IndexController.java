package br.com.each.Controller;

//import java.util.List;

//import br.com.caelum.vraptor.Consumes;
//import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
///import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
//import br.com.caelum.vraptor.view.Results;
//import br.com.each.dao.UsuarioDAO;
//import br.com.each.model.Usuario;

@Resource
public class IndexController {

	private Result result;

	public IndexController(Result result) {
		this.setResult(result);
	}

	@Get("/index")
	public void index() {
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

}