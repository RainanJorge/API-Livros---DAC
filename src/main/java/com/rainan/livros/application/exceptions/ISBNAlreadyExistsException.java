package com.rainan.livros.application.exceptions;

public class ISBNAlreadyExistsException extends RuntimeException {

    private String isbn;

    public ISBNAlreadyExistsException(String isbn) {
        super("O ISNB'" + isbn + "' está sendo usado por outro livro.");
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

}
