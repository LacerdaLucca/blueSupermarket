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

	Relatorio Solicitado: <br>

	<br>
	  <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>NOME</th>
             </tr>
        </thead>
        <tbody>
        	<c:forEach items="${listaProd}" var="produto">
                <tr>
                     <td>${produto.ID }</td>
                     <td><a href="/blueSupermarket/sistema/relatorio?nomeProd=${produto.nome}">${produto.nome}</a></td>
                </tr>
           </c:forEach>
        </tbody>
    </table>
</body>
</html>