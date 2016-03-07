package data;

import java.util.ArrayList;

public interface OrderVisitor<T> {
	
	

	T visit(ArrayList<Ordre> items);

	

}
