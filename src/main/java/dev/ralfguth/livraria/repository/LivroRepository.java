package dev.ralfguth.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.ralfguth.livraria.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
