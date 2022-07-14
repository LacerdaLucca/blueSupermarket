<%@ page contentType="text/html;charset=ISO-8859-1" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Cadastro de Usuário</title>
</head>
<body>
    <div>Bem-Vindo ao Blue Supermarket!!</div>
    <div>Preencha os campos abaixo para fazer o seu cadastro!</div>
    <br>

    <form action="http://localhost:8080/blueSupermarket/usuario" method="post">
        Nome
        <input name="nome" id="nome" type="text" required="true">
        Cpf
        <input name="cpf" id="cpf" type="text" required="true">
        Senha
        <input name="senha" id="senha" type="password" required="true">
        Cep
        <input name="cep" id="cep" type="text" required="true">
        Endereço
        <input name="endereco" id="endereco" type="text" required="true">

        <button type="submit" id="btn">Enviar</button>
    </form>
    
</body>
</html>