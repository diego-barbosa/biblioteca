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
<form action="/ufc/artigoPeriodico/salvar" id="artigoPeriodicoForm" method="post">

	Autor:   			 <input name="artigoPeriodico.autor" required/><br>
	Tema: 				 <input name="artigoPeriodico.tema" required/><br>
	Titulo:     		 <input name="artigoPeriodico.titulo" required/><br>
	Titulo Original:     <input name="artigoPeriodico.tituloOriginal"/><br>
	Numero do Volume:    <input name="artigoPeriodico.nroVolume" required/><br>
	Local Publicacao:    <input name="artigoPeriodico.localPublicacao" required/><br>
	Editora:		     <input name="artigoPeriodico.editora" required/><br>
	Ano publicação:		 <input name="artigoPeriodico.anoPublicacao" required/><br>
	Pagina Inicio:		 <input name="artigoPeriodico.pagIni" required/><br>
	Pagina Fim:		     <input name="artigoPeriodico.pagFim" required/><br>
	
	
<input type="submit"value=Inserir />

</form>
<script>
$("#artigoPeriodicoForm").validate();
</script>
</body>
</html>