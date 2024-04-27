package com.test.springjpawithpostgresql.repository;

import com.test.springjpawithpostgresql.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
