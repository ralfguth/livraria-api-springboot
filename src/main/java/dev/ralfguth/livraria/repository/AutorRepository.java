package dev.ralfguth.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.ralfguth.livraria.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
