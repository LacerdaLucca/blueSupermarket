<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page isELIgnored="false"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>

	<br>

	Relatorio Solicitado: <br>

	<br>
	     <form action="/blueSupermarket/relatorio" method="get">
	        Nome do Produto: <input type="text" name="nome"/>
            <input type="submit" value="buscar"/>
         </form>
    <br>


</body>
</html>

