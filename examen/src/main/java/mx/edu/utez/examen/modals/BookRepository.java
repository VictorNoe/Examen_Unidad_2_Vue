package mx.edu.utez.examen.modals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT * FROM books ORDER BY author;", nativeQuery = true)
    List<Book> findAllByOrderByAuthor();

    @Query(value = "SELECT * FROM books ORDER BY publication_date;", nativeQuery = true)
    List<Book> findAllByOrderByPublicationDate();

    @Query(value = "SELECT * FROM books WHERE image !='';", nativeQuery = true)
    List<Book> findAllByImageIsNotNull();
}
