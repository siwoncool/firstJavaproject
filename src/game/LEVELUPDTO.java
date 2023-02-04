package game;


public class LEVELUPDTO {

	private int LV;
	private int LVSTUPhp;
	private int LVSTUPmp;
	private int LVSTUPattack;
	private int LVSTUPshield;
	private int LVSTUPevasion;
	private int LVSTUPcritical;
	private int NEEDLVUP;
	public int getLV() {
		return LV;
	}
	public void setLV(int lV) {
		LV = lV;
	}
	public int getLVSTUPhp() {
		return LVSTUPhp;
	}
	public void setLVSTUPhp(int lVSTUPhp) {
		LVSTUPhp = lVSTUPhp;
	}
	public int getLVSTUPmp() {
		return LVSTUPmp;
	}
	public void setLVSTUPmp(int lVSTUPmp) {
		LVSTUPmp = lVSTUPmp;
	}
	public int getLVSTUPattack() {
		return LVSTUPattack;
	}
	public void setLVSTUPattack(int lVSTUPattack) {
		LVSTUPattack = lVSTUPattack;
	}
	public int getLVSTUPshield() {
		return LVSTUPshield;
	}
	public void setLVSTUPshield(int lVSTUPshield) {
		LVSTUPshield = lVSTUPshield;
	}
	public int getLVSTUPevasion() {
		return LVSTUPevasion;
	}
	public void setLVSTUPevasion(int lVSTUPevasion) {
		LVSTUPevasion = lVSTUPevasion;
	}
	public int getLVSTUPcritical() {
		return LVSTUPcritical;
	}
	public void setLVSTUPcritical(int lVSTUPcritical) {
		LVSTUPcritical = lVSTUPcritical;
	}
	public int getNEEDLVUP() {
		return NEEDLVUP;
	}
	public void setNEEDLVUP(int nEEDLVUP) {
		NEEDLVUP = nEEDLVUP;
	}
	@Override
	public String toString() {
		return "LEVELUPDTO [LV=" + LV + ", LVSTUPhp=" + LVSTUPhp + ", LVSTUPmp=" + LVSTUPmp + ", LVSTUPattack="
				+ LVSTUPattack + ", LVSTUPshield=" + LVSTUPshield + ", LVSTUPevasion=" + LVSTUPevasion
				+ ", LVSTUPcritical=" + LVSTUPcritical + ", NEEDLVUP=" + NEEDLVUP + "]";
	}
	
	
}