package mx.edu.utez.examen.services;

import mx.edu.utez.examen.modals.Book;
import mx.edu.utez.examen.modals.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utils.CustomResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

@Service
public class BookServices {

    @Autowired
    BookRepository repository;


    @Transactional(readOnly = true)
    public CustomResponse<List<Book>> getAll() {
        try {
            return new CustomResponse<>(this.repository.findAll(), false, 200, "OK");
        } catch (Exception e) {
            return new CustomResponse<>(null, true, 500, "OK");
        }
    }

    @Transactional(readOnly = true)
    public CustomResponse<List<Book>> getAllOrderByAuthor() {
        try {
            return new CustomResponse<>(this.repository.findAllByOrderByAuthor(), false, 200, "OK");
        } catch (Exception e) {
            return new CustomResponse<>(null,true, 500, "Error de libros");
        }
    }

    @Transactional(readOnly = true)
    public CustomResponse<List<Book>> searchPublicationDate() {
        try {
            return new CustomResponse<>(repository.findAllByOrderByPublicationDate(), false, 200, "OK");
        } catch (Exception e) {
            return new CustomResponse<>(null, true, 500, "Error al buscar libros por rango de fechas");
        }
    }
    @Transactional(readOnly = true)
    public CustomResponse<List<Book>> searchImage() {
        try {
            return new CustomResponse<>(repository.findAllByImageIsNotNull(), false, 200, "OK");
        } catch (Exception e) {
            return new CustomResponse<>(null, true, 500, "Error al buscar libros por rango de fechas");
        }
    }


    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Book> insert(Book book) {
        book.setImage("https://picsum.photos/200/80");
        try {
            return new CustomResponse<>(this.repository.saveAndFlush(book), false, 201, "OK");
        } catch (Exception e) {
            return new CustomResponse<>(null, true, 500, "OK");
        }
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Book> update(Book book) {
        try {
            if(!this.repository.existsById(book.getId()))
                return new CustomResponse<>(null, true, 400, "OK");
            return new CustomResponse<>(this.repository.saveAndFlush(book), false, 201, "OK");
        } catch (Exception e) {
            return new CustomResponse<>(null, true, 500, "OK");
        }
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Book> delete(Long id) {
        try {
            if (!this.repository.existsById(id))
                return new CustomResponse<>(null, true, 400, "OK");
            this.repository.deleteById(id);
            return new CustomResponse<>(null, false, 200, "OK");
        } catch (Exception e) {
            return new CustomResponse<>(null, true, 500, "OK");
        }
    }
}
