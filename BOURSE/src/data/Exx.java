package data;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Exx {
	
	
	public static void mise(ArrayList<Ordre> items){
		
		 int k = items.size() - 1;
	        while (k > 0) {
	            int p = (k-1)/2;
	            Ordre item = items.get(k);
	            Ordre parent = items.get(p);
	            if (item.compareTo(parent) > 0) {
	                // swap
	                items.set(k, parent);
	                items.set(p, item);
	                 
	                // move up one level
	                k = p;
	            } else {
	                break;
	            }
	        }	
			
		}


public static void insert(ArrayList<Ordre> items,Ordre item) {
    items.add(item);
    mise(items);
}
private static void mise2(ArrayList<Ordre> items) {
    int k = 0;
    int l = 2*k+1;
    while (l < items.size()) {
        int max=l, r=l+1;
        if (r < items.size()) { // there is a right child
            if (items.get(r).compareTo(items.get(l)) > 0) {
                max++;
            }
        }
        if (items.get(k).compareTo(items.get(max)) < 0) {
                // switch
                Ordre temp = items.get(k);
                items.set(k, items.get(max));
                items.set(max, temp);
                k = max;
                l = 2*k+1;
        } else {
            break;
        }
    }
}

public static void vent(ArrayList<Ordre> items,Ordre or)throws NoSuchElementException{
	
	  if (items.size() == 0) {
          throw new NoSuchElementException();
      }
	  else{
      		while(!items.isEmpty() && or.getQuantitée()>0){
      			 Ordre hold = items.get(0);
      			
      			if(items.get(0).getQuantitée()>or.getQuantitée()){
  		        	items.get(0).setQuantitée(items.get(0).getQuantitée()-or.getQuantitée());
  		        	or.setQuantitée(0);
  		        	
  		        }else{
  		        	if(items.get(0).getQuantitée()==or.getQuantitée()){
  		        		items.set(0, items.remove(items.size()-1));
		  		          mise2(items);
		  		          break;
  		        	}else{
  		        		
  		        		items.set(0, items.remove(items.size()-1));
	  		  		          mise2(items);
  		        		or.setQuantitée(or.getQuantitée()-hold.getQuantitée());
  		        	}	
  		        	
  		     }
   		          
		        }
	  } 	
	
}

public static void rec(ArrayList<Ordre> items,Ordre or){
	
	if(items.size()>0 && or.getQuantitée()>0){
		
		Ordre tmp=items.get(0);
		
		if(tmp.getQuantitée()>or.getQuantitée()){
			
			tmp.setQuantitée(tmp.getQuantitée()-or.getQuantitée());
			or.setQuantitée(0);
		}else{
				//items.remove(0);
			items.set(0, items.remove(items.size()-1));
				or.setQuantitée(or.getQuantitée()-tmp.getQuantitée());
				mise2(items);
				
			}
		rec(items,or);	
				
			}
			
		}
private static void mise3(ArrayList<Ordre> items) {
    int k = 0;
    int l = 2*k+1;
    while (l < items.size()) {
        int max=l, r=l+1;
        if (r < items.size()) { // there is a right child
            if (items.get(r).compareTo(items.get(l)) < 0) {
                max++;
            }
        }
        if (items.get(k).compareTo(items.get(max)) > 0) {
                // switch
                Ordre temp = items.get(k);
                items.set(k, items.get(max));
                items.set(max, temp);
                k = max;
                l = 2*k+1;
        } else {
            break;
        }
    }
}	
		
public static void recachat(ArrayList<Ordre> items,Ordre or)throws NoSuchElementException{
	
if(items.size()>0 && or.getQuantitée()>0){
		
		Ordre tmp=items.get(0);
		
		if(tmp.getQuantitée()>or.getQuantitée()){
			
			tmp.setQuantitée(tmp.getQuantitée()-or.getQuantitée());
			or.setQuantitée(0);
		}else{
				items.remove(0);
			//items.set(0, items.remove(items.size()-1));
				or.setQuantitée(or.getQuantitée()-tmp.getQuantitée());
				mise3(items);
				
			}
		recachat(items,or);	
 }

}

	
}
