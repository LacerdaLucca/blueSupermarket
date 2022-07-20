use bluesupermarket;
CREATE TABLE usuarios (NOME varchar (500) not null, CPF varchar (11) primary key not null , SENHA varchar (20) not null, CEP varchar(8) not null, ENDEREÇO varchar(1000) not null) Engine = InnoDB;
select * FROM USUARIOS;
