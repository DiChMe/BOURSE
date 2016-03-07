package data;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Execution {
	
	
	 private static void siftUp(ArrayList<Ordre> items) {
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
	    public static void insertVente(ArrayList<Ordre> items,Ordre item) {
	        items.add(item);
	        siftUp(items);
	    }
	     
	    private static void siftDown(ArrayList<Ordre> items) {
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
		  		  		          siftDown(items);
		  		  		          break;
		    		        	}else{
		    		        		
		    		        		items.set(0, items.remove(items.size()-1));
			  		  		          siftDown(items);
		    		        		or.setQuantitée(or.getQuantitée()-hold.getQuantitée());
		    		        	}	
		    		        	
		    		     }
		     		          
				        }
	    	  } 	
	    	
	    }

	public static  void Vente(ArrayList<Ordre> Ordres,Ordre ordre){
	          vent(Ordres,ordre);	
	}
	

	 private static void siftU(ArrayList<Ordre> items) {
	        int k = items.size() - 1;
	        while (k > 0) {
	            int p = (k-1)/2;
	            Ordre item = items.get(k);
	            Ordre parent = items.get(p);
	            if (item.compareTo(parent) < 0) {
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
	 
	 private static void siftDow(ArrayList<Ordre> items) {
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

	 public static void achat(ArrayList<Ordre> items,Ordre or)throws NoSuchElementException{
	    	
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
	  		  		          siftDow(items);
	  		  		          break;
	    		        	}else{
	    		        		
	    		        		items.set(0, items.remove(items.size()-1));
		  		  		          siftDow(items);
	    		        		or.setQuantitée(or.getQuantitée()-hold.getQuantitée());
	    		        	}	
	    		        	
	    		     }
	     		          
			        }
   	  } 	
   	
   }
	 public static void insertAchat(ArrayList<Ordre> items,Ordre item) {
	        items.add(item);
	        siftU(items);
	    }
	 
	 public static void rec(ArrayList<Ordre> items,Ordre or){
			
			if(items.size()>0 && or.getQuantitée()>0){
				
				Ordre tmp=items.get(0);
				
				if(tmp.getQuantitée()>or.getQuantitée()){
					
					tmp.setQuantitée(tmp.getQuantitée()-or.getQuantitée());
					or.setQuantitée(0);
				}else{
						items.remove(0);
				//items.set(0, items.remove(items.size()-1));
						or.setQuantitée(or.getQuantitée()-tmp.getQuantitée());
						siftDown(items);
						
					}
				rec(items,or);	
						
					}
					
				}
	 public static void recachat(ArrayList<Ordre> items,Ordre or){
			

			if(items.size()>0 && or.getQuantitée()>0){
				
				Ordre tmp=items.get(0);
				
				if(tmp.getQuantitée()>or.getQuantitée()){
					
					tmp.setQuantitée(tmp.getQuantitée()-or.getQuantitée());
					or.setQuantitée(0);
				}else{
						items.remove(0);
					//items.set(0, items.remove(items.size()-1));
						or.setQuantitée(or.getQuantitée()-tmp.getQuantitée());
						siftDow
						(items);
						
					}
				recachat(items,or);	
						
					}
					


	 }
	 }
