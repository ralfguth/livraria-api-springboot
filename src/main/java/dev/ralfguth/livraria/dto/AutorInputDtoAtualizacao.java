package dev.ralfguth.livraria.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AutorInputDtoAtualizacao extends AutorInputDto {

	@NotNull
	private Long id;

}
