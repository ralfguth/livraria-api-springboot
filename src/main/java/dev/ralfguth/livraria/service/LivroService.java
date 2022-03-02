package dev.ralfguth.livraria.service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.ralfguth.livraria.dto.LivroInputDto;
import dev.ralfguth.livraria.dto.LivroInputDtoAtualizacao;
import dev.ralfguth.livraria.dto.LivroOutputDto;
import dev.ralfguth.livraria.model.Autor;
import dev.ralfguth.livraria.model.Livro;
import dev.ralfguth.livraria.repository.AutorRepository;
import dev.ralfguth.livraria.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	@Autowired
	private AutorRepository autorRepository;

	private ModelMapper modelMapper = new ModelMapper();

	public Page<LivroOutputDto> listar(Pageable paginacao) {
		Page<Livro> livros = repository.findAll(paginacao);
		return livros.map(livro -> modelMapper.map(livro, LivroOutputDto.class));
	}

	@Transactional
	public LivroOutputDto cadastrar(@Valid LivroInputDto dto) {
		try {
			Autor autor = autorRepository.getById(dto.getAutorId());
			Livro livro = modelMapper.map(dto, Livro.class);
			livro.setId(null);
			livro.setAutor(autor);
			repository.save(livro);
			return modelMapper.map(livro, LivroOutputDto.class);
		} catch (Exception e) {
			System.out.println(e.toString());
			throw new IllegalArgumentException("operacao não permitida");
		}
	}

	@Transactional
	public LivroOutputDto atualizar(LivroInputDtoAtualizacao dto) {
		Livro livroDoBanco = repository.getById(dto.getId());
		Autor autor = autorRepository.getById(dto.getAutorId());
		livroDoBanco.atualizar(dto.getTitulo(), dto.getPaginas(), dto.getLancamento(), autor);
		return modelMapper.map(livroDoBanco, LivroOutputDto.class);
	}

	@Transactional
	public void remover(Long id) {
		repository.deleteById(id);
	}

	public LivroOutputDto detalhar(Long id) {
		Livro livroDoBanco = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		return modelMapper.map(livroDoBanco, LivroOutputDto.class);
	}

}
