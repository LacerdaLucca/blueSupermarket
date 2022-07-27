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
				<h3 class="mt-4 mb-4">Relatorio Solicitado:</h3>
				<form action="/blueSupermarket/sistema/relatorio" method="get">
					<label class="mb-1" for="nome">Nome do Produto: </label>
					<div class="col-2 mb-4">
						<input class="form-control" id="nome" type="text" name="nome" placeholder="Pão de queijo"/>
					</div>
					<input class="btn btn-primary" type="submit" value="Buscar"/>
				</form>
				<br>
			</div>
		</div>
	</div>



</body>
</html>

