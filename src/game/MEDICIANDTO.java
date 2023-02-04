package game;

import java.util.Arrays;

public class MEDICIANDTO {
	int count=7;
	private int[] MEDNUM = new int[count];
	private String[] MEDTYPE= new String [count];
	private int[] MEDBUY= new int [count];
	private int[] MEDSELL= new int [count];
	private int[] MEDHP = new int [count];
	private int[] MEDMP = new int [count];
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int[] getMEDNUM() {
		return MEDNUM;
	}
	public void setMEDNUM(int[] mEDNUM) {
		MEDNUM = mEDNUM;
	}
	public String[] getMEDTYPE() {
		return MEDTYPE;
	}
	public void setMEDTYPE(String[] mEDTYPE) {
		MEDTYPE = mEDTYPE;
	}
	public int[] getMEDBUY() {
		return MEDBUY;
	}
	public void setMEDBUY(int[] mEDBUY) {
		MEDBUY = mEDBUY;
	}
	public int[] getMEDSELL() {
		return MEDSELL;
	}
	public void setMEDSELL(int[] mEDSELL) {
		MEDSELL = mEDSELL;
	}
	public int[] getMEDHP() {
		return MEDHP;
	}
	public void setMEDHP(int[] mEDHP) {
		MEDHP = mEDHP;
	}
	public int[] getMEDMP() {
		return MEDMP;
	}
	public void setMEDMP(int[] mEDMP) {
		MEDMP = mEDMP;
	}
	@Override
	public String toString() {
		return "MEDICIANDTO [count=" + count + ", MEDNUM=" + MEDNUM + ", MEDTYPE=" + MEDTYPE + ", MEDBUY=" + MEDBUY
				+ ", MEDSELL=" + MEDSELL + ", MEDHP=" + MEDHP + ", MEDMP=" + MEDMP + "]";
	}
	
	
	
	
}