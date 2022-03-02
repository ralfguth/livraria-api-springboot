package dev.ralfguth.livraria.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorDetalhadoDto extends AutorOutputDto {
	
	private LocalDate nascimento;
	
	private String biografia;
	
}
