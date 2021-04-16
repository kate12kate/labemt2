package mk.ukim.finki.lab2emt.repository;

import mk.ukim.finki.lab2emt.model.Author;
import mk.ukim.finki.lab2emt.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    Optional<Book> findByName(String name);
    void deleteByName(String name);
}
