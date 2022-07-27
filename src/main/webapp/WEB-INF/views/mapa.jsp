<%@ page contentType="text/html;charset=ISO-8859-1" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Localização</title>
</head>
    <body>
        <header>
            <jsp:include page="../../componentes/Header.jsp"/>
        </header>
        <div class="container">
            <div class="row">
                <div class="col-12 d-flex mt-5">
                    <div>
                        <iframe width="400" height="350" style="border-radius: 10px;" loading="lazy" allowfullscreen src="https://www.google.com/maps/embed/v1/place?q=place_id:ChIJ2TGowquXpgAR5THaE26cxQM&key=AIzaSyCVcLxlyq7F2INrxIGzgWwF2OxC1v0V4IA"></iframe>
                    </div>
                    <div class="ms-5">
                        <h2 class="m-1">Endereço:</h2>
                        <br>
                        Rua Gávea, 438
                        <br>
                        Jardim América
                        <br>
                        Belo Horizonte - MG
                        <br>
                        CEP: 30421-340
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>