package dev.ralfguth.livraria.dto;

import java.time.LocalDate;

import dev.ralfguth.livraria.model.Autor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroOutputDto {

	private String titulo;
	private Integer paginas;
	private LocalDate lancamento;
	private Autor autor;
}
