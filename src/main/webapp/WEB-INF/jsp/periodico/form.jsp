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
<form action="/ufc/periodico/salvar" id="periodicoForm" method="post">

	Titulo:   				<input name="periodico.titulo" required/><br>
	Tema: 					<input name="periodico.tema" required/><br>
	Local Publicação:     	<input name="periodico.localPublicacao"/><br>
	Editora:     			<input name="periodico.editora" required/><br>
	Ano Publicacao:	 	    <input name="periodico.anoPublicacao" required/><br>
	FL Terminou:    		<input name="periodico.flTerminou" required/><br>
	Codigo Coletanea:     	<input name="periodico.codColetanea" required/><br>


<input type="submit"value=Inserir />

</form>
<script>
$("#periodicoForm").validate();
</script>
</body>
</html>