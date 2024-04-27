package com.test.springjpawithpostgresql.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.springjpawithpostgresql.domain.Department;
import com.test.springjpawithpostgresql.domain.Employee;
import com.test.springjpawithpostgresql.domain.SalaryGrade;
import com.test.springjpawithpostgresql.repository.DepartmentRepository;
import com.test.springjpawithpostgresql.repository.SalaryGradeRepository;
import com.test.springjpawithpostgresql.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentRepository departmentService;

    @Autowired
    private SalaryGradeRepository salaryGradeService;

    @Override
    public void run(String... args) throws Exception {


        ObjectMapper objectMapper = new ObjectMapper();
        try {
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/department.json");
            log.info("Saving Department data");
            List<Department> dept = objectMapper.readValue(inputStream, new TypeReference<List<Department>>() {});
            dept.stream().forEach(x -> departmentService.save(x));
            log.info("Successfully save");

            inputStream = TypeReference.class.getResourceAsStream("/json/employee.json");
            log.info("Saving Employee data");
            List<Employee> empList = objectMapper.readValue(inputStream, new TypeReference<List<Employee>>() {});
            empList.stream().forEach(x -> employeeService.addEmployee(x));
            log.info("Successfully save");

            inputStream = TypeReference.class.getResourceAsStream("/json/salarygrade.json");
            log.info("Saving Salary grade data");
            List<SalaryGrade> salaryGrade = objectMapper.readValue(inputStream, new TypeReference<List<SalaryGrade>>() {});
            salaryGrade.stream().forEach(x -> salaryGradeService.saveAndFlush(x));
            log.info("Successfully save");
        }
        catch(IOException e){
            log.error("Unable to save data" + e.getMessage());
        }
    };

}
