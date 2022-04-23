package az.ingress.bookstore.service.Impl;

import az.ingress.bookstore.dto.BookDTO;
import az.ingress.bookstore.entity.BookEntity;
import az.ingress.bookstore.mapper.BookMapper;
import az.ingress.bookstore.repository.BookRepository;
import az.ingress.bookstore.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public BookDTO getBookByName(String name) {
        return BookMapper.INSTANCE.toDTO(repository.findByName(name));
    }

    @Override
    public List<BookDTO> getBookByAuthor(String author) {
        return repository.findAllByAuthor(author).stream().map(BookMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public void add(BookDTO book) {
        repository.save(BookMapper.INSTANCE.toEntity(book));
    }

    @Override
    public List<BookDTO> getAll() {
        return repository.findAll().stream().map(BookMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public BookDTO getById(long id) {
        return BookMapper.INSTANCE.toDTO(repository.findById(id).orElseThrow(() -> new RuntimeException("id not found")));
    }

    @Override
    public void update(BookDTO book) {
        BookEntity updatedBook = repository.getById(book.getId());
        updatedBook.setName(book.getName());
        updatedBook.setAuthor(book.getAuthor());
        updatedBook.setDetail(book.getDetail());
        repository.save(updatedBook);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
