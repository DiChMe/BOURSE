package data;

import java.util.Date;


public abstract class Ordre implements Comparable {
	private long ID;
	private double prix;
	private int quantitée;
    private long idOrdre;
    private Date date;
    private String type;
    
    
    

	public Ordre(long iD, double prix, int quantitée, long idOrdre, Date date, String type) {
		
		ID = iD;
		this.prix = prix;
		this.quantitée = quantitée;
		this.idOrdre = idOrdre;
		this.date = date;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "[" + "" + prix + "\t" + quantitée +"]";
	}

	@Override
	public int compareTo(Object o) {
		Ordre other= (Ordre) o;
		
		if(getPrix()>other.getPrix()){
			return 1;
		}
		else{
			if(getPrix()<other.getPrix()){
				return -1;
			}else{
				return getDate().compareTo(other.getDate());
			}
			
		}
		
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	
	
	
	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantitée() {
		return quantitée;
	}
	public void setQuantitée(int quantitée) {
		this.quantitée = quantitée;
	}
	public long getIdOrdre() {
		return idOrdre;
	}
	public void setIdOrdre(long idOrdre) {
		this.idOrdre = idOrdre;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
public abstract String getType();
	
	public void setType(String type) {
		this.type = type;
	}

}
