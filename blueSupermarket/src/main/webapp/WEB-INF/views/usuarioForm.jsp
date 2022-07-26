<%@ page contentType="text/html;charset=ISO-8859-1" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Cadastro de Usuário</title>
</head>
<body>
    <header>
        <jsp:include page="../../componentes/Header.jsp"/>
    </header>
    <div class="container mt-5">
        <div class="row d-flex justify-content-center">
            <div class="col-6 bg-light border border-secondary rounded p-5">
                <div class="row">
                    <div class="col-12">
                        <div class="mb-4"><h2>Cadastro de usuário</h2></div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <div class="mt-3 mb-4">Preencha os campos abaixo para fazer o seu cadastro!</div>
                        <form action="http://localhost:8080/blueSupermarket/usuario" method="post">
                            <div class="row mb-3">
                                <div class="col-5">
                                    <label for="nome">Nome</label>
                                    <input class="form-control" name="nome" id="nome" type="text" required="required" placeholder="João da Silva">
                                </div>
                                <div class="col-3">
                                    <label for="cpf">CPF</label>
                                    <input class="form-control" name="cpf" id="cpf" type="text" required="required" placeholder="00000000000">
                                </div>
                                <div class="col-4">
                                    <label for="senha">Senha</label>
                                    <input class="form-control" name="senha" id="senha" type="password" required="required" placeholder="********">
                                </div>
                            </div>
                            <div class="row mb-4">
                                <div class="col-4">
                                    <label for="cep">CEP</label>
                                    <input class="form-control" name="cep" id="cep" type="text" required="required" placeholder="00000000">
                                </div>
                                <div class="col-8">
                                    <label for="endereco">Endereço</label>
                                    <input class="form-control" name="endereco" id="endereco" type="text" required="required" placeholder="Rua dos Cravos, 000">
                                </div>
                            </div>
                            <button class="btn btn-primary" type="submit" id="btn">Enviar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
