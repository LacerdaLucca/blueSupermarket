<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, model.Relatorio"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page isELIgnored="false"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Relat�rio</title>
</head>
<body>
    <header>
        <jsp:include page="../../componentes/Header.jsp"/>
    </header>
    <div class="container">
        <div class="row">
            <div class="col-12 d-flex justify-content-center">
                <h2 class="mb-4 mt-4">Relatorio Solicitado: </h2>
            </div>
            <div class="col-12 d-flex justify-content-center">
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>NOME</th>
                            <th>QUANTIDADE VENDIDOS</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${vendas}" var="produto">
                            <tr>
                                <td>${produto.idProd}</td>
                                <td>${produto.nomeProd}</td>
                                <td>${produto.qntVendas}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>