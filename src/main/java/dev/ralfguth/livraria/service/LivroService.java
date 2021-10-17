package dev.ralfguth.livraria.service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import dev.ralfguth.livraria.dto.LivroInputDto;
import dev.ralfguth.livraria.dto.LivroOutputDto;
import dev.ralfguth.livraria.model.Livro;
import dev.ralfguth.livraria.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	private ModelMapper modelMapper = new ModelMapper();

	public Page<LivroOutputDto> listar(@PageableDefault(size = 10) Pageable paginacao) {
		Page<Livro> livros = repository.findAll(paginacao);
		return livros.map(livro -> modelMapper.map(livro, LivroOutputDto.class));
	}

	@Transactional
	public void cadastrar(@Valid LivroInputDto dto) {
		Livro livro = modelMapper.map(dto, Livro.class);
		livro.setId(null);
		repository.save(livro);
	}

}
