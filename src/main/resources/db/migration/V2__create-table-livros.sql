create table livros(
	id bigint not null auto_increment,
	titulo varchar(100) not null,
	paginas int not null,
	lancamento date not null,
	autor_id bigint not null,
	primary key(id),
	foreign key(autor_id) references autores(id)
);