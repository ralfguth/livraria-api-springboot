package dev.ralfguth.livraria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LivrosPorAutorDto {
	
	private String autor;
	private Long totalDeLivros;
	private Double percentual;
	

}
