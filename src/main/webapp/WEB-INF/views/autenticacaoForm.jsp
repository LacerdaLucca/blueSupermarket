<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="../../css/style.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <title>Login</title>
    </head>
    
    <body>
        <header>
            <jsp:include page="../../componentes/Header.jsp"/>
        </header>
        <div class="container">
            <div class="row d-flex justify-content-center mt-5">
                <div class="col-5 bg-light border border-secondary rounded p-5">
                    <div class="row d-flex justify-content-center">
                        <div class="col-11">
                            <div class="mb-3"><h2>Login</h2></div>
                        </div>
                    </div>
                    <div class="row d-flex justify-content-center">
                        <div class="col-11 mt-1">
                            <div class="mt-3 mb-4">Preencha os campos abaixo para fazer login!</div>
                            <form action="http://localhost:8080/blueSupermarket/login" method="post">
                                <label class="mt-2 form-label" for="cpf">CPF</label>
                                <input class="form-control" maxlength="11" type="text" id="cpf" name="cpf" />
                                <label class="form-label mt-4" for="senha">Senha</label>
                                <input class="form-control" type="password" id="senha" name="senha" />

                                <div class="row mb-2 d-flex justify-content-center mt-3">
                                    <div class="col-6 d-flex justify-content-center"><input class="btn btn-primary" type="submit"></div>
                                    <div class="col-6 d-flex justify-content-center"><a class="btn btn-primary" href="http://localhost:8080/blueSupermarket/usuarioForm">Registrar</a></div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </body>
</html>
