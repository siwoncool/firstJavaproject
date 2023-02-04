package game;
//인벤토리
import java.util.Arrays;

public class INVENTORYDTO {

	private String NICNAME;
	private int num=5;
	private int[] mednum = new int[num];
	
	
	
	public String getNICNAME() {
		return NICNAME;
	}
	public void setNICNAME(String nICNAME) {
		NICNAME = nICNAME;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int[] getMednum() {
		return mednum;
	}
	public void setMednum(int[] mednum) {
		this.mednum = mednum;
	}
	@Override
	public String toString() {
		return "INVENTORYDTO [NICNAME=" + NICNAME + ", num=" + num + ", mednum=" + Arrays.toString(mednum) + "]";
	}
	
	
	
}
