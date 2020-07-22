package com.logicbig.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.logicbig.example.entity.Employee;
import com.logicbig.example.entity.Phone;
import com.logicbig.example.entity.PhoneType;
import com.logicbig.example.repo.EmployeeRepository;

import MyLogic.MuttiSpecBuilder;

@Service
public class ExampleClient implements CommandLineRunner{

    @Autowired
    private EmployeeRepository repo;

    public void run(String... args) {
        List<Employee> persons = createEmployees();
        repo.saveAll(persons);
        
        search();
        //findAllEmployees();
       //==> findEmployeesByName();
       // findEmployeesByPhoneType();
    }

    private void findEmployeesByName() {
        System.out.println("-- finding employees with name Tim --");
        //calling JpaSpecificationExecutor#findAll(Specification)
        List<Employee> list = repo.findAll(EmployeeSpecs.getEmployeesByNameSpec("Mike"));
        list.forEach(System.out::println);
    }
    
    
    public void search() {
        MuttiSpecBuilder builder = new MuttiSpecBuilder();
        
        //builder.with("name","=","Mike");
        builder.with("name","in",Arrays.asList(new String[]{"Mike","Tim"}));
        
        Collection<Phone> ls=new ArrayList<>();
        Phone p=new Phone();
        p.setNumber("22-222-222");
        p.setType(PhoneType.Work);
        ls.add(p);
        builder.with("phones","in",ls);
        
//        Employee e=new Employee();
//        e.setPhones(ls);
        
        Specification<Employee> spec = builder.build();
        repo.findAll(spec).forEach(System.out::println);
    }
    
    

    private void findEmployeesByPhoneType() {
        System.out.println("-- finding employees by phone type Cell --");
        //calling JpaSpecificationExecutor#findAll(Specification)
        List<Employee> list = repo.findAll(EmployeeSpecs.getEmployeesByPhoneTypeSpec(PhoneType.Cell));
        list.forEach(System.out::println);
    }

//    private void findAllEmployees() {
//        System.out.println(" -- getting all Employees --");
//        Iterable<Employee> iterable = repo.findAll();
//        List<Employee> allEmployees = StreamSupport.stream(iterable.spliterator(), false)
//                                                   .collect(Collectors.toList());
//        allEmployees.forEach(System.out::println);
//    }

    private static List<Employee> createEmployees() {
        return Arrays.asList(Employee.create("Diana",Phone.of(PhoneType.Home, "111-111-111"), Phone.of(PhoneType.Work, "222-222-222")),
                Employee.create("Mike",Phone.of(PhoneType.Work, "333-111-111"), Phone.of(PhoneType.Cell, "333-222-222")),
                Employee.create("Tim", Phone.of(PhoneType.Work, "444-111-111"), Phone.of(PhoneType.Home, "444-222-222")),
                Employee.create("Mike", Phone.of(PhoneType.Home, "22-222-222"))


        		);
    }
}