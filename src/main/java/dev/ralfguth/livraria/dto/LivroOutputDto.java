package dev.ralfguth.livraria.dto;

import java.time.LocalDate;

import dev.ralfguth.livraria.model.Autor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroOutputDto {

	private String titulo;
	private Autor autor;
	private int numeroPaginas;
	private LocalDate dataLancamento;
}
