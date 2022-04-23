package az.ingress.bookstore.repository;

import az.ingress.bookstore.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity,Long> {
    BookEntity findByName(String name);

    List<BookEntity> findAllByAuthor(String author);
}
