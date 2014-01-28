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

	<c:forEach items="${anais}" var="anais">
		<p>ID: ${anais.id},Autor: ${anais.autor}, Nome: ${anais.titulo},
			Editora: ${anais.editora}, Titulo Original: ${anais.tituloOriginal},
			Numero Edição: ${anais.nroEdicao}, Local Publicacao:
			${anais.localPublicacao}, Ano Publicacao: ${anais.anoPublicacao},
			Numero de Paginas: ${anais.nroPaginas}</p>
	</c:forEach>

</body>
</html>