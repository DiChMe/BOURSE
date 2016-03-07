package test;

import java.util.Collection;
import java.util.HashMap;
import data.*;

public class MainFlictuation {
	public static void main (String []args) throws InterruptedException{
		
	
	 HashMap<String,Evenement> evs =new HashMap<String, Evenement>();
	 GroupeEntreprise gpen=new GroupeEntreprise();
	  
	 Evenement e=new Evenement("ev",78);
	 Evenement e1=new Evenement("ev1",-48);
	 Evenement e2=new Evenement("ev2",8); 
	 Evenement e3=new Evenement("ev3",18);
	 Evenement e4=new Evenement("ev4",-17);
	 Evenement e5=new Evenement("ev5",0);
	 Evenement e6=new Evenement("ev6",0);
	 
	 
	 evs.put(e.getNevent(), e);
	 evs.put(e1.getNevent(), e1);
	 evs.put(e2.getNevent(), e2);
	 evs.put(e3.getNevent(), e3);
	 evs.put(e4.getNevent(), e4);
	 evs.put(e5.getNevent(), e5);
	 evs.put(e6.getNevent(), e6);
	
	 //System.out.println(evs);
	 
	 Entreprise en= new Entreprise("en",1,100,"type");
	// en.addEvenements(e2);
	 en.addEvenements(e4);
	// en.addEvenements(e6);
	 
	 Entreprise en1= new Entreprise("en1",1,1000,"type");
	 en1.addEvenements(e);
	 en1.addEvenements(e4);
     en1.addEvenements(e5);
	 
	 
	 Entreprise en2= new Entreprise("en2",1,10000,"type");
	en2.addEvenements(e2);
	 en2.addEvenements(e4);
	 en2.addEvenements(e4);
	
 
	 gpen.addEntrprise(en);gpen.addEntrprise(en1);gpen.addEntrprise(en2);
	 
	// System.err.println(gpen);
	/* for (Entreprise i:gpen.getEntreprises()){
		// System.out.println(i.getCapital());
		// Thread.sleep(5000);
		// System.err.println(i.getEvenements()+"\n\n\n\n");
		 
		 
		 for(Evenement even:co){
			 if(i.getEvenements().containsKey(even)){
				float v=(1+even.getVal())/100;
				i.setCapital(i.getCapital()*v);
			 }else{
				 continue;
			 }
		 }
		 
		 System.out.println(i.getCapital()+"\n\n\n");
		 Thread.sleep(5000);
		 
	 }*/
	 Collection<Evenement> co=evs.values();
	 
	for(Evenement evv:co){
		
	 for (Entreprise i:gpen.getEntreprises()){
		 System.out.println(i.getCapital());
		 if(i.getEvenements().containsValue(evv)){
			 
			 double val=(double)(100+evv.getVal())/100;
			// System.err.println(val);
		 i.setCapital(i.getCapital()*val);
		 
		 }else{
		//	 System.out.println(i+"\tne contien pas"+e4);
			 continue;
		 }
		// Thread.sleep(5000);
		 System.err.println(i.getCapital()+"\n\n\n");
		
	 }
	 Thread.sleep(5000);
	
	}
	 
	 
	 
	} 
	 
	 
	 
	 
	 
	 
	 
	
}

		
		
			
			
		
			
		
	 
	

