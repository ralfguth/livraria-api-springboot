package dev.ralfguth.livraria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import dev.ralfguth.livraria.dto.AutorInputDto;
import dev.ralfguth.livraria.dto.AutorOutputDto;
import dev.ralfguth.livraria.model.Autor;

@Service
public class AutorService {

	private List<Autor> autores = new ArrayList<>();
	private ModelMapper modelMapper = new ModelMapper();

	public List<AutorOutputDto> listar() {
		return autores.stream().map(usuario -> modelMapper.map(usuario, AutorOutputDto.class)).collect(Collectors.toList());
	}

	public void cadastrar(@Valid AutorInputDto dto) {
		Autor autor = modelMapper.map(dto, Autor.class);
		autores.add(autor);
	}

	public Autor getAutor(String nome) {
		for (Autor autor : autores) {
			if (autor.getNome().equals(nome)) {
				return autor;
			}
		}
		return null;
	}
}
