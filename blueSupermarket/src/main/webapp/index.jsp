<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, model.Produto"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page isELIgnored="false"/>
<!doctype html>
<html lang="en">
<head>
    <style>
            #container{
            display: grid;
            grid-template-columns: 1fr 3fr 1fr;
            height: 150px;
        }
    </style>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>blueSupermarket</title>
</head>
<body>
<header>
    <div>
        <h2> Sua melhor e mais Completa loja do país </h2>

    </div>
    <div>
        <ul class="nav nav-tabs">
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Active</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/blueSupermarket/usuarioForm">Cadastro de Usuário</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/blueSupermarket/carrinho">Carrinho</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
            </li>
        </ul>
    </div>

</header>
<section id="container">
    <div>

    </div>
    <div>
        <div class="carrocel">
            <ul>
                <li><img src="imagens/nao-pereciveis.jpg"></li>
                <li><img src="imagens/pereciveis.png"></li>
                <li><img src="imagens/nao-pereciveis.jpg"></li>
            </ul>
        </div>
        <div>
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
                                <td>${produto.validade}</td>
                                <td><form action="/blueSupermarket/carrinho?add=${produto.ID}" method="post">
                                	<input type="submit" value="Enviar para o carrinho"/>
                                </form></td>
                            </tr>

                       </c:forEach>
                    </tbody>
                </table>
                <form action="/blueSupermarket/carrinho" method="get">
                    <input type="submit" value="Ir para o Carrinho"/>
                </form>
        </div>

    </div>
    <div>

    </div>
</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>