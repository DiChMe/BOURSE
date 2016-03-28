package data;

import java.util.Date;
import java.util.Random;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		CarnetOrdre carnet= new CarnetOrdre();
		 Random r= new Random();
		 Random k= new Random();
	     Random g= new Random();
		
		Date date = new Date();
	//   Ordre aa = new AchatN(1,r.nextInt(89)+g.nextDouble(),k.nextInt(47),55,new Date(),"achat");
	   Ordre ab= new AchatN(1,14.8,8,77,new Date(),"achat");
	   Ordre ac= new AchatN(1,12.8,7,71,new Date(),"achat");
	   Ordre aa= new AchatN(1,14.45,8,77,new Date(),"achat");
	   Ordre ad= new AchatN(1,17.8,7,71,new Date(),"achat");
	 //  Ordre ad = new AchatN(1,r.nextInt(89)+g.nextDouble(),k.nextInt(47),55,new Date(),"achat");
	   
	   
	  // Ordre ba = new AchatN(1,r.nextInt(89)+g.nextDouble(),k.nextInt(47),55,new Date(),"vente");
	  // Ordre bb= new AchatN(1,r.nextInt(89)+g.nextDouble(),k.nextInt(47),55,new Date(),"vente");
	   Ordre bc= new AchatN(1,19.8,47797889,4,new Date(),"vente");
	   Ordre bd = new AchatN(1,54.8,78,7,new Date(),"vente");
	   Ordre ba= new AchatN(1,11.8,8,6,new Date(),"vente");
	   Ordre bb = new AchatN(1,24.8,78,7,new Date(),"vente");
	   
	   
	   /*
	   Execution.insertAchat(carnet.getAchats(), ad);
	   Execution.insertAchat(carnet.getAchats(), aa);
	  Execution.insertAchat(carnet.getAchats(), ab);
	  Execution.insertAchat(carnet.getAchats(), ac);
	 // System.out.println(carnet.getAchats());*/
	  
	  //Execution.recachat(carnet.getAchats(), bc);
	  
	  //System.out.println(carnet.getAchats());
	   
	   //Execution.insertVente(carnet.getVentes(), ba);
	  // Execution.insertVente(carnet.getVentes(), bb);
	 //  Execution.insertVente(carnet.getVentes(), bc);
	 //  Execution.insertVente(carnet.getVentes(), bd);
	   
	   
	   
	   
	 /*
	  //  System.out.println(carnet.getVentes());
	 // System.err.println(aa);
	   System.out.println(carnet.getAchats());
	
	   Exx.recachat(carnet.getAchats(), ba);
	   
	  // System.out.println(carnet.getVentes());
	   
	   
	   System.out.println(carnet.getAchats());
	 //  System.err.println(carnet.getAchats());
	  //
	   
	   */
	   int ex=0;
	   int v=0;
	   int ah=0;
	  
	  for(int index=0;index<100000;index++){
		   if(aleatoire(50)){
			   double l=prix(40,50);
			   int m=k.nextInt(47)+89;
		   Ordre ach = new AchatN(1,l,m,55,new Date(),"achat");
		   Execution.insertAchat(carnet.getAchats(), ach);
		   ah++;
		 //  System.err.println(m+"\t\t"+l);
		   }else{
			   v++;
			   double l=prix(40,50);
			   int m=k.nextInt(47)+89;
		   Ordre ven = new Vente(1,l,m,55,new Date(),"vente");
		   Execution.insertVente(carnet.getVentes(), ven);
		 // System.out.println(m+"\t\t"+l);
		   }
		   System.err.println(carnet.getAchats());
		   
		   if(carnet.getVentes().size()>0 && carnet.getAchats().size()>0){
		   Ordre gvente=carnet.getVentes().get(0);
		   Ordre fachat=carnet.getAchats().get(0);
		   
		   //System.out.println(carnet.getAchats());
		   //System.out.println(carnet.getVentes());
		 //  System.out.println(carnet.getVentes().get(0));
		  // System.err.println(carnet.getAchats().get(0));
		   if(gvente.getPrix()>=fachat.getPrix()){
			  // System.out.println(gvente);
			  /// System.err.println(fachat);
			   System.err.println(carnet.getAchats());
			   Execution.rec(carnet.getVentes(), fachat);
			   Execution.recachat(carnet.getAchats(), gvente);
			  // System.err.println("exe");
			   
			   System.out.println(carnet.getAchats());
			 //  System.out.println(carnet.getVentes());
			   ex++;
		   }
		   
		  
		 //  System.out.println("no");
		  Thread.sleep(5);
		   }
		   else{
			   continue;
		   }
	   }

	System.out.println("finished with: "+ex+" execution\n vente "+v+" achat"+ah);
	  
	/*   for(int index=0;index<20;index++){
		   
		   System.err.println(r.nextInt(45)+r.nextDouble());
		   System.out.println(r.nextInt(45)+r.nextDouble());
		   
	   }*/
	   
	}
	
	public static double prix(int k,int l){
		Random m=new Random();
		return (m.nextInt(l-k)+k)+m.nextDouble();
		
	}
	
	public static boolean aleatoire(int k){
		Random al= new Random();
		
		return al.nextInt(100)<=k;
		
	}
}
