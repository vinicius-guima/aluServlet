<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>busca empresa</title>
</head>
<body>
	Resultado da busca :
	<ul>
		<c:forEach var="empresa" items= "${empresas}">
			<li>${empresa.id}: ${empresa.nome}</li>
		</c:forEach>
	</ul>
</body>
</html>