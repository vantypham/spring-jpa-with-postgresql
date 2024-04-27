package com.test.springjpawithpostgresql.repository;

import com.test.springjpawithpostgresql.domain.SalaryGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryGradeRepository extends JpaRepository<SalaryGrade, Long> {
}
