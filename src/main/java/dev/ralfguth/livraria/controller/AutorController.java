package dev.ralfguth.livraria.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import dev.ralfguth.livraria.dto.AutorDetalhadoDto;
import dev.ralfguth.livraria.dto.AutorInputDto;
import dev.ralfguth.livraria.dto.AutorInputDtoAtualizacao;
import dev.ralfguth.livraria.dto.AutorOutputDto;
import dev.ralfguth.livraria.service.AutorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/autor")
@Api(tags = "Autor")
public class AutorController {

	@Autowired
	private AutorService service;

	@GetMapping
	@ApiOperation("Listar Autores")
	public Page<AutorOutputDto> listar(@PageableDefault(size = 10, sort = "nome") Pageable paginacao) {
		return service.listar(paginacao);
	}

	@PostMapping
	@ApiOperation("Cadastrar Autor")
	public ResponseEntity<AutorOutputDto> cadastrar(@RequestBody @Valid AutorInputDto dto, UriComponentsBuilder uriBuilder) {
		AutorOutputDto autorDto = service.cadastrar(dto);
		URI uri = uriBuilder.path("/autor/{id}").buildAndExpand(autorDto.getId()).toUri();
		return ResponseEntity.created(uri).body(autorDto);
	}

	@PutMapping
	@ApiOperation("Atualizar Autor")
	public ResponseEntity<AutorOutputDto> atualizar(@RequestBody @Valid AutorInputDtoAtualizacao dto) {
		AutorOutputDto atualizada = service.atualizar(dto);
		return ResponseEntity.ok(atualizada);
	}

	@DeleteMapping("/{id}")
	@ApiOperation("Excluir Autor")
	public ResponseEntity<AutorOutputDto> remover(@PathVariable Long id) {
		service.remover(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	@ApiOperation("Detalhar Autor")
	public ResponseEntity<AutorDetalhadoDto> detalhar(@PathVariable Long id) {
		AutorDetalhadoDto dto = service.detalhar(id);
		return ResponseEntity.ok(dto);
	}
}
