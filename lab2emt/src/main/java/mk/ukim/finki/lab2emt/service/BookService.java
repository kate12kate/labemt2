package mk.ukim.finki.lab2emt.service;

import mk.ukim.finki.lab2emt.model.Author;
import mk.ukim.finki.lab2emt.model.Book;
import mk.ukim.finki.lab2emt.model.dto.BookDto;
import mk.ukim.finki.lab2emt.model.enumeration.Category;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> findByName(String name);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(BookDto bookDto,Long bookId);

    Optional<Book> save(String name, Category category, Long authorid, Integer availableCopies);

    Optional<Book> edit(Long id, String name, Category category, Long authorid, Integer availableCopies);

    void deleteById(Long id);

    List<Category> findAllCategories();

    void refreshMaterializedView();
}
