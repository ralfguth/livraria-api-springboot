package dev.ralfguth.livraria.controller;

import java.net.URI;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import dev.ralfguth.livraria.dto.LivroInputDto;
import dev.ralfguth.livraria.dto.LivroInputDtoAtualizacao;
import dev.ralfguth.livraria.dto.LivroOutputDto;
import dev.ralfguth.livraria.service.LivroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/livro")
@Api(tags = "Livro")
public class LivroController {

	@Autowired
	private LivroService service;

	@GetMapping
	@ApiOperation("Listar Livros")
	public Page<LivroOutputDto> listar(@PageableDefault(size = 10, sort = "lancamento", direction = Direction.DESC) Pageable paginacao) {
		return service.listar(paginacao);
	}

	@PostMapping
	@ApiOperation("Cadastrar Livro")
	public ResponseEntity<LivroOutputDto> cadastrar(@RequestBody @Valid LivroInputDto dto, UriComponentsBuilder uriBuilder) {
		LivroOutputDto livroDto = service.cadastrar(dto);
		URI uri = uriBuilder.path("/livro/{id}").buildAndExpand(livroDto.getId()).toUri();
		return ResponseEntity.created(uri).body(livroDto);
	}

	@PutMapping
	@ApiOperation("Atualizar Livro")
	public ResponseEntity<LivroOutputDto> atualizar(@RequestBody @Valid LivroInputDtoAtualizacao dto) {
		LivroOutputDto atualizada = service.atualizar(dto);
		return ResponseEntity.ok(atualizada);
	}

	@DeleteMapping("/{id}")
	@ApiOperation("Excluir Livro")
	public ResponseEntity<LivroOutputDto> remover(@PathVariable @NotNull Long id) {
		service.remover(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	@ApiOperation("Detalhar Livro")
	public ResponseEntity<LivroOutputDto> detalhar(@PathVariable @NotNull Long id) {
		LivroOutputDto dto = service.detalhar(id);
		return ResponseEntity.ok(dto);
	}

}
