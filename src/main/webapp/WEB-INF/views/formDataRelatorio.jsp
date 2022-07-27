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
		<div class="row d-flex justify-content-center">
			<div class="col-4">
				<h4>Produto ${nomeProd}</h4>
				<h5 class="mt-5">Periodo:</h5>
				<form action="/blueSupermarket/sistema/relatorio" method="get">
					<label for="dataIn">Data Inicial:</label>
					<input class="form-control" type="text" name="dataIn" id="dataIn"/>
					<label class="mt-2" for="dataFim">Data Final:</label>
					<input class="form-control" type="text" name="dataFim" id="dataFim"/>
					<input class="mt-4 btn btn-primary" type="submit" value="Buscar"/>
				</form>
			</div>
		</div>
	</div>
</body>
</html>