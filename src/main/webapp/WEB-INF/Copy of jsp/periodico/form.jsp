<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/ufc/periodico/salvar" method="post">

	Titulo:   				<input name="periodico.titulo"/><br>
	Tema: 					<input name="periodico.tema"/><br>
	Local Publicação:     	<input name="periodico.tituloOriginal"/><br>
	Editora:     			<input name="periodico.editora"/><br>
	Ano Publicacao:	 	    <input name="periodico.anoPublicacao"/><br>
	FL Terminou:    		<input name="periodico.flTerminou"/><br>
	Codigo Coletanea:     	<input name="periodico.codColetanea"/><br>


<input type="submit"value=Inserir />

</form>
</body>
</html>