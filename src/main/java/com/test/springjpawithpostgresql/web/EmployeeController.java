package com.test.springjpawithpostgresql.web;

import com.test.springjpawithpostgresql.domain.Employee;
import com.test.springjpawithpostgresql.search.EmpSpecificationBuilder;
import com.test.springjpawithpostgresql.search.EmployeeSearchDTO;
import com.test.springjpawithpostgresql.search.SearchCriteria;
import com.test.springjpawithpostgresql.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService empService;


    @PostMapping("/search")
    public ResponseEntity<?> searchEmployees(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
             @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
             @RequestBody EmployeeSearchDTO employeeSearchDto) {

        EmpSpecificationBuilder builder = new EmpSpecificationBuilder();
        List<SearchCriteria> criteriaList = employeeSearchDto.getSearchCriteriaList();
        if(criteriaList != null){
            criteriaList.forEach(x-> {
                x.setDataOption(employeeSearchDto.getDataOption());
                builder.with(x);
            });
        }

        Pageable page = PageRequest.of(pageNum, pageSize,
                Sort.by("empfirstNm")
                        .ascending()
                        .and(Sort.by("emplastNm"))
                        .ascending()
                        .and(Sort.by("department"))
                        .ascending());

        Page<Employee> employeePage = empService.findBySearchCriteria(builder.build(), page);

        return new ResponseEntity<>(employeePage.toList(), HttpStatus.OK);
    }
}

