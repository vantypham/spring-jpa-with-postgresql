package com.test.springjpawithpostgresql.web.converter;

import com.test.springjpawithpostgresql.domain.Book;
import com.test.springjpawithpostgresql.dto.BookDTO;

import java.util.ArrayList;
import java.util.List;

public class BookConverter {
    public static Book toObj(BookDTO dto) {
        Book obj = new Book();
        obj.setId(dto.getId());
        obj.setTitle(dto.getTitle());
        obj.setPrice(dto.getPrice());
        obj.setPublishDate(dto.getPublishDate());
        return obj;
    }
    public static BookDTO toDto(Book obj) {
        BookDTO dto = new BookDTO();
        dto.setId(obj.getId());
        dto.setTitle(obj.getTitle());
        dto.setPrice(obj.getPrice());
        dto.setPublishDate(obj.getPublishDate());
        return dto;
    }

    public static List<BookDTO> toDto(List<Book> objList) {
        List<BookDTO> list = new ArrayList<>();
        objList.forEach((obj) -> {
            BookDTO dto = new BookDTO();
            dto.setId(obj.getId());
            dto.setTitle(obj.getTitle());
            dto.setPrice(obj.getPrice());
            dto.setPublishDate(obj.getPublishDate());
            //
            list.add(dto);
        });

        return list;
    }
}
