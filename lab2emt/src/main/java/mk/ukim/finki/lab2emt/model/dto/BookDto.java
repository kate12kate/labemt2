package mk.ukim.finki.lab2emt.model.dto;

import lombok.Data;
import mk.ukim.finki.lab2emt.model.Author;
import mk.ukim.finki.lab2emt.model.enumeration.Category;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
public class BookDto {


    private String name;

    private Category category;


    private Long authorId;

    private Integer availableCopies;

    public BookDto() {
    }

    public BookDto(String name, Category category, Long author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.authorId = author;
        this.availableCopies = availableCopies;
    }
}
