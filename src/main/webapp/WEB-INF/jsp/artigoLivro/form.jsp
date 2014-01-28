<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="http://jquery.bassistance.de/validate/jquery.validate.js"></script>
<body>
<form action="/ufc/artigoLivro/salvar" id="artigoLivroForm" method="post">

	Autor:   			 <input name="artigoLivro.autor" required/><br>
	Tema: 				 <input name="artigoLivro.tema" required/><br>
	Titulo:     		 <input name="artigoLivro.titulo" required/><br>
	Titulo Original:     <input name="artigoLivro.tituloOriginal"/><br>
	Editores Livros:     <input name="artigoLivro.editoresLivro"/><br>
	Numero de Edicao:    <input name="artigoLivro.nroEdicao" required/><br>
	Local Publicacao:    <input name="artigoLivro.localPublicacao" required/><br>
	Editora:		     <input name="artigoLivro.editora" required/><br>
	Ano publicação:		 <input name="artigoLivro.anoPublicacao" required/><br>
	Numero de Paginas:	 <input name="artigoLivro.nroPaginas" required/><br>
	
	
	
<input type="submit"value=Inserir />

</form>
<script>
$("#artigoLivroForm").validate();
</script>
</body>
</html>

