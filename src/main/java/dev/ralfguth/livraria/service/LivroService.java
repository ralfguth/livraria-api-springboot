package dev.ralfguth.livraria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import dev.ralfguth.livraria.dto.LivroInputDto;
import dev.ralfguth.livraria.dto.LivroOutputDto;
import dev.ralfguth.livraria.model.Livro;

@Service
public class LivroService {

	private List<Livro> livros = new ArrayList<>();
	private ModelMapper modelMapper = new ModelMapper();
	

	public List<LivroOutputDto> listar() {
		return livros.stream().map(livro -> modelMapper.map(livro, LivroOutputDto.class)).collect(Collectors.toList());
	}

	public void cadastrar(@Valid LivroInputDto dto) {
		Livro livro = modelMapper.map(dto, Livro.class);
		livros.add(livro);
	}

}
