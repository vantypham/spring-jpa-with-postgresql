package com.test.springjpawithpostgresql.service;

import com.test.springjpawithpostgresql.domain.Book;
import com.test.springjpawithpostgresql.dto.BookDTO;
import com.test.springjpawithpostgresql.repository.BookRepository;
import com.test.springjpawithpostgresql.web.converter.BookConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookDTO> getAllBooks() {
        return BookConverter.toDto(bookRepository.findAll());
    }

    public List<BookDTO> findBooksByPublishedDate(LocalDate date) {
        return BookConverter.toDto(bookRepository.findByPublishedDateAfter(date));
    }

    public BookDTO saveBook(BookDTO bookDTO) {
         bookRepository.save(BookConverter.toObj(bookDTO));
         return bookDTO;
    }
}
