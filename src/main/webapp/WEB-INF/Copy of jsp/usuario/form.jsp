<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="http://jquery.bassistance.de/validate/jquery.validate.js"></script>
</head>
<body>
<form action="/ufc/usuarios/salvar" id="usuarioForm" method="post">

	Usuario:   <input name="usuario.nome" id="nome" required /> <label for="nome">*</label><br>
	
	Telefone:  <input name="usuario.telefone" id="telefone" required/> <label for="telefone">*</label><br>
	
	Cpf:  <input name="usuario.cpf" id="cpf" required/> <label for="cpf" >*</label><br>
	
	
<input type="submit"value=Inserir />

</form>
<script>
$("#usuarioForm").validate();
</script>
</body>
</html>

