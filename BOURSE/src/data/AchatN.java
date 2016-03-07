package data;

import java.util.Date;

public class AchatN extends Ordre {

	public AchatN(long iD, double prix, int quantitée, long idOrdre, Date date, String type) {
		super(iD, prix, quantitée, idOrdre, date, type);
		
	}

	
	

	@Override
	public String getType() {
		
		return "achat";
	}

}
