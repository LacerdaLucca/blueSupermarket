<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, model.Frete"%>
<%@ page import="model.Usuario" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page isELIgnored="false"/>

<!DOCTYPE html>
<html>
<head>
<style>
    #botomFinal{
        display: block;
    }
</style>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Frete</title>
</head>
<body>
    Voce esta logado ${usuario.nome}
    <header>
        <jsp:include page="../../componentes/Header.jsp"/>
    </header>
    <div class="container">
        <div class="row">
            <div class="col-12 d-flex justify-content-center">
                <h2 class="mb-4 mt-4">Dados do Frete:</h2>
            </div>
            <div class="col-12 d-flex justify-content-center">
                <table>
                    <thead>
                        <tr>
                            <th class="pe-3">CEP</th>
                            <th class="pe-3">VALOR DO FRETE</th>
                            <th class="pe-3">PRAZO</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${frete}" var="frete">
                        <tr>
                            <td class="pe-3">${frete.cep}</td>
                            <td class="pe-3">${frete.valorFrete}</td>
                            <td class="pe-3">${frete.prazo}</td>
                        </tr>
                        <div class="row mt-4">
                                        <div class="col-12 d-flex justify-content-center">
                                            <form action="/blueSupermarket/sistema/finalizar" method="post" target="_blank">
                                                <input type="hidden" name="cep" value="${frete.cep}" />
                                                <input type="hidden" name="valor" value="${frete.valorFrete}" />
                                                <input type="hidden" name="prazo" value="${frete.prazo}" />
                                                <input type="hidden" name="usuario" value="${usuario.cpf}" />
                                                <button id="botomFinal" class="btn btn-primary" type="submit">Finalizar Compra</button>
                                            </form>
                                        </div>
                                    </div>
                       </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</body>
</html>