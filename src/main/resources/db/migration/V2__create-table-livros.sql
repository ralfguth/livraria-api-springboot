create table livros(
	id bigint not null auto_increment,
	tituto varchar(100) not null,
	numeroPaginas int not null,
	dataLancamento date not null,
	autor_id bigint not null,
	primary key(id),
	foreign key(autor_id) references autores(id)
);