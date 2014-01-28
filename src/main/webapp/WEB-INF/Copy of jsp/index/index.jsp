<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/ufc/css/bootstrap.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript" src="/ufc/js/bootstrap.js"></script>
<title>Insert title here</title>
</head>
<body>


<ul class="nav nav-tabs">
	<li><a href="#home" data-toggle="tab">Home</a></li>
    <li><a href="#inserir" data-toggle="tab">Inserir</a></li>
  	<li><a href="#buscar" data-toggle="tab">Buscar</a></li>
    <li><a href="#emprestimo" data-toggle="tab">Emprestismo</a></li>
   	<li><a href="#sair" data-toggle="tab">Sair</a></li>
</ul>

<!-- Tab panes -->
<div class="tab-content">
	<div class="tab-pane" id="home"> HOME </div>
  
  	<div class="tab-pane active" id="inserir"><br />
  	
  		<h3><span class="label label-default"><a href="/ufc/usuarios/form">Usuario</a></span><br><br /></h3>
  		<h3><span class="label label-default"><a href="/ufc/livros/form">Livro</a></span><br /><br /></h3>
		<h3><span class="label label-default"><a href="/ufc/artigoLivro/form">Artigo Livro</a></span><br /><br /></h3>
		<h3><span class="label label-default"><a href="/ufc/periodicos/form">Periodico</a></span><br /><br /></h3>
		<h3><span class="label label-default"><a href="/ufc/artigoPeriodico/form">Artigo Periodico</a></span><br /><br /></h3>
		<h3><span class="label label-default"><a href="/ufc/anais/form">Livro de Anais</a></span><br /><br /></h3>
		<h3><span class="label label-default"><a href="/ufc/artigoAnais/form">Artigo de Anais</a></span><br /><br /></h3>
		<h3><span class="label label-default"><a href="/ufc/monografia/form">Monografia</a></span><br /><br /></h3>
		<h3><span class="label label-default"><a href="/ufc/coletaneaLivro/form">Coletanea Livro</a></span><br /><br /></h3>
		<h3><span class="label label-default"><a href="/ufc/coletaneaPeriodico/form">Coletanea Periodico</a></span><br /><br /></h3>
		<h3><span class="label label-default"><a href="/ufc/coletaneaAnais/form">Coletanea Anais </a></span><br /><br /></h3>
	</div>	
  	<div class="tab-pane" id="buscar">
  	<br>
    	<h3><span class="label label-default"><a href="/ufc/usuarios/usu">Busca Usuario</a></span><br><br /></h3>
		<h3><span class="label label-default"><a href="/ufc/livros/autor">Busca Autor</a></span><br><br /></h3>
		<h3><span class="label label-default">Busca Titulo</span></h3>
	</div>
	<div class="tab-pane" id="emprestimo">SHIBATA</div>
	<div class="tab-pane" id="sair">...</div>
	
	</div>
</div>
</body>
</html>