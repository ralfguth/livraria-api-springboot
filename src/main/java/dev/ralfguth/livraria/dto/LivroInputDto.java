package dev.ralfguth.livraria.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroInputDto {

	@NotBlank
	@Size(min = 10)
	private String titulo;
	
	@Min(100)
	private int numeroPaginas;
	
	@PastOrPresent
	private LocalDate dataLancamento;
	
	@NotNull
	@JsonAlias("autor_id")
	private Long autorId;
	
	
}
