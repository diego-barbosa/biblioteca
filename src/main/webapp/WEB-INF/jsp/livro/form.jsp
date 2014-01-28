<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="http://jquery.bassistance.de/validate/jquery.validate.js"></script>
</head>
<body>
<form action="/ufc/livros/salvar" id="livroForm" method="post">

	Autor:    <input name="livro.autor" required/><br>
	Tema:    <input name="livro.tema" required/><br>
	Titulo:   <input name="livro.titulo" required/><br>
	Titulo Original:     <input name="livro.tituloOriginal"/><br>
	Numero da Edição:     <input name="livro.nroEdicao" required/><br>
	Local Publicacao:     <input name="livro.localPublicacao" required/><br>
	Editaora: <input name="livro.editora" required/><br>
	Ano Publicacao:     <input name="livro.anoPublicacao required"/><br>
	Numero da Paginas:     <input name="livro.nroPaginas" required/><br>
	Codigo Coletanea:     <input name="livro.codColetanea"required/><br>
	
	
	
	
<input type="submit"value=Inserir />

</form>
<script>
$("#livroForm").validate();
</script>
</body>
</html>