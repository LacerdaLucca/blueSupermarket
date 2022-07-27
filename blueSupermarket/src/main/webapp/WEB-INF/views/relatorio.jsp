<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, model.Relatorio"%>
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
                    <td>${produto.idProd }</td>
                    <td>${produto.nomeProd}</td>
                    <td>${produto.qntVendas}</td>
                </tr>

           </c:forEach>
        </tbody>
	<tbody>

    </table>

</body>
</html>
