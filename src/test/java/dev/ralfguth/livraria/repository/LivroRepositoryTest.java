package dev.ralfguth.livraria.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dev.ralfguth.livraria.dto.LivrosPorAutorDto;
import dev.ralfguth.livraria.model.Autor;
import dev.ralfguth.livraria.model.Livro;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
class LivroRepositoryTest {

	@Autowired
	private LivroRepository repository;

	@Autowired
	private TestEntityManager manager;

	@Test
	void nãoDeveRetornarNadaComBancoVazio() throws Exception {
		List<LivrosPorAutorDto> relatorio = repository.livrosDaLivrariaPorAutor();
		assertTrue(relatorio.isEmpty());
	}

	@Test
	void deveriaRetornarNumeroDeAutoresPorLivro() throws Exception {
		Autor machado = new Autor("Machado de Assis", "machado@email.com", LocalDate.of(1839, 06, 21), "Considerado um dos maiores nomes da literatura do Brasil");
		manager.persist(machado);
		Autor clarisse = new Autor("Clarisse Lispector", "clarisse@email.com", LocalDate.of(1920, 12, 10), "Autora de romances, contos, e ensaios, é considerada uma das escritoras brasileiras mais importantes do século XX e a maior escritora judia desde Franz Kafka");
		manager.persist(clarisse);
		Livro domCasmurro = new Livro("Dom Casmurro", 208, LocalDate.of(2019, 05, 02), machado);
		manager.persist(domCasmurro);
		Livro brasCubas = new Livro("Memórias Póstumas de Brás Cubas", 192, LocalDate.of(2019, 05, 02), machado);
		manager.persist(brasCubas);
		Livro quincasBorba = new Livro("Quincas Borba", 240, LocalDate.of(2019, 10, 21), machado);
		manager.persist(quincasBorba);
		Livro horaEstrela = new Livro("A Hora da Estrela", 224, LocalDate.of(2017, 05, 02), clarisse);
		manager.persist(horaEstrela);
		List<LivrosPorAutorDto> relatorio = repository.livrosDaLivrariaPorAutor();
		assertEquals(2, relatorio.size());
		Assertions.assertThat(relatorio)
		.hasSize(2)
		.extracting(LivrosPorAutorDto::getAutor, LivrosPorAutorDto::getTotalDeLivros, LivrosPorAutorDto::getPercentual)
		.contains(Assertions.tuple("Machado de Assis", 3l, 0.75), Assertions.tuple("Clarisse Lispector", 1l, 0.25));
	}

}
