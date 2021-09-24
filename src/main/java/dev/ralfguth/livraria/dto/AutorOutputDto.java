package dev.ralfguth.livraria.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorOutputDto {
	
	private String nome;
	private LocalDate nascimento;
	private String biografia;

}
