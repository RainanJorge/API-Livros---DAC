package com.rainan.livros.controllers;

import com.rainan.livros.application.LivroService;
import com.rainan.livros.domain.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    @PostMapping
    public ResponseEntity<Livro> criar(@RequestBody Livro livro) {
        Livro criado = service.criarLivro(livro);
        return new ResponseEntity<>(criado, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listarTodos() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.getBookById(id));
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Livro> buscarPorIsbn(@PathVariable String isbn) {
        return ResponseEntity.ok(service.getBookByIsbn(isbn));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id, @RequestBody Livro dados) {
        Livro atualizado = service.atualizarLivro(id, dados);
        return ResponseEntity.ok(atualizado);
    }

}
