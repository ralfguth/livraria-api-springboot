package dev.ralfguth.livraria.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroOutputDto {

	private String titulo;
	private AutorOutputDto autor;
	private int numeroPaginas;
	private LocalDate dataLancamento;
}
