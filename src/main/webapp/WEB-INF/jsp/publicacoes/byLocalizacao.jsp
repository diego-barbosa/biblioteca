<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:forEach items="${usuario}" var="usuari">
  <p> 	ID: ${usuari.id}; 
   	Autor: ${usuari.autor}; 
   	Tema: ${usuari.tema}; 
   	Titulo: ${usuari.titulo}; 
   	Titulo Original: ${usuari.tituloOriginal}; 
   	Numero Edicao: ${usuari.nroEdicao}; 
   	Local Publicacao: ${usuari.localPublicacao}; 
   	Editora: ${usuari.editora}; 
   	Ano Publicacao: ${usuari.anoPublicacao}; 
   	Numero Paginas: ${usuari.nroPaginas}; 
   	Codigo Coletanea: ${usuari.codColetanea}; 
   	Nome Instituição: ${usuari.nomeInstituicao}; 
   	Numero Monografia: ${usuari.nroMonografia}; 
   	Editores Livro: ${usuari.editoresLivro}; 
   	Pagina Inicio: ${usuari.pagIni}; 
  	Pagina Inicio: ${usuari.pagFim}; </p>
  	
</c:forEach>

</body>
</html>