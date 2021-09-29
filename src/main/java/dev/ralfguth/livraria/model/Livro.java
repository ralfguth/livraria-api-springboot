package dev.ralfguth.livraria.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

	private String titulo;
	private Autor autor;
	private int numeroPaginas;
	private LocalDate dataLancamento;
}
