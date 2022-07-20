CREATE DATABASE bluesupermarket;

CREATE TABLE `bluesupermarket`.`produto` (
  `idProduto` INT NOT NULL,
  `nomeProd` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `valorCompra` DOUBLE NOT NULL,
  PRIMARY KEY (`idProduto`),
  UNIQUE INDEX `idProduto_UNIQUE` (`idProduto` ASC) VISIBLE);
  

  CREATE TABLE `compras` (
    `idcarrinhos` int NOT NULL AUTO_INCREMENT,
    `idProduto` int NOT NULL,
    `nomProd` varchar(25) NOT NULL,
    `qtn` int NOT NULL,
    `cpfUsuario` varchar(12) NOT NULL,
    `cep` varchar(12) NOT NULL,
    `valorFrete` double NOT NULL,
    `prazoEntrega` int NOT NULL,
    `dataCompra` varchar(11) NOT NULL,
    PRIMARY KEY (`idcarrinhos`),
    UNIQUE KEY `idcarrinhos_UNIQUE` (`idcarrinhos`),
    KEY `idUsuario_idx` (`cpfUsuario`)
  ) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


use bluesupermarket;
CREATE TABLE usuarios (
NOME varchar (500) not null,
CPF varchar (11) primary key not null,
SENHA varchar (20) not null,
CEP varchar(8) not null,
ENDEREÇO varchar(1000) not null) Engine = InnoDB;


CREATE TABLE `carrinho` (
  `idCar` int NOT NULL AUTO_INCREMENT,
  `idProd` int NOT NULL,
  PRIMARY KEY (`idCar`),
  UNIQUE KEY `idCar_UNIQUE` (`idCar`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

create table nota_fiscal (
id int not null primary key,
idCarrinho int not null,
cpf varchar(11) not null,
foreign key (idCarrinho) references compra(idcarrinhos),
foreign key (cpf) references usuarios(cpf)
);