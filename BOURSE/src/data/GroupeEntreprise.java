package data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class GroupeEntreprise {
	
	
	private ArrayList<Entreprise> entreprises;
	
	public GroupeEntreprise(){
		 
		entreprises=new  ArrayList<Entreprise>();
		
	}

	@Override
	public String toString() {
		return "GroupeEntreprise [entreprises=" + entreprises + "]";
	}

	public ArrayList<Entreprise> getEntreprises() {
		return entreprises;
	}

	public void setEntreprises(ArrayList<Entreprise> entreprises) {
		this.entreprises = entreprises;
	}
	
	public boolean addEntrprise(Entreprise entreprise){
		
		if(entreprises.contains(entreprise)){
			return false;
		}
		else{
		entreprises.add(entreprise);
		return true;
		}
	}
	public void addEvenementParType(Evenement event,String type){
		
		
		
		for(Entreprise en:entreprises){
			if(en.getType().equals(type)){
				en.addEvenements(event);
			}
				
		}	
		
	}
	
public void addEvenementPourEntreprise(Evenement event,Entreprise entreprise){
		
		 entreprises.get((int)entreprise.getID()).addEvenements(event);
		 
	}

public long size() {
	
	return getEntreprises().size();
}

	
}


