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
<form action="/ufc/monografia/salvar" id="monografiaForm" method="post">

	Autores:   <input name="monografia.autores" required/><br>
	Tema: <input name="monografia.tema" required/><br>
	Autor:    <input name="monografia.autor" required/><br>
	Nome Instiruicao:     <input name="monografia.nomeInstiruicao" required/><br>
	Numero da Monografia:     <input name="monografia.nroMonografia" required/><br>
	Local Publicacao:     <input name="monografia.localPublicacao" required/><br>
	Ano Publicacao:     <input name="monografia.anoPublicacao" required/><br>
	
	
<input type="submit"value=Inserir />

</form>
<script>
$("#monografiaForm").validate();
</script>
</body>
</html>