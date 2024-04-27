package com.test.springjpawithpostgresql.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSearchDTO {
    private List<SearchCriteria> searchCriteriaList;
    private String dataOption; //any or all
}
