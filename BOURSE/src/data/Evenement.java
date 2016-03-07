package data;

public class Evenement {
	private String nevent;
	private long val;
	

	public Evenement(String nevent, long val) {
		
		this.nevent = nevent;
		this.val = val;
	}
	
	public String getNevent() {
		return nevent;
	}
	public void setNevent(String nevent) {
		nevent = nevent;
	}
	public long getVal() {
		return val;
	}
	public void setVal(long val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "[nevent=" + nevent + ", val=" + val + "]";
	}

}
