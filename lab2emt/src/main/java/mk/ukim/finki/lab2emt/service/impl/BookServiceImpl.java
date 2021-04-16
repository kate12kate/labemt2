package mk.ukim.finki.lab2emt.service.impl;

import mk.ukim.finki.lab2emt.model.Author;
import mk.ukim.finki.lab2emt.model.Book;
import mk.ukim.finki.lab2emt.model.dto.BookDto;
import mk.ukim.finki.lab2emt.model.enumeration.Category;
import mk.ukim.finki.lab2emt.model.exception.AuthorNotFound;
import mk.ukim.finki.lab2emt.model.exception.BookNotFound;
import mk.ukim.finki.lab2emt.repository.AuthorRepository;
import mk.ukim.finki.lab2emt.repository.BookRepository;
import mk.ukim.finki.lab2emt.service.BookService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final ApplicationEventPublisher applicationEventPublisher;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(ApplicationEventPublisher applicationEventPublisher, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> findByName(String name) {
        return this.bookRepository.findByName(name);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author=this.authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(()->new AuthorNotFound());

        this.bookRepository.deleteByName(bookDto.getName());
        Book book = new Book(bookDto.getName(), bookDto.getCategory(),author,bookDto.getAvailableCopies());
        this.bookRepository.save(book);
        //this.refreshMaterializedView();

       // this.applicationEventPublisher.publishEvent(new ProductCreatedEvent(product));
        return Optional.of(book);

    }

    @Override
    public Optional<Book> edit(BookDto bookDto,Long bookId) {
        Book book = this.bookRepository.findById(bookId).orElseThrow(() -> new BookNotFound());

        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAvailableCopies(bookDto.getAvailableCopies());

        Author author=this.authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(()->new AuthorNotFound());
        book.setAuthor(author);


        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> save(String name, Category category, Long authorid, Integer availableCopies) {

        Author author=this.authorRepository.findById(authorid)
                .orElseThrow(()->new AuthorNotFound());

        this.bookRepository.deleteByName(name);
        Book book = new Book(name, category,author,availableCopies);
        this.bookRepository.save(book);
        //this.refreshMaterializedView();

        //this.applicationEventPublisher.publishEvent(new ProductCreatedEvent(product));
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, String name, Category category, Long authorid, Integer availableCopies) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFound());

        book.setName(name);
        book.setCategory(category);
        book.setAvailableCopies(availableCopies);

        Author author=this.authorRepository.findById(authorid)
                .orElseThrow(()->new AuthorNotFound());

        book.setAuthor(author);

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public List<Category> findAllCategories() {
        return Arrays.asList(Category.values().clone());
    }

    @Override
    public void refreshMaterializedView() {

    }
}
