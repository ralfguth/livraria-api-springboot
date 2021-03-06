package dev.ralfguth.livraria.service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.ralfguth.livraria.dto.AutorDetalhadoDto;
import dev.ralfguth.livraria.dto.AutorInputDto;
import dev.ralfguth.livraria.dto.AutorInputDtoAtualizacao;
import dev.ralfguth.livraria.dto.AutorOutputDto;
import dev.ralfguth.livraria.model.Autor;
import dev.ralfguth.livraria.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository repository;

	private ModelMapper modelMapper = new ModelMapper();

	public Page<AutorOutputDto> listar(Pageable paginacao) {
		Page<Autor> autores = repository.findAll(paginacao);
		return autores.map(autor -> modelMapper.map(autor, AutorOutputDto.class));
	}

	@Transactional
	public AutorOutputDto cadastrar(@Valid AutorInputDto dto) {
		Autor autor = modelMapper.map(dto, Autor.class);
		repository.save(autor);
		return modelMapper.map(autor, AutorOutputDto.class);
	}

	@Transactional
	public AutorOutputDto atualizar(@Valid AutorInputDtoAtualizacao dto) {
		Autor autor = repository.getById(dto.getId());
		autor.atualizar(dto.getNome(), dto.getEmail(), dto.getNascimento(), dto.getBiografia());
		return modelMapper.map(autor, AutorOutputDto.class);
	}

	@Transactional
	public void remover(Long id) {
		repository.deleteById(id);
	}

	public AutorDetalhadoDto detalhar(Long id) {
		Autor autor = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		return modelMapper.map(autor, AutorDetalhadoDto.class);
	}

}
