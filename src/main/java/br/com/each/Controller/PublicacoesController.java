package br.com.each.Controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.each.dao.PublicacaoDAO;
import br.com.each.model.Publicacao;

@Resource
public class PublicacoesController {

	private Result result;
	private PublicacaoDAO PublicacaoDAO;

	public PublicacoesController(Result result, PublicacaoDAO publicacaoDAO) {
		this.result = result;
		this.PublicacaoDAO = publicacaoDAO;
	}

	// Inicio 3.1
	@Get("/publicacao/buscaAutor")
	public void buscaAutor() {
	}

	@Get("/publicacao/find/byAutor")
	public void byAutor() {
		List<Publicacao> usuario = PublicacaoDAO.buscaPoAutor();
		result.include("usuario", usuario);
	}

	// Fim 3.1
	// Inicio 3.2
	@Get("/publicacao/buscaTema")
	public void buscaTema() {
	}

	@Get("/publicacao/find/byTema")
	public void byTema() {
		List<Publicacao> usuario = PublicacaoDAO.buscaPoTema();
		result.include("usuario", usuario);
	}

	// Fim 3.2
	// Inicio 3.3
	@Get("/publicacao/buscaTitulo")
	public void buscaTitulo() {
	}

	@Get("/publicacao/find/byTitulo")
	public void byTitulo() {
		List<Publicacao> usuario = PublicacaoDAO.buscaPoTitulo();
		result.include("usuario", usuario);
	}

	// Fim 3.3
	// Inicio 3.7
	@Get("/publicacao/buscaTemaAutor")
	public void buscaTemaAutor() {
	}

	@Get("/publicacao/find/byTemaAutor")
	public void byTemaAutor(String usuarios) {
		List<Publicacao> usuario = PublicacaoDAO.buscaPoTemaAutor(usuarios);
		result.include("usuario", usuario);
	}

	// Fim 3.7
	// Inicio 3.6
	@Get("/publicacao/buscaAutorCronologico")
	public void buscaAutorCronologico() {
	}

	@Get("/publicacao/find/byAutorCronologico")
	public void byAutorCronologico(String usuarios) {
		List<Publicacao> usuario = PublicacaoDAO
				.buscaPoAutorCronologica(usuarios);
		result.include("usuario", usuario);
	}

	// Fim 3.6
	// Inicio 3.9
	@Get("/publicacao/buscaLocalizacao")
	public void buscaLocalizacao() {
	}

	@Get("/publicacao/find/byLocalizacao")
	public void byLocalizacao(String usuarios) {
		List<Publicacao> usuario = PublicacaoDAO.buscaPoLocalizacao(usuarios);
		result.include("usuario", usuario);
	}

	// Fim 3.4
	@Get("/publicacao/buscaAnais")
	public void buscaAnais() {
	}

	@Get("/publicacao/find/byAnais")
	public void byAnais(int usuarios) {
		List<Publicacao> usuario = PublicacaoDAO.buscaPoAnais(usuarios);
		result.include("usuario", usuario);
	}

	// Fim 3.4
	// Fim 3.5
	@Get("/publicacao/buscaPeriodico")
	public void buscaPeriodico() {
	}

	@Get("/publicacao/find/byPeriodico")
	public void byPeriodico(String ini, String fim, int usuarios) {
		List<Publicacao> usuario = PublicacaoDAO.buscaPoPeriodico(ini, fim,	usuarios);
		result.include("usuario", usuario);
	}
	// Fim 3.5
}