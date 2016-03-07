package data;

import java.util.Date;

public class Vente extends Ordre{

	public Vente(long iD, double prix, int quantitée, long idOrdre, Date date, String type) {
		super(iD, prix, quantitée, idOrdre, date, type);
		
	}

	
	public String getType() {
	
		return "vente";
	}

}
