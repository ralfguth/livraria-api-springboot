package dev.ralfguth.livraria.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutorInputDto {

	@NotBlank
	private String nome;
	
	@NotBlank
	private String email;
		
	@NotNull
	@PastOrPresent
	private LocalDate nascimento;
	
	@NotBlank
	private String biografia;
	
}
