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

import dev.ralfguth.livraria.dto.AutorInputDto;
import dev.ralfguth.livraria.dto.AutorOutputDto;
import dev.ralfguth.livraria.service.AutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorService service;

	@GetMapping
	public Page<AutorOutputDto> listar(Pageable paginacao) {
		return service.listar(paginacao);
	}

	@PostMapping
	public void cadastrar(@RequestBody @Valid AutorInputDto dto) {
		service.cadastrar(dto);
	}

}
