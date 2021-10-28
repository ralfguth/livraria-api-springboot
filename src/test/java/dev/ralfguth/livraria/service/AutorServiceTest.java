package dev.ralfguth.livraria.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.ralfguth.livraria.dto.AutorInputDto;
import dev.ralfguth.livraria.dto.AutorOutputDto;
import dev.ralfguth.livraria.repository.AutorRepository;

@ExtendWith(MockitoExtension.class)
class AutorServiceTest {
	
	@Mock
	private AutorRepository repository;
	
	@InjectMocks
	private AutorService service;
	

	@Test
	void deveriaCadastrarUmAutor() throws Exception {
		AutorInputDto inputDto = new AutorInputDto("Machado de Assis", "machado@email.com", LocalDate.of(1839, 06, 21), "Considerado um dos maiores nomes da literatura do Brasil");
		AutorOutputDto outputDto = service.cadastrar(inputDto);
	
		assertEquals(inputDto.getNome(), outputDto.getNome());
	}
	
	

}
