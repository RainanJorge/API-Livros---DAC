package com.rainan.livros.application.exceptions;

public class BookNotFoundException extends RuntimeException {

    private Long bookId;
    private String isbn;

    public BookNotFoundException(Long bookId) {
        super("Nenhum livro encontrado com o ID: " + bookId);
        this.bookId = bookId;
    }

    public BookNotFoundException(String isbn) {
        super("Nenhum livro encontrado com o ISBN: " + isbn);
        this.isbn = isbn;
    }

    public Long getBookId() {
        return bookId;
    }

    public String getIsbn() {
        return isbn;
    }
}
