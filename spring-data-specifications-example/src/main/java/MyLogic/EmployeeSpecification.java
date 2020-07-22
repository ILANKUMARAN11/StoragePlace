package MyLogic;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.logicbig.example.entity.Employee;
import com.logicbig.example.entity.Phone;
import com.logicbig.example.entity.PhoneType;


public class EmployeeSpecification<T> implements Specification<T> {
 
    private SearchCriteria criteria;
    
    EmployeeSpecification(SearchCriteria criteria){
    	this.criteria=criteria;
    }
 
    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
 
    	Predicate predicate = null;
        if (criteria.getOperation().equalsIgnoreCase("=")) {
        	predicate=criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());
        }else if(criteria.getOperation().equalsIgnoreCase("in")) {
        	predicate=root.get(criteria.getKey()).in(criteria.getValue());
        }else if (criteria.getOperation().equalsIgnoreCase("in")) {
        	Join<T, ?> phoneJoin = root.join(criteria.getKey());
        	predicate = criteriaBuilder.equal(phoneJoin.get("type"), PhoneType.Home);
        }
        return predicate;
        
    }
	
	
    
//    public static Specification<Employee> getEmployeesByPhoneTypeSpec(SearchCriteria<?> criteria) {
//        return new Specification<Employee>() {
//            @Override
//            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//            	Predicate predicate = null;
//                if (criteria.getOperation().equalsIgnoreCase("=")) {
//                	predicate=criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());
//                } else if (criteria.getOperation().equalsIgnoreCase("in")) {
//                	Join<Employee, Phone> phoneJoin = root.join(criteria.getKey());
//                	predicate = criteriaBuilder.equal(phoneJoin.get("type"), PhoneType.Home);
//                }
//                return predicate;
//            }
//        };
//    }
}

