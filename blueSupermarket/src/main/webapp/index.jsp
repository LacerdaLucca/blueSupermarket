<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.Produto, DAO.ProdutosDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page isELIgnored="false"/>
<!doctype html>
<html lang="pt">
<head>
    <style>
       #container{
            display: grid;
            grid-template-columns: 1fr 5fr 1fr;

        }
        .posicaoTitulo{    
            text-align: center;
            padding-bottom: 5px;
            background-color: blue;
            color: white;   
        }

        #sub-container{overflow: hidden;}
        .carrocel{
            width: 800px;
            height: 460px;      
        }
        .nav{
            justify-content: center;   
            justify-items: center;
            align-items: center;
            text-align: center;
        }
        .nav ul li a{
            text-decoration: underline;
        }

        .carrocel li img{
            display:flex;   
            width: 820px;
            height:480px;      
            margin: 5px 20px;
        }

        .carrocel ul{   
            display: flex;    
            list-style: none;    
            width: 1100px;
            height: 460px;  

        }
        .carrocel li{    
            position: relative;
            margin-right: 15px;
            animation: slide 25s infinite ease-out;
        }
        @keyframes slide{
            0%{left:0px}
            19%{left: 0px}
            27%{left:-860px}
            47%{left: -860px;}
            57%{left: -1700px;}
            77%{left: -1700px;}
            87%{left:-2530px;}
            100%{left:-2530px}
        }
    </style>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="./css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <title>blueSupermarket</title>
</head>
<body>
<header>
    <jsp:include page="componentes/Header.jsp"/>
</header>
<section id="container">
    <div>

    </div>
    <div id="sub-container">
        <div class="carrocel">
            <ul class="limitacao">
                <li><img src="imagens/market.png"></li>
                <li><img src="imagens/corredor.png"></li>
                <li><img src="imagens/nao-pereciveis.jpg"></li>
                <li><img src="imagens/pereciveis.png"></li>
                <li><img src="imagens/nao-pereciveis.jpg"></li>
            </ul>
        </div>
        <div>
            <br>
            <h2 class="mt-5">Lista de produtos: </h2>
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
                    <c:set var="listaProdutos" value="${ProdutosDao().getProdutos()}" />
                    <c:forEach items="${listaProdutos}" var="produto">
                        <tr>
                            <td class="table-row">${produto.ID}</td>
                            <td class="table-row">${produto.nome}</td>
                            <td class="table-row">${produto.desc}</td>
                            <td class="table-row">${produto.preco}</td>
                            <td class="table-row">${produto.validade}</td>
                            <td class="table-row"><form action="/blueSupermarket/sistema/carrinho?add=${produto.ID}" method="post">
                                <input class="btn btn-success" type="submit" value="Adicionar ao carrinho"/>
                            </form></td>
                        </tr>
                   </c:forEach>
                </tbody>
            </table>
            <div class="m-4"></div>
            <div class="row">
                <div class="col-12 d-flex justify-content-center">
                    <form action="/blueSupermarket/sistema/carrinho" class="mx-auto" method="get">
                        <input class="btn btn-primary" type="submit" value="Ir para o Carrinho"/>
                    </form>
                </div>
            </div>
            <div class="m-5"></div>
        </div>
    </div>
</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>