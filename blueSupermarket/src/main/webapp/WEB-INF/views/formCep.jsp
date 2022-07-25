<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page isELIgnored="false"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculo Frete</title>
</head>
<body>
     Voce esta logado ${usuario.nome}
	<br>

	<h2>Calcular Frete</h2>

       <form action="/blueSupermarket/sistema/frete" method="post">
            CEP: <input type="text" name="cep"  />
            <input type="submit"/>
        </form>
    	<br>

</body>
</html>