<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, model.Produto"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page isELIgnored="false"/>

<!DOCTYPE html>
<html>
<head>
<Style>
    #campQtn{
        width: 20px;
    }
</Style>
<meta charset="ISO-8859-1">
<title>Carrinho de Compra</title>
</head>
<body>

	<br>

	<h2>Carrinho De Compras</h2>
	<br>

	<h3> Lista de produto: </h3>
	  <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>NOME</th>
                <th>DESCRIÇÃO</th>
                <th>PREÇO</th>
                 <th>VALIDADE</th>
                 <th>QUANTIDADE</th>
                 <th>VALOR TOTAL</th>

            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${produtos}" var="produto">
                <tr>
                    <td> ${produto.idProd }</td>
                    <td> ${produto.nome}</td>
                    <td> ${produto.desc}</td>
                    <td> ${produto.preco}</td>
                    <td> ${produto.validade}</td>
                     <td><form action="/blueSupermarket/sistema/carrinho?id=${produto.idProd}" method="post">
                        <input id="campQtn" type="text" name="quant" value="${produto.quantidade}"/>
                        <input type="submit" value="confirmar"/>
                     </form></td>
                     <td> ${produto.valorTotal}</td>
                    <td><form action="/blueSupermarket/sistema/carrinho?del=${produto.idProd}" method="post">
                       	<input type="submit" value="Deletardo carrinho"/>
                    </form></td>
                </tr>
               <div hidden> ${valorTotalCarr=valorTotalCarr+produto.valorTotal} </div>
                    <br>
            </c:forEach>

        </tbody>
      </table>
                    Valor Total: ${valorTotalCarr}
      <br>

      <br>
         <a href="/blueSupermarket/"><h3>Continuar comprando </h3> </a>
      	<br>

      	 <a href="/blueSupermarket/sistema/carrinho?salvar=t"><h3>Finalizar carrinho </h3> </a>
         <br>
      <br>

</body>
</html>