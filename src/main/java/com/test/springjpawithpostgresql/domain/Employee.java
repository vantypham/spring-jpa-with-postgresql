package com.test.springjpawithpostgresql.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
//    @Column(name = "EMP_ID")
    private Long empId;
    private String emplastNm;
    private String empfirstNm;
    private String jobNm;
//    @Column(name = "MGR_ID")
    private Long managerId;
    private Date hireDt;
    private double salary;
    private double commission;
    @ManyToOne
    @JoinColumn(name = "deptId")
    private Department department;
}
