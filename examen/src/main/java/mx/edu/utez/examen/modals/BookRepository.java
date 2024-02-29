package mx.edu.utez.examen.modals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByOrderByAuthorAsc();

    List<Book> findAllByOrderByPublicationDateAsc();
}
