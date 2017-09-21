Create database senai;


create table Moto(
id serial primary key,
marca varchar not null,
modelo varchar not null,
potencia int not null,
ano int not null,
valor float not null)