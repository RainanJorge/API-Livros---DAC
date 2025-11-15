package com.rainan.livros.application;

import com.rainan.livros.application.exceptions.BookAlreadyExistsException;
import com.rainan.livros.application.exceptions.BookNotFoundException;
import com.rainan.livros.domain.Livro;
import com.rainan.livros.infrastructure.LivroRepositoryImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepositoryImplementation repo;

    public Livro criarLivro(Livro livro) {
        if (repo.findByIsbn(livro.getIsbn()).isPresent()) {
            throw new BookAlreadyExistsException(livro.getIsbn());
        }
        return repo.save(livro);
    }

    public void deletarLivro(Livro livro) {
        if (repo.findById(livro.getId()).isEmpty()) {
            throw new BookNotFoundException(livro.getId());
        }
        else {
            repo.delete(livro);
        }
    }

    public Livro getBookById(Long id) {
        return repo.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    public Livro getBookByIsbn(String isbn) {
        return repo.findByIsbn(isbn).orElseThrow(() -> new BookNotFoundException(isbn));
    }

    public Livro atualizarLivro(Livro livro) {
        if (repo.findById(livro.getId()).isEmpty()) {
            throw new BookNotFoundException(livro.getId());
        }
        return repo.save(livro);
    }
}
