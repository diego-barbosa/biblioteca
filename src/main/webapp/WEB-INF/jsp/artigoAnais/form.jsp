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
<form action="/ufc/artigoAnais/salvar" id="artigoAnaisForm" method="post">

	Autor:   			 <input name="artigoAnais.autor" required/><br>
	Tema: 				 <input name="artigoAnais.tema" required/><br>
	Titulo:     		 <input name="artigoAnais.titulo" required/><br>
	Titulo Original:     <input name="artigoAnais.tituloOriginal"/><br>
	Numero do Volume:    <input name="artigoAnais.nroVolume" required/><br>
	Local Publicacao:    <input name="artigoAnais.localPublicacao" required/><br>
	Editora:		     <input name="artigoAnais.editora" required/><br>
	Ano publicação:		 <input name="artigoAnais.anoPublicacao" required/><br>
	Pagina Inicio:		 <input name="artigoAnais.pagIni" required/><br>
	Pagina Fim:		     <input name="artigoAnais.pagFim" required/><br>


<input type="submit"value=Inserir />

</form>
<script>
$("#artigoAnaisForm").validate();
</script>
</body>
</html>