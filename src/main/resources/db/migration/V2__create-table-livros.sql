create table livros(
	id bigint not null auto_increment,
	titulo varchar(100) not null,
	paginas int not null,
	lancamento date not null,
	primary key(id)
);