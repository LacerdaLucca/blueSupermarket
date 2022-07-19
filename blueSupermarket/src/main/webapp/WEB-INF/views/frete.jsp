<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, model.Frete"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page isELIgnored="false"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>

	<h2>Frete</h2>
    ${usuario.cpf}

	<br>

	Dados do Frete: <br>

	<br>
	  <table>
        <thead>
            <tr>
                <th>CEP</th>
                <th>VALOR DO FRETE</th>
                <th>PRAZO</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${frete}" var="frete">
                <tr>
                    <td>${frete.cep }</td>
                    <td>${frete.valorFrete}</td>
                    <td>${frete.prazo}</td>

                </tr>

                <form action="/blueSupermarket/sistema/finalizar" method="post">
                   	<input type="hidden" name="cep" value="${frete.cep}" />
                   	<input type="hidden" name="valor" value="${frete.valorFrete}" />
                   	<input type="hidden" name="prazo" value="${frete.prazo}" />
                   	<input type="hidden" name="usuario" value="${usuario.cpf}" />
  					<button type="submit">Finalizar Compra</button>
       			</form>
            </c:forEach>
        </tbody>
    </table>
    <br>


    </form>
</body>
</html>