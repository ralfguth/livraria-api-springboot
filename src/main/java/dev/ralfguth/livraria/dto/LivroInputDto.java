package dev.ralfguth.livraria.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import dev.ralfguth.livraria.model.Autor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroInputDto {

	@NotBlank
	private String titulo;
	@NotBlank
	private Autor autor;
	@NotBlank
	private int numeroPaginas;
	@PastOrPresent
	@NotBlank
	private LocalDate dataLancamento;
}
