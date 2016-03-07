package data;

import java.util.Random;

public class RandomMain {
	public static void main(String []args){
		
		Random r= new Random();
		Random g= new Random();
		for(int index =0; index <5; index ++){
			System.out.println(r.nextInt(89)+g.nextDouble());
		//	System.err.println(g.nextInt(89));
		}
		
	}
}
