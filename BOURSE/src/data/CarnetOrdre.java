package data;

import java.util.ArrayList;

public class CarnetOrdre  {
	
	private ArrayList<Ordre> ventes;
	private ArrayList<Ordre> achats;

	 public CarnetOrdre() {
		
		this.ventes = new ArrayList<Ordre>();
		this.achats = new ArrayList<Ordre>();
	}
	
	 
	 
	 
	public ArrayList<Ordre> getVentes() {
		return ventes;
	}
	public void setVentes(ArrayList<Ordre> ventes) {
		this.ventes = ventes;
	}
	public ArrayList<Ordre> getAchats() {
		return achats;
	}
	public void setAchats(ArrayList<Ordre> achats) {
		this.achats = achats;
	}
	    
	 
}
