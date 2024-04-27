package com.test.springjpawithpostgresql.service;

import com.test.springjpawithpostgresql.domain.Employee;
import com.test.springjpawithpostgresql.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRepository;

    public Employee addEmployee(Employee employee){
        return empRepository.saveAndFlush(employee);
    }

    public List<Employee> findAllEmployee(){
        return empRepository.findAll();
    }

    public Page<Employee> findBySearchCriteria(Specification<Employee> spec, Pageable page){
        Page<Employee> searchResult = empRepository.findAll(spec, page);
        return searchResult;
    }
}
