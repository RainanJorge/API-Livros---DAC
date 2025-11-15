package com.rainan.livros.domain;

import java.util.List;
import java.util.Optional;

public interface LivroRepository {
    Livro save(Livro livro);
    void delete(Livro livro);
    List<Livro> findAll();
    Optional<Livro> findById(Long id);
    Optional<Livro> findByIsbn(String isbn);
}

