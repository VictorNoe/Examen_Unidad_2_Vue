package mx.edu.utez.examen.controllers;

import mx.edu.utez.examen.modals.Book;
import mx.edu.utez.examen.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utils.CustomResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/book")
@CrossOrigin(origins = {"*"})
public class BookController {
    @Autowired
    BookServices service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Book>>> getAll() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/author")
    public ResponseEntity<CustomResponse<List<Book>>> getAutor() {
        return new ResponseEntity<>(this.service.getAllOrderByAuthor(), HttpStatus.OK);
    }

    @GetMapping("/publication")
    public ResponseEntity<CustomResponse<List<Book>>> getPublicationDate() {
        return new ResponseEntity<>(this.service.searchPublicationDate(), HttpStatus.OK);
    }

    @GetMapping("/image")
    public ResponseEntity<CustomResponse<List<Book>>> getImage() {
        return new ResponseEntity<>(this.service.searchImage(), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<CustomResponse<Book>> inset(@RequestBody Book book) {
        return new ResponseEntity<>(this.service.insert(book), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<CustomResponse<Book>> update(@RequestBody Book book) {
        return new ResponseEntity<>(this.service.update(book), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse<Book>> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.service.delete(id), HttpStatus.CREATED);
    }
}
