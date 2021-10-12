package dev.ralfguth.livraria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ralfguth.livraria.dto.LivroInputDto;
import dev.ralfguth.livraria.dto.LivroOutputDto;
import dev.ralfguth.livraria.service.LivroService;

@RestController
@RequestMapping("/livro")
public class LivroController {

	@Autowired
	private LivroService service;

	@GetMapping
	public Page<LivroOutputDto> listar(Pageable paginacao) {
		return service.listar(paginacao);
	}

	@PostMapping
	public void cadastrar(@RequestBody @Valid LivroInputDto dto) {
		service.cadastrar(dto);
	}

}
