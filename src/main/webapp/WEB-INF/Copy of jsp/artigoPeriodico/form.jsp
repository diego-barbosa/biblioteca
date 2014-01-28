<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/ufc/artigoPeriodico/salvar" method="post">

	Autor:   			 <input name="artigoPeriodico.autor"/><br>
	Tema: 				 <input name="artigoPeriodico.tema"/><br>
	Titulo:     		 <input name="artigoPeriodico.titulo"/><br>
	Titulo Original:     <input name="artigoPeriodico.tituloOriginal"/><br>
	Numero do Volume:    <input name="artigoPeriodico.nroVolume"/><br>
	Local Publicacao:    <input name="artigoPeriodico.localPublicacao"/><br>
	Editora:		     <input name="artigoPeriodico.editora"/><br>
	Ano publicação:		 <input name="artigoPeriodico.anoPublicacao"/><br>
	Pagina Inicio:		 <input name="artigoPeriodico.pagIni"/><br>
	Pagina Fim:		     <input name="artigoPeriodico.pagFim"/><br>
	
	
<input type="submit"value=Inserir />

</form>
</body>
</html>