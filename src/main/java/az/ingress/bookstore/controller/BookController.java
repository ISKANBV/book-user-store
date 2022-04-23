package az.ingress.bookstore.controller;

import az.ingress.bookstore.dto.BookDTO;

import java.util.List;

public interface BookController {
    BookDTO getBookByName(String name);

    List<BookDTO> getBookByAuthor(String author);

    void add(BookDTO book);

    List<BookDTO> getAll();

    BookDTO getById(long id);

    void update(BookDTO book);

    void delete(long id);

    void deleteAll();
}
