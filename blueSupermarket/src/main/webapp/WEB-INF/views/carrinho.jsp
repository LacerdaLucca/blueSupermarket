
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, model.Produtos"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrinho de Compra</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
	
	<br>
	
	<h2>Carrinho De Compras</h2>
	
	
	<br>
			
	Lista de produto: <br>
	
	<br>
	  <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>NOME</th>
                <th>DESCRIÇÃO</th>
                <th>PREÇO</th>            
            </tr>
        </thead>
        <tbody> 
        	<c:forEach items="${produtos}" var="produto">       	          
                <tr>
                    <td>${produto.idProd}</td>
                    <td>${produto.nomeProd}</td>    
                    <td>${produto.descricao}</td>
                    <td>${produto.valor}</td>                
                                
                </tr>               
            </c:forEach>    
        </tbody>    
    </table>
    <br>
	 
    <form action="/gbreletro/do?direct=CalculoFrete" method="post">	
		CEP: <input type="text" name="cep"  />
		Tipo(JSON ou JSP):  <input type="text" name="tipo"  />					
		<input type="submit"/>
	</form>
	
	
</body>
</html>