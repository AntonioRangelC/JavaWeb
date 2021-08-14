-- Instituicao--
-- Projeto: Projeto pratico JavaWeb
-- Data de criacao: 01/07/2021
-- Data da ultima alteracao: 04/07/2021
--    => Retirando o atributo idEmail da tabela emails
-- Autor: Antonio Rangel Chaves
-- Banco de dados: mySQL 8
-- Base de dados: instituicao
-- Sintese:
--        => Base de dados 
--        => Tabelas 

CREATE DATABASE
 IF NOT EXISTS PROJETOPRATICO;
 
 USE PROJETOPRATICO;
 
 CREATE TABLE PESSOA (
	idPessoa INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    altura DECIMAL(3,2) NOT NULL,
    genero ENUM('F', 'M') NOT NULL,
    dataNascimento DATE NOT NULL,
 CONSTRAINT USUARIO_PK PRIMARY KEY (idPessoa)
 ) ENGINE InnoDB AUTO_INCREMENT = 1;
 
 CREATE TABLE EMAILS(
    idPessoa INT NOT NULL,
	emailPrim VARCHAR(40) NOT NULL ,
    emailSec VARCHAR(40),
  CONSTRAINT IDPESSOA_FK FOREIGN KEY (idPessoa)
	REFERENCES PESSOA (idPessoa)
 ) ENGINE InnoDB AUTO_INCREMENT = 1;
 
