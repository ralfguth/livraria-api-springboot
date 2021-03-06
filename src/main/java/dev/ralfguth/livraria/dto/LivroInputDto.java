package dev.ralfguth.livraria.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivroInputDto {

	@NotBlank
	@Size(min = 10)
	private String titulo;
	
	@Min(100)
	private Integer paginas;
	
	@PastOrPresent
	private LocalDate lancamento;
	
	@NotNull
	@JsonAlias("autor_id")
	private Long autorId;
	
	
}
