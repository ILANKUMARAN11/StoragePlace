package com.logicbig.example.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.logicbig.example.entity.Employee;
import com.logicbig.example.entity.Phone;
import com.logicbig.example.entity.PhoneType;


@Service
public class EmployeeSpecs {
	
	
    public static Specification<Employee> getEmployeesByNameSpec(String name) {
        return new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder criteriaBuilder) {
                Predicate equalPredicate = criteriaBuilder.in(root.get("name"));
                List<String> ls=new ArrayList<>();
                ls.add(name);
                return root.get("name").in(ls);
            }
        };
    }

    public static Specification<Employee> getEmployeesByPhoneTypeSpec(PhoneType phoneType) {
        return new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder criteriaBuilder) {
                Join<Employee, Phone> phoneJoin = root.join("");
                Predicate equalPredicate = criteriaBuilder.equal(phoneJoin.get(""), phoneType);
                return equalPredicate;
            }
        };
    }
    
    
    
    
    
    
    
    
}