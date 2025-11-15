package com.rainan.livros.application.exceptions;

public class BookAlreadyExistsException extends RuntimeException {

    private String isbn;

    public BookAlreadyExistsException(String isbn) {
        super("Um livro com o ISBN:'" + isbn + "' já existe.");
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
}
