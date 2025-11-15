package com.rainan.livros.application;

import com.rainan.livros.application.exceptions.BookAlreadyExistsException;
import com.rainan.livros.application.exceptions.BookNotFoundException;
import com.rainan.livros.domain.Livro;
import com.rainan.livros.infrastructure.LivroRepositoryImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LivroService {
    private final LivroRepositoryImplementation repo;

    @Autowired
    public LivroService(LivroRepositoryImplementation repo) {
        this.repo = repo;
    }

    @Transactional
    public Livro criarLivro(Livro livro) {
        if (repo.findByIsbn(livro.getIsbn()).isPresent()) {
            throw new BookAlreadyExistsException(livro.getIsbn());
        }
        return repo.save(livro);
    }

    @Transactional
    public void deletarLivro(Long id) {
        Livro livro = repo.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        repo.delete(livro);
    }

    @Transactional(readOnly = true)
    public List<Livro> findAll() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public Livro getBookById(Long id) {
        return repo.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public Livro getBookByIsbn(String isbn) {
        return repo.findByIsbn(isbn).orElseThrow(() -> new BookNotFoundException(isbn));
    }

    @Transactional
    public Livro atualizarLivro(Long id, Livro dados) {
        Livro existente = repo.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        existente.setTitle(dados.getTitle());
        existente.setAuthor(dados.getAuthor());
        existente.setPublicationYear(dados.getPublicationYear());
        existente.setStockQuantity(dados.getStockQuantity());

        return repo.save(existente);
    }
}
