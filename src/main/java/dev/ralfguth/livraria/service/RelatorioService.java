package dev.ralfguth.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ralfguth.livraria.dto.LivrosPorAutorDto;
import dev.ralfguth.livraria.repository.LivroRepository;

@Service
public class RelatorioService {

	@Autowired
	private LivroRepository repository;

	public List<LivrosPorAutorDto> livrosDaLivrariaPorAutor() {
		return repository.livrosDaLivrariaPorAutor();
	}

}
