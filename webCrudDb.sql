create database usuarioNota;
use usuarioNota;

create table Usuarios(
id int primary key auto_increment,
nome varchar(80),
email varchar(80) unique,
senha varchar(80)
);

create table Notas(
id int primary key auto_increment,
titulo varchar(80),
conteudo text,
usuarioId int,
dataCriacao varchar(30),
foreign key(usuarioId) references Usuarios(id)
);


