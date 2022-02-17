package dev.ralfguth.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ralfguth.livraria.dto.LivrosPorAutorDto;
import dev.ralfguth.livraria.service.RelatorioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/relatorio")
@Api(tags = "Relatório")
public class RelatorioController {
	
	@Autowired
	private RelatorioService service;

	@GetMapping("/livros")
	@ApiOperation("Obter Relatório de Livros Por Autor")
	public List<LivrosPorAutorDto> livrosDaLivrariaPorAutor(){
		return service.livrosDaLivrariaPorAutor();
	}

}
