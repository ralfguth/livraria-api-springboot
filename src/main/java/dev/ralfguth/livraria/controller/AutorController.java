package dev.ralfguth.livraria.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import dev.ralfguth.livraria.dto.AutorInputDto;
import dev.ralfguth.livraria.dto.AutorOutputDto;
import dev.ralfguth.livraria.service.AutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorService service;

	@GetMapping
	public Page<AutorOutputDto> listar(@PageableDefault(size = 10, sort = "nome") Pageable paginacao) {
		return service.listar(paginacao);
	}

	@PostMapping
	public ResponseEntity<AutorOutputDto> cadastrar(@RequestBody @Valid AutorInputDto dto, UriComponentsBuilder uriBuilder) {
		AutorOutputDto autorDto = service.cadastrar(dto);
		URI uri = uriBuilder.path("/autor/{id}").buildAndExpand(autorDto.getId()).toUri();
		return ResponseEntity.created(uri).body(autorDto);
	}

}
