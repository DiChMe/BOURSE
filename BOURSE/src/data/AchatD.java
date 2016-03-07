package data;

import java.util.Date;

public class AchatD extends Ordre {

	public AchatD(long iD, double prix, int quantitée, long idOrdre, Date date, String type) {
		super(iD, prix, quantitée, idOrdre, date, type);
		setPrix(-1);
	}

	
	

	@Override
	public String getType() {
		
		return "achat";
	}

}
