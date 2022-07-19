CREATE DATABASE bluesupermarket;

CREATE TABLE `bluesupermarket`.`produto` (
  `idProduto` INT NOT NULL,
  `nomeProd` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `valorCompra` DOUBLE NOT NULL,
  PRIMARY KEY (`idProduto`),
  UNIQUE INDEX `idProduto_UNIQUE` (`idProduto` ASC) VISIBLE);



  CREATE TABLE `bluesupermarket`.`carrinho` (
    `idcarrinhos` INT NOT NULL AUTO_INCREMENT,
    `idProduto` INT NOT NULL,
    `qtn` INT NOT NULL,
    `idUsuario` varchar(11) NOT NULL,
    `cep` VARCHAR(12) NOT NULL,
    `valorFrete` DOUBLE NOT NULL,
    `prazoEntrega` INT NOT NULL,
    PRIMARY KEY (`idcarrinhos`),
    UNIQUE INDEX `idcarrinhos_UNIQUE` (`idcarrinhos` ASC) VISIBLE);idUsuario

use bluesupermarket;
CREATE TABLE usuarios (
NOME varchar (500) not null,
CPF varchar (11) primary key not null,
SENHA varchar (20) not null,
CEP varchar(8) not null,
ENDEREÇO varchar(1000) not null) Engine = InnoDB;


      ALTER TABLE `bluesupermarket`.`carrinho`
      ADD INDEX `idProduto_idx` (`idProduto` ASC) VISIBLE,
      ADD INDEX `idUsuario_idx` (`idUsuario` ASC) VISIBLE;
      ;
      ALTER TABLE `bluesupermarket`.`carrinho`
      ADD CONSTRAINT `idProduto`
        FOREIGN KEY (`idProduto`)
        REFERENCES `bluesupermarket`.`produto` (`idProduto`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;
	 ALTER TABLE `bluesupermarket`.`carrinho`
      ADD CONSTRAINT `idUsuario`
        FOREIGN KEY (`idUsuario`)
        REFERENCES `bluesupermarket`.`usuarios` (`cpf`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;