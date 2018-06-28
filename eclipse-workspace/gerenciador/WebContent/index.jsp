<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>

<html>
	<body>
		Bem vindo ao nosso gerenciador de empresas!</br></br>
		
		<c:if test= "${usuarioLogado != null}">
			Usuario logado como ${usuarioLogado.email}</br></br>
		</c:if>
		
		<form action="fazTudo?tarefa=NovaEmpresa" method="post">
		 Nome: <input type="text" name="nome" />
		 <input type="submit" value="Enviar"/>
		</form>
		
		<form action="login" method="post">
			Email: <input type="text" name="email">
			Senha: <input type="password" name="senha">
			<input type="submit" value="Enviar">
		</form>
		
		<form action="fazTudo?tarefa=Logout" method="post">
			<input type="submit" value="logout"/>	
		</form>
	</body>
</html>