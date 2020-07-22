package MyLogic;

public class SearchCriteria<T> {
	
	private String key;
    private String operation;
    private T value;
    
    
    SearchCriteria(String key,String operation,T value){
    	this.key=key;
    	this.operation=operation;
    	this.value=value;
    }


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public String getOperation() {
		return operation;
	}


	public void setOperation(String operation) {
		this.operation = operation;
	}


	public Object getValue() {
		return value;
	}


	public void setValue(T value) {
		this.value = value;
	}

    
    
    
}
