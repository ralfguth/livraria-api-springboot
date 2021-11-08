package dev.ralfguth.livraria.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.ralfguth.livraria.dto.LivroInputDto;
import dev.ralfguth.livraria.dto.LivroOutputDto;
import dev.ralfguth.livraria.repository.AutorRepository;
import dev.ralfguth.livraria.repository.LivroRepository;

@ExtendWith(MockitoExtension.class)
class LivroServiceTest {

	@Mock
	private LivroRepository repository;
	@Mock
	private AutorRepository autorRepository;
	@InjectMocks
	private LivroService service;

	@Test
	void deveriaCadastrarUmLivro() {
		LivroInputDto inputDto = new LivroInputDto("Algoritmo e estruturas de dados com Javascript", 140, LocalDate.now(), 1l);
		LivroOutputDto outputDto = service.cadastrar(inputDto);

		assertEquals(inputDto.getTitulo(), outputDto.getTitulo());
	}

}
