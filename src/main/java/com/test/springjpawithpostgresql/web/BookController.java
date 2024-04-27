package com.test.springjpawithpostgresql.web;

import com.test.springjpawithpostgresql.domain.Book;
import com.test.springjpawithpostgresql.dto.BookDTO;
import com.test.springjpawithpostgresql.service.BookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping()
    public ResponseEntity<?> getAllBooks() {
        List<BookDTO> list = bookService.getAllBooks();
        log.info(list.toString());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> getBooksByPublishedDate(
            @RequestParam("publishedDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate publishedDate) {
        List<BookDTO> list = bookService.findBooksByPublishedDate(publishedDate);
        if (list.isEmpty()) {
            log.warn("empty list result");
            return ResponseEntity.ok().body(list);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO saveBook(@RequestBody @Valid BookDTO bookDTO) {
        return bookService.saveBook(bookDTO);
    }
}
