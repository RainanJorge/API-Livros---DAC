package com.rainan.livros.infrastructure;

import com.rainan.livros.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivroJpaRepository extends JpaRepository<Livro, Long> {

    Optional<Livro> findByIsbn(String isbn);

}
