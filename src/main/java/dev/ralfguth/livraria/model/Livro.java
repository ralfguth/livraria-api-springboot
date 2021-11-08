package dev.ralfguth.livraria.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "livros")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private Integer paginas;
	private LocalDate lancamento;

	@ManyToOne
	private Autor autor;

	public Livro(String titulo, Integer paginas, LocalDate lancamento, Autor autor) {
		this.titulo = titulo;
		this.paginas = paginas;
		this.lancamento = lancamento;
		this.autor = autor;
	}
	
}
