package az.ingress.bookstore.controller.Impl;

import az.ingress.bookstore.controller.BookController;
import az.ingress.bookstore.dto.BookDTO;
import az.ingress.bookstore.service.BookService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/books")
public class BookControllerImpl implements BookController {

    private final BookService service;

    public BookControllerImpl(BookService service) {
        this.service = service;
    }

    @Override
    @GetMapping("/book/")
    public BookDTO getBookByName(@RequestParam(value="name") String name) {
        return service.getBookByName(name);
    }

    @Override
    @GetMapping("/author/")
    public List<BookDTO> getBookByAuthor(@RequestParam(value="author") String author) {
        return service.getBookByAuthor(author);
    }

    @Override
    @PostMapping("/add")
    @PreAuthorize("hasRole('PUBLISHER') or hasRole('ADMIN')")
    public void add(@RequestBody BookDTO book) {
        service.add(book);
    }

    @Override
    @GetMapping("/all")
    public List<BookDTO> getAll() {
        return service.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public BookDTO getById(@PathVariable("id") long id) {
        return service.getById(id);
    }

    @Override
    @PutMapping("/")
    @PreAuthorize("hasRole('ROLE_PUBLISHER') or hasRole('ROLE_ADMIN')")
    public void update(@RequestBody BookDTO book) {
        service.update(book);
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_PUBLISHER') or hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable("id") long id) {
        service.delete(id);
    }

    @Override
    @DeleteMapping("/all")
    @PreAuthorize("hasRole('ROLE_PUBLISHER') or hasRole('ROLE_ADMIN')")
    public void deleteAll() {
        service.deleteAll();
    }
}
