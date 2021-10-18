package dev.ralfguth.livraria.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroOutputDto {

	private Long id;
	private String titulo;
	private Integer paginas;
	private LocalDate lancamento;
	private AutorOutputDto autor;
}
