package mk.ukim.finki.lab2emt.service.impl;

import mk.ukim.finki.lab2emt.model.Author;
import mk.ukim.finki.lab2emt.repository.AuthorRepository;
import mk.ukim.finki.lab2emt.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }



}
