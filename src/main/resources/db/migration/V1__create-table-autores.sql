create table autores(
	id bigint not null auto_increment,
	nome varchar(100) not null,
	email varchar(100) not null,
	nascimento date not null,
	biografia varchar(200) not null,
	primary key(id)
);