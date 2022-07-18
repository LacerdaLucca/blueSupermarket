
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, model.Produto"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page isELIgnored="false"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrinho de Compra</title>
</head>
<body>

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
                <th>QUANTIDADE</th>
                 <th>VALIDADE</th>

            </tr>
        </thead>
        <tbody> 
        	<c:forEach items="${produtos}" var="produto">       	          
                <tr>
                    <td>${produto.ID }</td>
                    <td> ${produto.nome}</td>
                    <td> ${produto.desc}</td>
                    <td> ${produto.preco}</td>
                    <td> ${produto.validade}</td>
                    <td><form action="/blueSupermarket/carrinho?del=${produto.ID}" method="post">
                       	<input type="submit" value="Deletardo carrinho"/>
                    </form></td>
                </tr>
                    <br>
                   ${produto.valorTotal}
            </c:forEach>

        </tbody>    
      </table>
      <br>

      <br>
         <a href="/blueSupermarket/produtos"><h3>Continuar comprando </h3> </a>
      	<br>

      	 <a href="/blueSupermarket/carrinho?salvar=true"><h3>Finalizar carrinho </h3> </a>
         <br>
      <br>

</body>
</html>