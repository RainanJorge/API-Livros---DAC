package com.rainan.livros.infrastructure;

import com.rainan.livros.domain.Livro;
import com.rainan.livros.domain.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LivroRepositoryImplementation implements LivroRepository {

    @Autowired
    private LivroJpaRepository repo;

    @Override
    public Livro save(Livro livro) {
        return repo.save(livro);
    }

    @Override
    public void delete(Livro livro) {
        repo.delete(livro);
    }

    @Override
    public List<Livro> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Livro> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Optional<Livro> findByIsbn(String isbn) {
        return repo.findByIsbn(isbn);
    }
}

