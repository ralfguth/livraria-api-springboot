package dev.ralfguth.livraria.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "autores")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private LocalDate nascimento;
	private String biografia;

	public Autor(String nome, String email, LocalDate nascimento, String biografia) {
		this.nome = nome;
		this.email = email;
		this.nascimento = nascimento;
		this.biografia = biografia;
	}

	public void atualizar(String nome, String email, LocalDate nascimento, String biografia) {
		this.nome = nome;
		this.email = email;
		this.nascimento = nascimento;
		this.biografia = biografia;
	}
}
