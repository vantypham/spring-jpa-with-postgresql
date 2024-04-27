package com.test.springjpawithpostgresql;

import com.test.springjpawithpostgresql.domain.Book;
import com.test.springjpawithpostgresql.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringjpawithpostgresqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringjpawithpostgresqlApplication.class, args);
    }

    @Autowired
    BookRepository bookRepository;
//    @Override
//    public void run(String... args) throws Exception {
//
//    }

    @Bean
    @ConditionalOnProperty(prefix = "app", name = "db.init.enabled", havingValue = "true")
    public CommandLineRunner initDataBooks() {
        return (args -> {
            Book book1 = new Book();
            book1.setPrice(new BigDecimal(19.99));
            book1.setPublishDate(LocalDate.now());
            book1.setTitle("Windy");
            //
            Book book2 = new Book();
            book2.setPrice(new BigDecimal(50.99));
            book2.setPublishDate(LocalDate.of(2000, 05, 21));
            book2.setTitle("Spring");
            //
            Book book3 = new Book();
            book3.setPrice(new BigDecimal(11.99));
            book3.setPublishDate(LocalDate.of(2023, 01, 29));
            book3.setTitle("Fall");
            //
            Book book4 = new Book();
            book4.setPrice(new BigDecimal(21.99));
            book4.setPublishDate(LocalDate.of(2023, 02, 12));
            book4.setTitle("Summer");
            bookRepository.saveAll(List.of(book1, book2,book3,book4));
        });
    }
}
