package com.rainan.livros;

import com.rainan.livros.application.LivroService;
import com.rainan.livros.application.exceptions.BookAlreadyExistsException;
import com.rainan.livros.application.exceptions.BookNotFoundException;
import com.rainan.livros.domain.Livro;
import com.rainan.livros.infrastructure.LivroRepositoryImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class LivroApplicationTests {

    private LivroRepositoryImplementation repo;
    private LivroService service;

    @BeforeEach
    void setup() {
        repo = Mockito.mock(LivroRepositoryImplementation.class);
        service = new LivroService(repo);
    }

    // --Teste: Criar Livro--
    @Test
    void criarLivro_sucesso() {
        Livro livro = new Livro("Como Vender Curso Online", "Paulo Vieira", "123", 2020, 5);

        when(repo.findByIsbn("123")).thenReturn(Optional.empty());
        when(repo.save(livro)).thenReturn(livro);

        Livro resultado = service.criarLivro(livro);

        assertEquals("123", resultado.getIsbn());
        verify(repo, times(1)).save(livro);
    }

    @Test
    void criarLivro_existente() {

        Livro livro = new Livro("Como Vender Curso Online", "Paulo Vieira", "123", 2020, 5);

        when(repo.findByIsbn("123")).thenReturn(Optional.of(livro));

        assertThrows(BookAlreadyExistsException.class, () -> service.criarLivro(livro));
    }

    @Test
    void getBookById_livroNaoExiste() {
        when(repo.findById(1L)).thenReturn(Optional.empty());

        assertThrows(BookNotFoundException.class, () -> service.getBookById(1L));
    }

    // --Teste: Buscar todos os livros--

    @Test
    void deletarLivro_livroExiste() {
        Livro livro = new Livro("A", "Autor", "111", 2020, 2);

        when(repo.findById(1L)).thenReturn(Optional.of(livro));

        service.deletarLivro(1L);

        verify(repo, times(1)).delete(livro);
    }

    @Test
    void deletarLivro_livroNaoExiste() {
        when(repo.findById(1L)).thenReturn(Optional.empty());

        assertThrows(BookNotFoundException.class, () -> service.deletarLivro(1L));
    }

    // --Teste: Atualizar livro--

    @Test
    void atualizarLivro_livroExiste() {
        Livro existente = new Livro("Velho", "Autor", "111", 2010, 2);
        Livro novosDados = new Livro("Novo", "Autor2", "111", 2023, 5);

        when(repo.findById(1L)).thenReturn(Optional.of(existente));
        when(repo.save(existente)).thenReturn(existente);

        Livro resultado = service.atualizarLivro(1L, novosDados);

        assertEquals("Novo", resultado.getTitle());
        assertEquals("Autor2", resultado.getAuthor());
        assertEquals(2023, resultado.getPublicationYear());
        assertEquals(5, resultado.getStockQuantity());
    }

    @Test
    void atualizarLivro_livroNaoExiste() {
        Livro dados = new Livro("X", "Y", "999", 2020, 1);

        when(repo.findById(1L)).thenReturn(Optional.empty());

        assertThrows(BookNotFoundException.class, () -> service.atualizarLivro(1L, dados));
    }

}
