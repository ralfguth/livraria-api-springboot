package dev.ralfguth.livraria.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import dev.ralfguth.livraria.dto.LivroInputDto;
import dev.ralfguth.livraria.dto.LivroOutputDto;
import dev.ralfguth.livraria.service.LivroService;

@RestController
@RequestMapping("/livro")
public class LivroController {

	@Autowired
	private LivroService service;

	@GetMapping
	public Page<LivroOutputDto> listar(@PageableDefault(size = 10, sort = "lancamento", direction = Direction.DESC) Pageable paginacao) {
		return service.listar(paginacao);
	}

	@PostMapping
	public ResponseEntity<LivroOutputDto> cadastrar(@RequestBody @Valid LivroInputDto dto, UriComponentsBuilder uriBuilder) {
		LivroOutputDto livroDto = service.cadastrar(dto);
		URI uri = uriBuilder.path("/livro/{id}").buildAndExpand(livroDto.getId()).toUri();
		return ResponseEntity.created(uri).body(livroDto);
	}

}
