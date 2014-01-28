<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/ufc/artigoAnais/salvar" method="post">

	Autor:   			 <input name="artigoAnais.autor"/><br>
	Tema: 				 <input name="artigoAnais.tema"/><br>
	Titulo:     		 <input name="artigoAnais.titulo"/><br>
	Titulo Original:     <input name="artigoAnais.tituloOriginal"/><br>
	Numero do Volume:    <input name="artigoAnais.nroVolume"/><br>
	Local Publicacao:    <input name="artigoAnais.localPublicacao"/><br>
	Editora:		     <input name="artigoAnais.editora"/><br>
	Ano publicação:		 <input name="artigoAnais.anoPublicacao"/><br>
	Pagina Inicio:		 <input name="artigoAnais.pagIni"/><br>
	Pagina Fim:		     <input name="artigoAnais.pagFim"/><br>


<input type="submit"value=Inserir />

</form>
</body>
</html>