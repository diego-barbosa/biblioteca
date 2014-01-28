<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/ufc/anais/salvar" method="post">

	Titulo:   				<input name="anais.titulo"/><br>
	Tema: 					<input name="anais.tema"/><br>
	Local Publicação:     	<input name="anais.tituloOriginal"/><br>
	Editora:     			<input name="anais.editora"/><br>
	Ano Publicacao:	 	    <input name="anais.anoPublicacao"/><br>
	FL Terminou:    		<input name="anais.flTerminou"/><br>
	Codigo Coletanea:     	<input name="anais.codColetanea"/><br>
<input type="submit"value=Inserir />

</form>
</body>
</html>