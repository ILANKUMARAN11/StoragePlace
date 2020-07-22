package MyLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;


public class MuttiSpecBuilder<T,I> {

	private final List<SearchCriteria<I>> params;
	 
    public MuttiSpecBuilder() {
        params = new ArrayList<SearchCriteria<I>>();
    }
 
    public MuttiSpecBuilder<T,I> with(String key, String operation, I value) {
        params.add(new SearchCriteria<I>(key, operation, value));
        return this;
    }
 
    public Specification<T> build() {
        if (params.size() == 0) {
            return null;
        }
 
        List<Specification<T>> specs = params.stream()
          .map(spec->new EmployeeSpecification<T>(spec))
          .collect(Collectors.toList());
        
        Specification<T> result = Specification.where(specs.get(0));
 
        for (int i = 1; i < params.size(); i++) {
            result = result.and(specs.get(i));
        }  
        
        return result;
    }
}

