<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:forEach items="${periodicos}" var="livro">
		<p>ID: ${livro.id},Autor: ${livro.autor}, Nome: ${livro.titulo},
			Editora: ${livro.editora}, Titulo Original: ${livro.tituloOriginal},
			Numero Edi��o: ${livro.nroEdicao}, Local Publicacao:
			${livro.localPublicacao}, Ano Publicacao: ${livro.anoPublicacao},
			Numero de Paginas: ${livro.nroPaginas}</p>
	</c:forEach>

</body>
</html>