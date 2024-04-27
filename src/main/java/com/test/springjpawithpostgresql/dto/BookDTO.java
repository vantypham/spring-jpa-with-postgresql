package com.test.springjpawithpostgresql.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long id;
    @NotBlank
    @Length(min = 3, max = 20)
    private String title;
    @NotNull
    private BigDecimal price;
    @NotNull
    private LocalDate publishDate;
}
