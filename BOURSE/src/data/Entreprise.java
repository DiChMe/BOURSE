package data;

import java.util.HashMap;

public class Entreprise {
	
	private String Nom;
	private long ID;
	private double capital;
	private HashMap<String,Evenement> evenements = new HashMap<String, Evenement>();
	
	private CarnetOrdre carnetorder= new CarnetOrdre();
	private String type;
	
	public Entreprise(String nom, long iD, double capital,String type) {
		super();
		Nom = nom;
		ID = iD;
		this.capital = capital;
		this.type=type;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getNom() {
		return Nom;
	}


	public void setNom(String nom) {
		Nom = nom;
	}


	public long getID() {
		return ID;
	}


	public void setID(long iD) {
		ID = iD;
	}


	public double getCapital() {
		return capital;
	}


	public CarnetOrdre getCarnetorder() {
		return carnetorder;
	}


	@Override
	public String toString() {
		return Nom ;
	}


	public void setCarnetorder(CarnetOrdre carnetorder) {
		this.carnetorder = carnetorder;
	}


	public void setEvenements(HashMap<String, Evenement> evenements) {
		this.evenements = evenements;
	}


	public void setCapital(double capital) {
		this.capital = capital;
	}


	public HashMap<String, Evenement> getEvenements() {
		return evenements;
	}


	public void addEvenements( Evenement evenement) {
		evenements.put(evenement.getNevent(), evenement);
	}

	
	
	
}
