package dev.ralfguth.livraria.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroInputDto {

	@NotBlank
	private String titulo;
	@NotBlank
	private String autor;
	@NotNull
	private int numeroPaginas;
	@PastOrPresent
	private LocalDate dataLancamento;
}
