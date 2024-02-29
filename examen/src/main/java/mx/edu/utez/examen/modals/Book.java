package mx.edu.utez.examen.modals;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String nameBook;

    @Column(nullable = false)
    private LocalDate publicationDate;

    @Column(nullable = false)
    private String image;
}
