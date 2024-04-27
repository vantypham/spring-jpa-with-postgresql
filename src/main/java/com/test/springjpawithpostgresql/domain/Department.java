package com.test.springjpawithpostgresql.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department {
    @Id
    private Long deptId;
//    @Column(name = "DEPT_NAME")
    private String deptName;

    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private List<Employee> emps;

}
