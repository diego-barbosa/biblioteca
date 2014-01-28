<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/ufc/monografia/salvar" method="post">

	Autores:   <input name="monografia.autores"/><br>
	Tema: <input name="monografia.tema"/><br>
	Autor:    <input name="monografia.autor"/><br>
	Nome Instiruicao:     <input name="monografia.nomeInstiruicao"/><br>
	Numero da Monografia:     <input name="monografia.nroMonografia"/><br>
	Local Publicacao:     <input name="monografia.localPublicacao"/><br>
	Ano Publicacao:     <input name="monografia.anoPublicacao"/><br>
	
	
<input type="submit"value=Inserir />

</form>
</body>
</html>