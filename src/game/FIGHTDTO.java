package game;
//전투
public class FIGHTDTO {

	private String NICNAME;
	private String MONNAME;
	public String getNICNAME() {
		return NICNAME;
	}
	public void setNICNAME(String nICNAME) {
		NICNAME = nICNAME;
	}
	public String getMONNAME() {
		return MONNAME;
	}
	public void setMONNAME(String mONNAME) {
		MONNAME = mONNAME;
	}
	@Override
	public String toString() {
		return "FIGHTDTO [NICNAME=" + NICNAME + ", MONNAME=" + MONNAME + "]";
	}
	
	
}
