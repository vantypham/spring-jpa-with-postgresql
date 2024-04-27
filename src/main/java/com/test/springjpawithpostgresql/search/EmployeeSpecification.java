package com.test.springjpawithpostgresql.search;

import com.test.springjpawithpostgresql.domain.Department;
import com.test.springjpawithpostgresql.domain.Employee;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class EmployeeSpecification implements
        Specification<Employee> {
    private final SearchCriteria searchCriteria;

    public EmployeeSpecification(final SearchCriteria
                                         searchCriteria){
        super();
        this.searchCriteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        String strToSearch = searchCriteria.getValue().toString().toLowerCase();
        String simpleOps = searchCriteria.getOperation();
        String filterKey = searchCriteria.getFilterKey();

        switch(Objects.requireNonNull(SearchOperationEnum.getSimpleOperation(simpleOps))){
            case CONTAINS:
                if(filterKey.equals("deptName"))
                {
                    return
                            cb.like(cb.lower(this.departmentJoin(root).get(filterKey)), "%" + strToSearch + "%");
                }
                return cb.like(cb.lower(root.get(filterKey)), "%" + strToSearch + "%");

            case DOES_NOT_CONTAINS:
                if(filterKey.equals("deptName"))
                {
                    return cb.notLike(cb.lower(this.departmentJoin(root).get(filterKey)),
                            "%" + strToSearch +"%");
                }
                return cb.notLike(cb.lower(root.get(filterKey)),
                        "%" + strToSearch + "%");
            case EQUAL:
                if(filterKey.equals("deptName")) {
                    return cb.equal(cb.upper(this.departmentJoin(root).get(filterKey)), strToSearch);
                }
                return cb.equal(cb.upper(root.get(filterKey)), strToSearch);
//            .....
//            .....
            //TODO other CASEs
            //TODO other CASEs
            default:
                return cb.conjunction();
        }
    }
    private Join<Employee, Department> departmentJoin(Root<Employee> root){
        return root.join("department");
    }
}
