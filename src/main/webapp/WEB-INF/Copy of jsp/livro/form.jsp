<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/ufc/livros/salvar" method="post">

	Autor:    <input name="livro.autor"/><br>
	Tema:    <input name="livro.tema"/><br>
	Titulo:   <input name="livro.titulo"/><br>
	Titulo Original:     <input name="livro.tituloOriginal"/><br>
	Numero da Edição:     <input name="livro.nroEdicao"/><br>
	Local Publicacao:     <input name="livro.localPublicacao"/><br>
	Editaora: <input name="livro.editora"/><br>
	Ano Publicacao:     <input name="livro.anoPublicacao"/><br>
	Numero da Paginas:     <input name="livro.nroPaginas"/><br>
	Codigo Coletanea:     <input name="livro.codColetanea"/><br>
	
	
	
	
<input type="submit"value=Inserir />

</form>
</body>
</html>