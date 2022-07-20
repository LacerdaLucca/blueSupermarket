
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, model.Produto"%>
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
    <link rel="stylesheet" href="../../css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <title>Carrinho de Compra</title>
</head>
<body>
    <header>
        <jsp:include page="../../componentes/Header.jsp"/>
    </header>
    <div class="container">
        <div class="row">
            <div class="col-12 d-flex justify-content-center mb-4">
                <h2 class="mt-2">Carrinho De Compras</h2>
            </div>
        </div>
        <div class="row">
            <div class="wrapper col-12 d-flex justify-content-center mb-3">
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>NOME</th>
                            <th>DESCRICAO</th>
                            <th>PRECO</th>
                            <th>QUANTIDADE</th>
                            <th>VALIDADE</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${produtos}" var="produto">
                            <tr>
                                <td class="table-row">${produto.idProd}</td>
                                <td class="table-row"> ${produto.nome}</td>
                                <td class="table-row"> ${produto.desc}</td>
                                <td class="table-row"> ${produto.preco}</td>
                                <td class="table-row"> ${produto.validade}</td>
                                <td class="table-row">
                                    <form action="/blueSupermarket/sistema/carrinho?del=${produto.idProd}" method="post">
                                        <input class="btn btn-success" type="submit" value="Deletar do carrinho"/>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="row">
            <div class="col-12 d-flex justify-content-center">
                <a class="btn btn-secondary m-3" href="/blueSupermarket/">Continuar comprando</a>
                <a class="btn btn-secondary m-3" href="/blueSupermarket/sistema/carrinho?salvar=t">Finalizar carrinho</a>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>