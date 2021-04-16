package mk.ukim.finki.lab2emt.web;

import mk.ukim.finki.lab2emt.model.Book;
import mk.ukim.finki.lab2emt.model.enumeration.Category;
import mk.ukim.finki.lab2emt.service.BookService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryRestController {
    private final BookService bookService;


    public CategoryRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    private List<Category> findAllCategories() {
        return this.bookService.findAllCategories();
    }
}
