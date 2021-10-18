package dev.ralfguth.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.ralfguth.livraria.dto.LivrosPorAutorDto;
import dev.ralfguth.livraria.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	@Query("SELECT new dev.ralfguth.livraria.dto.LivrosPorAutorDto("
			+ "l.autor.nome, "
			+ "count(l.autor), "
			+ "count(l.autor) * 1.0 / (SELECT count(*) FROM Livro) * 1.0 )"
			+ "FROM Livro l "
			+ "GROUP BY l.autor")
	List<LivrosPorAutorDto> livrosDaLivrariaPorAutor();


}
