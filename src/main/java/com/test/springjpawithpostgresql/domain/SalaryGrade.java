package com.test.springjpawithpostgresql.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SalaryGrade {
    @Id
    private Long grade;
    private double minSalary;
    private double maxSalary;
}
