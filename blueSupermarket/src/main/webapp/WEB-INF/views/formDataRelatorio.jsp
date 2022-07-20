<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page isELIgnored="false"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
		  content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link rel="stylesheet" href="../../css/style.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<title>Relatório</title>
</head>
<body>
	<header>
		<jsp:include page="../../componentes/Header.jsp"/>
	</header>
	<div class="container">
		<div class="row">
			<div class="col-12">
				Periodo : <br>
				Produto ${nomeProd}
				<br>
				<form action="/blueSupermarket/sistema/relatorio" method="get">
					Data Inicial: <input type="text" name="dataIn"/>
					Data Inicial: <input type="text" name="dataFim"/>
					<input type="submit" value="buscar"/>
				</form>
			</div>
		</div>
	</div>
</body>
</html>