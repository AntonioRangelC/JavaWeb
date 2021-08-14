-- Cadastro
-- Data de criacao: 01/07/2021
-- Autor: Antonio 
-- Banco de dados: mySQL 8
-- Base de dados: cadastro
-- Projeto: exer1_Aula11
-- Sintese: => Base de dados
--          => Tabelas

CREATE DATABASE
 IF NOT EXISTS cadastro;
 
 USE cadastro;
 
 CREATE TABLE usuario (
	id 	INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(25) NOT NULL,
    sobrenome VARCHAR(25) NOT NULL,
 CONSTRAINT USUARIO_PK PRIMARY KEY (id)
 ) ENGINE InnoDB AUTO_INCREMENT = 1;
 