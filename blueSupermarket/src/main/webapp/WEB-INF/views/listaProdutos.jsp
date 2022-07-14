<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, model.Produto"%>
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

	Lista de produtos: <br>

	<br>
	  <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>NOME</th>
                <th>DESCRIÇÃO</th>
                <th>PREÇO</th>
                <th>QUANTIDADE</th>
                <th>VALIDADE</th>

            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${listaProdutos}" var="produto">
                <tr>
                    <td>${produto.ID }</td>
                    <td>${produto.nome}</td>
                    <td>${produto.desc}</td>
                    <td>${produto.preco}</td>
                    <td>${produto.quantidade}</td>
                    <td>${produto.validade}</td>
                    <td><form action="/blueSupermarket/carrinho?id=${produto.ID}" method="post">
                    	<input type="submit"/>
                    </form></td>
                </tr>

           </c:forEach>
        </tbody>
    </table>
	<a href="/carrinho">Ir para o Carrinho</a>
</body>
</html>