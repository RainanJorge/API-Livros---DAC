package com.rainan.livros.infrastructure;

import com.rainan.livros.domain.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LivroRepositoryImplementation {

    @Autowired
    private LivroJpaRepository repo;

    public Livro save(Livro livro) {
        return repo.save(livro);
    }

    public void delete(Livro livro) {
        repo.delete(livro);
    }

    public List<Livro> findAll() {
        return repo.findAll();
    }

    public Optional<Livro> findById(Long id) {
        return repo.findById(id);
    }

    public Optional<Livro> findByIsbn(String isbn) {
        return repo.findByIsbn(isbn);
    }

    public Livro update(Livro livro) {
        return repo.save(livro);
    }
}

