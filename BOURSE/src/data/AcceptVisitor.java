package data;



public interface AcceptVisitor {
    
	<T> T accept(OrderVisitor<T> visitor); 
	 
}
